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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import pl.wojciechantosiewicz.fractals.ExecutionControl;
import pl.wojciechantosiewicz.fractals.ifs.IFSFractal;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class IFSDrawingOptionsPanel extends IFSCommonOptionsPanel {
	// ~ Instance fields ----------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** DOCUMENT ME! */
	JPanel numberOfPointsPanel = new JPanel();

	/** DOCUMENT ME! */
	TitledBorder titledBorder5;

	JButton drawButton = new JButton();

	JButton stopButton = new JButton();

	/**
	 * Creates a new IFSDrawingOptionsPanel object.
	 */
	public IFSDrawingOptionsPanel() {
		super();

		titledBorder5 = new TitledBorder(BorderFactory.createEtchedBorder(), "Number of points");
		titledBorder5.setTitleJustification(TitledBorder.CENTER);
		titledBorder5.setTitleColor(new Color(0, 0, 128));
		numberOfPointsPanel.setBorder(titledBorder5);

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

		numberOfPointsPanel.add(numberOfPointsComboBox, null);
		numberOfPointsPanel.add(liczPunktL1, null);
		numberOfPointsPanel.add(exponentLabel, null);

		this.add(numberOfPointsPanel, new GridBagConstraints(0, 4, 2, 1, 1.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));

		drawButton.setText("Draw");
		drawButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0){
				ExecutionControl.getInstance().drawIterated();
			}

		});
		this.add(drawButton, new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5,
				20, 0, 10), 0, 0));

		stopButton.setText("Stop");
		stopButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0){
				ExecutionControl.getInstance().stopIterated();
			}
		});

		this.add(stopButton, new GridBagConstraints(1, 5, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5,
				10, 0, 10), 0, 0));
	}

	public IFSFractal getFractal(){
		return (IFSFractal)ifsFractalComboBox.getSelectedItem();
	}

	public boolean getDrawingMethod(){
		if(iteratedMethodRadioButton.isSelected()){
			return true;
		}else
			return false;
	}

	public int getNumberOfPoints() throws NumberFormatException{
		String value = (String)numberOfPointsComboBox.getModel().getSelectedItem();
		try{
			int intValue = Integer.parseInt(value);
			return intValue * 100000;
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(this, "Error", "Inserted number of points is invalid", JOptionPane.ERROR_MESSAGE);
			throw nfe;
		}
	}
}
