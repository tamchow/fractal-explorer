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
 */
package pl.wojciechantosiewicz.fractals.gui.ifs;

import java.awt.Color;
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

import pl.wojciechantosiewicz.fractals.Fraktale;

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