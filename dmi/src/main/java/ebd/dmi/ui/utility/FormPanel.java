package ebd.dmi.ui.utility;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A panel that lays out form elements.
 */
public class FormPanel extends JPanel {

	private static final long serialVersionUID = 8584971849620984330L;
	private final List<JTextComponent> textComponents = new ArrayList<JTextComponent>();
	private int nextRow = 0;

	private int rowSpacing;
	private int spacing;


	public FormPanel() {
		this(5, 5);
	}


	public FormPanel(int hgap, int vgap) {
		setLayout(new GridBagLayout());
		this.spacing = hgap;
		this.rowSpacing = vgap;
		setOpaque(false);
	}


	/**
	 * Adds an invisible empty row, about the height of a normal row's
	 * descriptive text.
	 */
	public void addEmptyRow() {
		addRow(" ", new JLabel(""));
	}


	/**
	 * Adds a row consisting of just a component. This component will take up
	 * the entire row, including the space usually reserved for a label.
	 */
	public void addWideRow(Component component) {
		addRow((JLabel) null, component);
	}


	/**
	 * Adds a row consisting of a label and a corresponding component. If you
	 * want an empty label, use "". (This is the more common case.) If you don't
	 * want even a space for a label, and want 'component' to take up the entire
	 * row, use null. FIXME: it would probably be better to refactor so that the
	 * basic dialog stuff takes a JComponent content pane, and FormPanel is just
	 * one possible content pane.
	 */
	public void addRow(String text, Component component) {
		JLabel label = null;
		if (text != null) {
			label = new JLabel(text);
		}
		addRow(label, component);
	}


	/**
	 * Adds a row consisting of a label and a corresponding component. If you
	 * want an empty label, use "". (This is the more common case.) If you don't
	 * want even a space for a label, and want 'component' to take up the entire
	 * row, use null. FIXME: it would probably be better to refactor so that the
	 * basic dialog stuff takes a JComponent content pane, and FormPanel is just
	 * one possible content pane.
	 */
	public void addRow(JLabel label, Component component) {
		// Text components are automatically listened to for changes; see
		// setTypingTimeoutAction.
		addTextComponentChildren(component);

		// We want space between components, but don't want to waste space above
		// the first
		// component.
		// We assume that the enclosing dialog (or whatever) is going to have
		// its own spacing.
		int spaceAbove = this.nextRow == 0 ? 0 : this.rowSpacing;

		// Add the label, unless the caller doesn't want one.
		int gridx = 0;
		if (label != null) {
			label.setLabelFor(component);

			// We also want padding to the right of labels, so there's space
			// between the label and
			// its component.
			final Insets insets = new Insets(spaceAbove, 0, 0, this.spacing);

			GridBagConstraints labelConstraints = new GridBagConstraints();
			labelConstraints.gridx = gridx++;
			labelConstraints.gridy = this.nextRow;
			labelConstraints.insets = insets;
			labelConstraints.anchor = component instanceof JScrollPane ? GridBagConstraints.NORTHEAST : GridBagConstraints.EAST;
			labelConstraints.fill = GridBagConstraints.NONE;
			add(label, labelConstraints);
		}

		// Add the component with its constraints
		GridBagConstraints componentConstraints = new GridBagConstraints();
		componentConstraints.gridx = gridx++;
		componentConstraints.gridy = this.nextRow;
		componentConstraints.gridwidth = GridBagConstraints.REMAINDER;
		componentConstraints.insets = new Insets(spaceAbove, 0, 0, 0);
		componentConstraints.weightx = 1.0;
		if (component instanceof JCheckBox) {
			// FIXME: we should have a better mechanism for component-specific
			// spacing.
			componentConstraints.insets.top = 4;
		}
		if (component instanceof JScrollPane) {
			/*
			 * A scrollable component in a form can likely make use of
			 * additional vertical space.
			 */
			componentConstraints.weighty = 1.0;
		}
		componentConstraints.anchor = GridBagConstraints.LINE_START;
		if (component instanceof JButton == false) {
			// Buttons shouldn't be stretched, but everything else may as well
			// use all available
			// space?
			componentConstraints.fill = GridBagConstraints.BOTH;
		}
		add(component, componentConstraints);

		this.nextRow++;
	}


	public void addCenterRow(String text, Component component) {
		// Text components are automatically listened to for changes; see
		// setTypingTimeoutAction.
		addTextComponentChildren(component);

		// We want space between components, but don't want to waste space above
		// the first
		// component.
		// We assume that the enclosing dialog (or whatever) is going to have
		// its own spacing.
		int spaceAbove = this.nextRow == 0 ? 0 : this.rowSpacing;

		// Add the label, unless the caller doesn't want one.
		int gridx = 0;
		if (text != null) {
			JLabel label = new JLabel(text);
			label.setLabelFor(component);

			// We also want padding to the right of labels, so there's space
			// between the label and
			// its component.
			final Insets insets = new Insets(spaceAbove, 0, 0, this.spacing);

			GridBagConstraints labelConstraints = new GridBagConstraints();
			labelConstraints.gridx = gridx++;
			labelConstraints.gridy = this.nextRow;
			labelConstraints.insets = insets;
			labelConstraints.anchor = GridBagConstraints.NORTHEAST;
			labelConstraints.fill = GridBagConstraints.NONE;
			add(label, labelConstraints);
		}

		// Add the component with its constraints
		GridBagConstraints componentConstraints = new GridBagConstraints();
		componentConstraints.gridx = gridx++;
		componentConstraints.gridy = this.nextRow;
		componentConstraints.gridwidth = GridBagConstraints.REMAINDER;
		componentConstraints.insets = new Insets(spaceAbove, 0, 0, 0);
		componentConstraints.weightx = 1.0;
		componentConstraints.weighty = 1.0;
		if (component instanceof JCheckBox) {
			// FIXME: we should have a better mechanism for component-specific
			// spacing.
			componentConstraints.insets.top = 4;
		}
		componentConstraints.anchor = GridBagConstraints.LINE_START;
		if (component instanceof JButton == false) {
			// Buttons shouldn't be stretched, but everything else may as well
			// use all available
			// space?
			componentConstraints.fill = GridBagConstraints.BOTH;
		}
		add(component, componentConstraints);

		this.nextRow++;
	}


	/**
	 * Recursively add the JTextComponent children of the given component to our
	 * textComponents collection.
	 */
	private void addTextComponentChildren(Component component) {
		addTextComponent(component);
		if (component instanceof Container) {
			for (Component child : ((Container) component).getComponents()) {
				addTextComponent(child);
				addTextComponentChildren(child);
			}
		}
	}


	private void addTextComponent(Component component) {
		if (component instanceof JTextComponent) {
			this.textComponents.add((JTextComponent) component);
		}
	}


	ArrayList<JTextComponent> getTextComponents() {
		return new ArrayList<JTextComponent>(this.textComponents);
	}
}
