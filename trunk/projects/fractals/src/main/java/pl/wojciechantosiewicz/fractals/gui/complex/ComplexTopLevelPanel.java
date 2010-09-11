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
package pl.wojciechantosiewicz.fractals.gui.complex;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import pl.wojciechantosiewicz.fractals.complex.ComplexFractal;
import pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula;
import pl.wojciechantosiewicz.fractals.gui.complex.convergent.ConvergentOptionsPanel;
import pl.wojciechantosiewicz.fractals.gui.complex.divergent.DivergentOptionsPanel;
import pl.wojciechantosiewicz.fractals.palette.FractalPalette;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class ComplexTopLevelPanel extends JPanel {
	// ~ Static fields/initializers -----------------------------------------------------------------------------------
	private final String componentInfo = "ComplexTopLevelPanel";
	/**  */
	private static final long serialVersionUID = -5994742954662939120L;

	private ComplexFractalDrawer complexFractalDrawer;
	private JTabbedPane complexFractalTypeTabbedPane;
//	private DivergentOptionsPanel divergentOptionsPanel;
//	private ConvergentOptionsPanel convergentOptionsPanel;

	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new ComplexTopLevelPanel object.
	 * 
	 */
	public ComplexTopLevelPanel() {
		super();
		complexFractalTypeTabbedPane = new JTabbedPane();
//		divergentOptionsPanel = new DivergentOptionsPanel();
//		convergentOptionsPanel = new ConvergentOptionsPanel();
		
		this.setToolTipText(componentInfo);
		complexFractalDrawer = new ComplexFractalDrawer();
		this.setLayout(new GridBagLayout());

		complexFractalTypeTabbedPane.addTab("Divergent", new DivergentOptionsPanel());//divergentOptionsPanel);
		complexFractalTypeTabbedPane.addTab("Convergent", new ConvergentOptionsPanel());// convergentOptionsPanel);

		this.add(complexFractalDrawer, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		this.add(complexFractalTypeTabbedPane, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.VERTICAL, new Insets(0, 3, 0, 3), 0, 0));
	}

	// ~ Methods ------------------------------------------------------------------------------------------------------

	/**
	 * @return the complexFractalDrawer
	 */
	public ComplexFractalDrawer getComplexFractalDrawer(){
		return complexFractalDrawer;
	}

	public ComplexFractal getComplexFractal(){
		return ((ComplexCommonOptionsPanel)
				complexFractalTypeTabbedPane.getSelectedComponent()).getFractal();
	}

	public FractalPalette getPalette(){
		return ((ComplexCommonOptionsPanel)
				complexFractalTypeTabbedPane.getSelectedComponent()).getPalette();
	}

	public boolean isPreviewEnabled(){
		return ((ComplexCommonOptionsPanel)
				complexFractalTypeTabbedPane.getSelectedComponent()).isPreviewEnabled();
	}

	public IComplexFormula getFormula(){
		return ((ComplexCommonOptionsPanel)
				complexFractalTypeTabbedPane.getSelectedComponent()).getFormula();
	}
}
