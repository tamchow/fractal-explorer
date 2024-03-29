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
package pl.wojciechantosiewicz.fractals.complex.divergent;

import org.jscience.mathematics.numbers.Complex;

import pl.wojciechantosiewicz.fractals.complex.formula.ComplexFormula;
import pl.wojciechantosiewicz.fractals.complex.formula.FormulaProperties;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.trigonometric.Cosinus;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.trigonometric.Sinus;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class TrygonometricJulia extends DivergentFractal {
	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new TrygJulia object.
	 */
	public TrygonometricJulia() {
		super(new String("Trigonometric Julia"), 20);

		Complex[] points = new Complex[] { new Complex(1.0, 0.0), new Complex(1.0, 0.2), new Complex(1.0, 0.4), new Complex(1.0, 0.5),
				new Complex(1.0, 0.7), new Complex(1.0, 1.0), new Complex(-5.26, 0.0), new Complex(-4.94, 0.24), new Complex(-4.77, 0.36),
				new Complex(-4.59, 0.0), new Complex(-2.73, 0.0), new Complex(-1.87, 0.77), new Complex(0.0, 1.4), new Complex(1.49, 0.98),
				new Complex(0.0, 1.71), new Complex(0.0, 1.76), new Complex(2.135, 1.31), new Complex(3.72, 0.22) };
		FormulaProperties fp = new FormulaProperties(-2 * Math.PI, 2 * Math.PI, -2 * Math.PI, 2 * Math.PI);
		fp.setPoints(points);
		
		
		ComplexFormula tmpFormula = new Sinus(fp);
		tmpFormula.setConstant(points[0]);
		formulas.add(tmpFormula);
		// ##############################################################################
		points = new Complex[] { new Complex(1.0, 0.0), new Complex(1.0, 0.2), new Complex(1.0, 0.3), new Complex(1.0, 0.4),
				new Complex(1.0, 0.5), new Complex(-3.9, 0.0), new Complex(-2.98, 0.314), new Complex(-2.64, 0.73),
				new Complex(-2.94, 0.0), new Complex(-2.98, 0.304), new Complex(-2.72, 0.0), new Complex(-2.33, 0.009),
				new Complex(-2.22, -0.333), new Complex(-1.957, -0.029), new Complex(-1.71, -0.28), new Complex(-1.84, 0.095),
				new Complex(1.53, 0.736), new Complex(1.297, 1.05) };
		fp = new FormulaProperties(-2 * Math.PI, 2 * Math.PI, -2 * Math.PI, 2 * Math.PI);
		fp.setPoints(points);
		
		tmpFormula = new Cosinus(fp);
		tmpFormula.setConstant(points[0]);
		formulas.add(tmpFormula);

		this.formula = formulas.get(0);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param u
	 *        DOCUMENT ME!
	 * @param v
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	@Override
	public final int rgbColor(final double u, final double v){
		Complex z = Complex.valueOf(u, v);

		for(int i = 0; i < palette.getSize(); i++){
			z = formula.calculate(z);

			if(z.magnitude() > radius){
				return palette.getRGB(i);
			}
		}

		return RGB_BLACK;
	}
}
