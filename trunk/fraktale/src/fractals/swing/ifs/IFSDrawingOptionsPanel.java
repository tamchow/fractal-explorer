/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * $Id$
 */
package fractals.swing.ifs;

import fractals.Fraktale;
import fractals.ifs.IFSFractal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
 */
public class IFSDrawingOptionsPanel extends JPanel {
    //~ Instance fields ----------------------------------------------------------------------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** DOCUMENT ME! */
    JRadioButton iteratedMethodRadioButton = new JRadioButton();

    /** DOCUMENT ME! */
    JRadioButton recurentMethodRadioButton = new JRadioButton();

    /** DOCUMENT ME! */
    JPanel jPanel4 = new JPanel();

    /** DOCUMENT ME! */
    TitledBorder titledBorder3;

    /** DOCUMENT ME! */
    ButtonGroup drawingMethodButtonGroup = new ButtonGroup();

    /** DOCUMENT ME! */
    JComboBox ifsFractalComboBox = new JComboBox(Fraktale.ifsFractals);

    /** DOCUMENT ME! */
    GridBagLayout gridBagLayout4 = new GridBagLayout();

    /** DOCUMENT ME! */
    JPanel jPanel6 = new JPanel();

    /** DOCUMENT ME! */
    TitledBorder titledBorder5;

    /** DOCUMENT ME! */
    JLabel liczPunktL1 = new JLabel();

    /** DOCUMENT ME! */
    JComboBox numberOfPointsComboBox = new JComboBox(
            new String[] { "1", "2", "5", "10", "15", "20", "30", "40", "50", "100", "200" });

    /** DOCUMENT ME! */
    JLabel exponentLabel = new JLabel();

    //~ Constructors -------------------------------------------------------------------------------------------------

    /**
     * Creates a new IFSDrawingOptionsPanel object.
     */
    public IFSDrawingOptionsPanel() {
        super();
        iteratedMethodRadioButton.setSelected(true);
        iteratedMethodRadioButton.setText("Iterated");
        recurentMethodRadioButton.setText("Recurent");

        titledBorder3 = new TitledBorder(BorderFactory.createEtchedBorder(), "Drawing Method");
        titledBorder3.setTitleJustification(TitledBorder.CENTER);
        titledBorder3.setTitleColor(new Color(0, 0, 128));

        jPanel4.setBorder(titledBorder3);
        jPanel4.setMinimumSize(new Dimension(120, 100));
        jPanel4.setPreferredSize(new Dimension(120, 100));

        jPanel4.add(iteratedMethodRadioButton, null);
        jPanel4.add(recurentMethodRadioButton, null);

        drawingMethodButtonGroup.add(iteratedMethodRadioButton);
        drawingMethodButtonGroup.add(recurentMethodRadioButton);

        this.setLayout(gridBagLayout4);

        this.add(
            jPanel4,
            new GridBagConstraints(
                1, 0, 1, 1, 0.5, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(
                    0, 5, 5, 5), 0, 0));
        this.add(
            ifsFractalComboBox,
            new GridBagConstraints(
                0, 1, 2, 1, 0.8, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(
                    0, 5, 0, 5), 0, 0));

        titledBorder5 = new TitledBorder(BorderFactory.createEtchedBorder(), "Number of points");
        titledBorder5.setTitleJustification(TitledBorder.CENTER);
        titledBorder5.setTitleColor(new Color(0, 0, 128));
        jPanel6.setBorder(titledBorder5);

        numberOfPointsComboBox.setMaximumSize(new Dimension(100, 20));
        numberOfPointsComboBox.setMinimumSize(new Dimension(60, 20));
        numberOfPointsComboBox.setPreferredSize(new Dimension(80, 20));
        numberOfPointsComboBox.setEditable(true);
        exponentLabel.setFont(new java.awt.Font("Dialog", 1, 9));
        exponentLabel.setForeground(new Color(0, 0, 128));
        exponentLabel.setText("5");
        exponentLabel.setVerticalAlignment(SwingConstants.TOP);
        exponentLabel.setVerticalTextPosition(SwingConstants.TOP);
        liczPunktL1.setFont(new java.awt.Font("Dialog", 1, 10));
        liczPunktL1.setForeground(new Color(0, 0, 128));
        liczPunktL1.setHorizontalAlignment(SwingConstants.CENTER);
        liczPunktL1.setText("x 10");

        jPanel6.add(numberOfPointsComboBox, null);
        jPanel6.add(liczPunktL1, null);
        jPanel6.add(exponentLabel, null);

        this.add(
            jPanel6,
            new GridBagConstraints(
                0, 4, 2, 1, 1.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0),
                0, 0));
    }

	public IFSFractal getFractal() {
		return (IFSFractal) ifsFractalComboBox.getSelectedItem();
	}

	public boolean getDrawingMethod() {
		if(iteratedMethodRadioButton.isSelected()){
			return true;
		}else return false;
	}
	
	public int getNumberOfPoints() throws NumberFormatException{
		String value = (String) numberOfPointsComboBox.getModel().getSelectedItem();
		try{
			int intValue = Integer.parseInt(value);
			return intValue;
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(this, "Error", "Inserted number of points is invalid", JOptionPane.ERROR_MESSAGE);
			throw nfe;
		}
	}
}
