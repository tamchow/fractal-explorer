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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import pl.wojciechantosiewicz.fractals.ifs.IFSFractal;

public class IFSTopLevelPanel extends JPanel {
	// ~ Static fields/initializers -----------------------------------------------------------------------------------

	/**  */
	private static final long serialVersionUID = -2760787959913969690L;

	private GridBagLayout topLayout = new GridBagLayout();
	private IFSFractalDrawer ifsFractalDrawer = new IFSFractalDrawer();
	private IFSDrawingOptionsPanel ifsDrawingOptionsPanel = new IFSDrawingOptionsPanel();
	private IFSCommonOptionsPanel ifsAnimationOptionsPanel = new IFSAnimationOptionsPanel();
	private JTabbedPane ifsActionTabbedPane = new JTabbedPane();

	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new IFSTopLevelPanel object.
	 */
	public IFSTopLevelPanel() {
		super();
		setLayout(topLayout);

		ifsActionTabbedPane.add("Draw", ifsDrawingOptionsPanel);
		ifsActionTabbedPane.add("Animate", ifsAnimationOptionsPanel);

		ifsActionTabbedPane.setMinimumSize(new Dimension(200, 200));

		ifsFractalDrawer.setBorder(BorderFactory.createEtchedBorder());

		this.add(ifsFractalDrawer, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
				new Insets(3, 3, 3, 3), 0, 0));
		this.add(ifsActionTabbedPane, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.VERTICAL, new Insets(3, 3, 3, 3), 0, 0));
	}

	public IFSFractalDrawer getIFSFractalDrawer(){
		return ifsFractalDrawer;
	}

	public IFSFractal getIFSFractal(){
		return ifsDrawingOptionsPanel.getFractal();
	}

	// returns true for iterated method, false for recurent
	public boolean getMethod(){
		return ifsDrawingOptionsPanel.getDrawingMethod();
	}

	public int getNumberOfPoints() throws NumberFormatException{
		return ifsDrawingOptionsPanel.getNumberOfPoints();
	}
}
