package ebd.radioBlockCenter;

import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.radioBlockCenter.ReceivedTMSMessageEvent;
import ebd.globalUtils.events.radioBlockCenter.SendTMSMessageEvent;
import ebd.rbc_tms.Message;
import ebd.rbc_tms.Payload;
import ebd.rbc_tms.util.exception.MissingInformationException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TMSCommunicator extends Thread {

	public class TMSClientHandler implements Runnable {

		private Socket client;
		private BufferedReader in;
		private PrintWriter out;


		public TMSClientHandler(Socket clientSocket) throws IOException {
			this.client = clientSocket;
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
		}

		@Override
		public void run() {
			try {
				while(true) {
					StringBuilder data = new StringBuilder();
					while(in.ready()) {
						data.append(in.readLine());
					}
					System.out.println("RBC received: " + data.toString());

					try {
						// Generate Message
						Message<Payload> message = Message.generateFrom(data.toString());
						System.out.println("Received Message " + message.getHeader().type + " from " + message.getHeader().tms_id);
						_localBus.post(new ReceivedTMSMessageEvent(_moduleID, _tmsEndpointID, message));
					} catch(ClassNotFoundException e) {
						System.err.println(e.getMessage());
						e.printStackTrace();
						in.close();
						client.close();
					}
				}
			} catch(IOException e) {
				System.err.println("Could not establish connection with new client");
				e.printStackTrace();
			} finally {
				out.close();
				try {
					in.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private final String _moduleID      = "tmsServer";
	private final String _tmsEndpointID = "tmsEndpoint";
	private final String _ip            = "localhost";
	private final int    _tmsServerPort = 22223;
	private final int	 _rbcServerPort = 22224;

	EventBus _localBus;

	List<TMSClientHandler> clients = new ArrayList<>();

	ExecutorService pool = Executors.newCachedThreadPool();

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(_rbcServerPort);

			while(true){
				Socket client = server.accept();
				System.out.println(AppTime.currentTimeMillis());
				TMSClientHandler clientThread = new TMSClientHandler(client);
				clients.add(clientThread);
				pool.execute(clientThread);
			}
		} catch(IOException e) {
			System.err.println("TMS Communication Server could not be established on port " + _rbcServerPort);
			e.printStackTrace();
		}
	}

	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void sendMessage(@NotNull SendTMSMessageEvent event) {
		if(!Objects.equals(event.target, _moduleID)) return;

		try {
			Socket socket = new Socket(_ip, _tmsServerPort);
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			String messageJSON = event.message.parseToJson();
			output.print(messageJSON);
			System.out.println("RBC sending: " + messageJSON);

			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			StringBuilder data = new StringBuilder();
			while(input.ready()) {
				data.append(input.readLine());
			}

			System.out.println("RBC received: " + data.toString());
			Message response = Message.generateFrom(data.toString());

			_localBus.post(new ReceivedTMSMessageEvent(_moduleID, _tmsEndpointID, response));

			output.close();
			input.close();
			socket.close();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(MissingInformationException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
