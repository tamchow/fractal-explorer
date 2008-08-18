package fractals.swing.ifs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import fractals.Fraktale;

public class IFSCommonOptionsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** DOCUMENT ME! */
	protected JRadioButton iteratedMethodRadioButton = new JRadioButton();
	/** DOCUMENT ME! */
	protected JRadioButton recurentMethodRadioButton = new JRadioButton();
	/** DOCUMENT ME! */
	protected JPanel drawingMethodPanel = new JPanel();
	/** DOCUMENT ME! */
    protected TitledBorder drawingMethodTitledBorder;
	/** DOCUMENT ME! */
	protected ButtonGroup drawingMethodButtonGroup = new ButtonGroup();
	/** DOCUMENT ME! */
	protected JComboBox ifsFractalComboBox = new JComboBox(Fraktale.ifsFractals);
	/** DOCUMENT ME! */
	protected GridBagLayout gridBagLayout4 = new GridBagLayout();
	/** DOCUMENT ME! */
	protected JLabel liczPunktL1 = new JLabel();
	/** DOCUMENT ME! */
	protected JComboBox numberOfPointsComboBox = new JComboBox(
	            new String[] { "1", "2", "5", "10", "15", "20", "30", "40", "50", "100", "200" });
	/** DOCUMENT ME! */
	protected JLabel exponentLabel = new JLabel();

	public IFSCommonOptionsPanel() {
		super();
		iteratedMethodRadioButton.setSelected(true);
        iteratedMethodRadioButton.setText("Iterated");
        recurentMethodRadioButton.setText("Recurent");

        drawingMethodTitledBorder = new TitledBorder(BorderFactory.createEtchedBorder(), "Drawing Method");
        drawingMethodTitledBorder.setTitleJustification(TitledBorder.CENTER);
        drawingMethodTitledBorder.setTitleColor(new Color(0, 0, 128));

        drawingMethodPanel.setBorder(drawingMethodTitledBorder);
        drawingMethodPanel.add(iteratedMethodRadioButton, null);
        drawingMethodPanel.add(recurentMethodRadioButton, null);

        drawingMethodButtonGroup.add(iteratedMethodRadioButton);
        drawingMethodButtonGroup.add(recurentMethodRadioButton);

        this.setLayout(new GridBagLayout());

        this.add(
            drawingMethodPanel,
            new GridBagConstraints(
                0, 0, 2, 1, 1.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(
                    5, 5, 5, 5), 0, 0));
        this.add(
                ifsFractalComboBox,
                new GridBagConstraints(
                    0, 1, 2, 1, 0.8, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(
                        0, 5, 0, 5), 0, 0));
	}

}