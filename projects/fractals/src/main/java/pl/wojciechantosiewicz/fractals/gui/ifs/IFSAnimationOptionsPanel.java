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

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import pl.wojciechantosiewicz.fractals.ifs.IFSFractal;

public class IFSAnimationOptionsPanel extends IFSCommonOptionsPanel {
	// ~ Instance fields ----------------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** DOCUMENT ME! */
	JScrollPane jScrollPane2 = new JScrollPane();

	/** DOCUMENT ME! */
	JButton addFractalButton = new JButton();

	/** DOCUMENT ME! */
	JButton removeFractalButton = new JButton();

	/** DOCUMENT ME! */
	JList animationList = new JList(new DefaultListModel());

	/** DOCUMENT ME! */
	JPanel jPanel6 = new JPanel();

	/** DOCUMENT ME! */
	TitledBorder titledBorder5;

	/**
	 * Creates a new IFSAnimationOptionsPanel object.
	 */
	public IFSAnimationOptionsPanel() {
		super();

		addFractalButton.setEnabled(false);
		addFractalButton.setText("Add");
		addFractalButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				addFractal_actionPerformed(e);
			}
		});
		removeFractalButton.setEnabled(false);
		removeFractalButton.setText("Remove");
		removeFractalButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				removeFractal_actionPerformed(e);
			}
		});

		this.add(jScrollPane2, new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
				0, 5, 5, 5), 0, 0));
		this.add(addFractalButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(3, 20, 3, 5), 0, 0));
		this.add(removeFractalButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(3, 0, 3, 20), 0, 0));
		jScrollPane2.getViewport().add(animationList, null);

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

		this.add(jPanel6, new GridBagConstraints(0, 4, 2, 1, 1.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(
				0, 0, 0, 0), 0, 0));
	}

	// ~ Methods ------------------------------------------------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 * 
	 * @param e
	 *        DOCUMENT ME!
	 */
	void removeFractal_actionPerformed(ActionEvent e){
		if(animationList.getSelectedIndex() != -1){
			((DefaultListModel)animationList.getModel()).removeElementAt(animationList.getSelectedIndex());
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param e
	 *        DOCUMENT ME!
	 */
	void addFractal_actionPerformed(ActionEvent e){
		DefaultListModel dlm = (DefaultListModel)animationList.getModel();
		IFSFractal selFractal = null; // (FractalIFS)rodzajCB.getSelectedItem();

		if(dlm.isEmpty()){
			dlm.addElement(selFractal);
			animationList.repaint();
		}else{ // adding another fractal

			int przek = ((IFSFractal)dlm.getElementAt(0)).getTransformCount();

			if(przek != selFractal.getTransformCount()){
				JOptionPane.showMessageDialog(this, "Selected fractal has different number of transforms\nthan fractals selected earlier.",
						"Wrong fractal", JOptionPane.ERROR_MESSAGE);

				return;
			}

			if(dlm.contains(selFractal)){
				if(JOptionPane.showConfirmDialog(this, "Selected fractal is already in the lis.\nAdd it again?",
						"Same fractal confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION){
					dlm.addElement(selFractal);

					return;
				}
			}

			dlm.addElement(selFractal);
		}
	}
}
