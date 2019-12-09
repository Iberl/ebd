package ebd.baliseTelegramGenerator;

import ebd.messageLibrary.packet.trackpackets.Packet_5;
import ebd.messageLibrary.util.ETCSVariables;
import javafx.util.Pair;

import java.util.*;

import static ebd.messageLibrary.util.ETCSVariables.*;

public class ListOfBalises {

	// x Handles A List Of Balises That Describe The Track
	// x Adding
	// x Removing
	// x Linking
	// - Courses

	private int Q_SCALE;
	private int Q_LOCACC;

	private Map<Integer, BaliseGroup> baliseGroups = new HashMap<>();

	// TODO Implement Pair
	private Map<Integer, Pair<Integer, Integer>> connections = new HashMap<>();

	// First, Second: Nominal Direction
	private List<Pair<Integer, Integer>> links = new ArrayList<>();

	// Constructors

	public ListOfBalises(int Q_SCALE, int Q_LOCACC) {
		this.Q_SCALE = Q_SCALE;
		this.Q_LOCACC = Q_LOCACC;
	}

	public ListOfBalises(int Q_SCALE, int Q_LOCACC, Map<Integer, BaliseGroup> baliseGroups, Map<Integer, Pair<Integer, Integer>> connections, List<Pair<Integer, Integer>> links) {
		this.Q_SCALE = Q_SCALE;
		this.Q_LOCACC = Q_LOCACC;
		this.baliseGroups = baliseGroups;
		this.connections = connections;
		this.links = links;
	}

	// Methods


	public Collection<BaliseGroup> getBaliseGroups() { return baliseGroups.values(); }

	public void addBaliseGroup(BaliseGroup bg) { baliseGroups.put(bg.getNID_BG(), bg); }

	public BaliseGroup getBaliseGroup(int NID_BG) { return baliseGroups.get(NID_BG); }

	public boolean removeBaliseGroup(BaliseGroup bg) { return baliseGroups.remove(bg.getNID_BG(), bg); }

	public Pair<Integer, Integer> getConnectionsOf(int NID_BG) { return connections.get(NID_BG); }

	public Map<Integer, Pair<Integer, Integer>> getConnections() { return connections; }

	// Nominal Direction
	public boolean addConnection(int NID_BG1, int NID_BG2) {
		// Cannot Create an Link if the bgs dont exist
		if(!baliseGroups.containsKey(NID_BG1) || !baliseGroups.containsKey(NID_BG2)) return false;

		Pair<Integer, Integer> conn1 = new Pair<>(null, NID_BG2);
		Pair<Integer, Integer> conn2 = new Pair<>(NID_BG1, null);

		if(connections.containsKey(NID_BG1)) {
			if(connections.get(NID_BG1).getValue() != null) return false;
			conn1 = new Pair<>(connections.get(NID_BG1).getValue(), NID_BG2);
		}

		if(connections.containsKey(NID_BG2)) {
			if(connections.get(NID_BG2).getKey() != null) return false;
			conn2 = new Pair<>(NID_BG1, connections.get(NID_BG2).getValue());
		}

		connections.put(NID_BG1, conn1);
		connections.put(NID_BG2, conn2);
		return true;
	}

	public boolean removeConnection(int NID_BG1, int NID_BG2) {
		// Cannot Create an Link if the bgs dont exist
		if(!baliseGroups.containsKey(NID_BG1) || !baliseGroups.containsKey(NID_BG2)) return false;

		if(connections.containsKey(NID_BG1)) connections.put(NID_BG1, new Pair<>(null, connections.get(NID_BG1).getValue()));
		if(connections.containsKey(NID_BG2)) connections.put(NID_BG2, new Pair<>(null, connections.get(NID_BG2).getKey()));

		return true;
	}



	private boolean addLink(int NID_BG1, int NID_BG2, int D_LINK, boolean Q_LINKORIENTATION, int Q_LINKREACTION) {
		assert(Q_DIR >= 0 && Q_DIR <= 2);
		// Cannot Create an Link if the bgs dont exist
		if(!baliseGroups.containsKey(NID_BG1) || !baliseGroups.containsKey(NID_BG2)) return false;

		// Creating a new Link between BG1 and BG2
		Packet_5.Packet_5_Link link = new Packet_5.Packet_5_Link(D_LINK, Q_NEWCOUNTRY_SAME, NID_C, NID_BG2, Q_LINKORIENTATION, Q_LINKREACTION, Q_LOCACC);

		BaliseGroup bg = baliseGroups.get(NID_BG1);
		Packet_5 li;

		// Create a new Packet_5 if it does not exist
		if(bg.getLinkingInformation() == null) li = new Packet_5((Q_LINKORIENTATION ? Q_DIR_NOMINAL : Q_DIR_REVERSE), Q_SCALE, link);
		else {
			// get existing Packet_5
			li = bg.getLinkingInformation();

			if(li.link == link || li.links.contains(link)) return false;

			// Check on multiple directions
			// TODO: Unit test this line
			if(Q_LINKORIENTATION ^ (li.Q_DIR == Q_DIR_NOMINAL)) li.Q_DIR = Q_DIR_BOTH;

			if(li.link == null) li.link = link;
			else li.links.add(link);
			bg.setLinkingInformation(bg.getLinkingInformationBalise(), li);
		}

		// Add Link to List
		links.add(Q_LINKORIENTATION ? new Pair(NID_BG1, NID_BG2): new Pair(NID_BG2, NID_BG1));

		return true;
	}

	public List<Pair<Integer, Boolean>> getBalisesLinkedWith(int NID_BG) {
		List<Pair<Integer, Boolean>> bgs = new ArrayList<>();

		links.forEach(x -> {
			if(x.getKey() == NID_BG) bgs.add(new Pair(x.getValue(), ETCSVariables.Q_ORIENTATION_NOMINAL));
			if(x.getValue() == NID_BG) bgs.add(new Pair(x.getKey(), ETCSVariables.Q_ORIENTATION_REVERSE));
		});
		return bgs;
	}

	public boolean removeLink(int NID_BG1, int NID_BG2) {
		if(!links.remove(new Pair(NID_BG1, NID_BG2))) return false;

		Packet_5 li = baliseGroups.get(NID_BG1).getLinkingInformation();
		// links
		li.links.removeIf(l -> l.NID_BG == NID_BG2);
		// link
		if(li != null && li.link.NID_BG == NID_BG2 && !li.links.isEmpty()) {
			li.link = li.links.remove(0);
		}

		List<Packet_5.Packet_5_Link> linksToRemove = baliseGroups.get(NID_BG1).getLinkingInformation().links;
		linksToRemove.add(baliseGroups.get(NID_BG1).getLinkingInformation().link);

		// TODO Change This !!!!!!!
		linksToRemove.removeIf(x -> x.NID_BG == NID_BG2);
		return true;
	}

}
