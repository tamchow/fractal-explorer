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

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class FireShip extends DivergentFractal {
	private static final int RGB_BLACK = 0x000000;

	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new FireShip object.
	 */
	public FireShip() {
		super("Fire ship", 5.0);

		ComplexFormula form = new ComplexFormula(new FormulaProperties(-2.5, 2.0, -3.0, 2.5)) {
			public final Complex calculate(Complex z){
				double re2 = z.getReal() * z.getReal();
				double im2 = z.getImaginary() * z.getImaginary();

				return Complex.valueOf(re2 - im2 + constant.getReal(), (Math.abs(z.getReal() * z.getImaginary()) * 2)
						+ constant.getImaginary());
			}

			@Override
			public String toString(){
				return "|Z|^2 + C";
			}

		};

		formulas.add(form);
		formula = formulas.get(0);
	}

	// ~ Methods ------------------------------------------------------------------------------------------------------

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
	public int rgbColor(double u, double v){
		Complex z = Complex.valueOf(u, v);

		formula.setConstant(z);

		for(int i = 0; i < palette.getSize(); i++){
			z = formula.calculate(z);

			if(z.magnitude() > radius){
				return palette.getRGB(i);
			}
		}

		return RGB_BLACK;
	}
}
