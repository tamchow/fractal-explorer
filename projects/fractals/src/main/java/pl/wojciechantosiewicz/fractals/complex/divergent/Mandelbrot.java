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

import pl.wojciechantosiewicz.fractals.complex.formula.FormulaProperties;
import pl.wojciechantosiewicz.fractals.complex.formula.IPolynomialFormula;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_2;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_2_pls_Z;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_3;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_3_pls_Z_2;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_3_pls_Z_2_pls_Z;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_4;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_4_pls_Z_3;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_4_pls_Z_3_pls_Z_2;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_4_pls_Z_3_pls_Z_2_pls_Z;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_5;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_5_pls_Z_4;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_5_pls_Z_4_pls_Z_3;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_5_pls_Z_4_pls_Z_3_pls_Z_2;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_5_pls_Z_4_pls_Z_3_pls_Z_2_pls_Z;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_6;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials.Z_8;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class Mandelbrot extends DivergentFractal {
	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new Mandelbrot object.
	 */
	public Mandelbrot() {
		super(new String("Mandelbrot set"), 5);
		createFormulas();
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
	public final int rgbColor(final double u, final double v){
		Complex z = Complex.valueOf(u, v);
		formula.setConstant(z);

		double magn = 0;

		for(int i = 1; i < palette.getSize(); i++){
			z = formula.calculate(z);
			magn = z.magnitude();

			if(magn > radius){
				float position = i - (float)(Math.log10(Math.log10(magn)) / Math.log(((IPolynomialFormula)formula).getOrder()));
				position /= (palette.getSize() - 1);

				return palette.getRGB(position);
			}
		}

		return 0x000000;
	}

	// ********************************************************************************
	/**
	 * DOCUMENT ME!
	 */
	private void createFormulas(){
		formulas.add(new Z_2(new FormulaProperties(-2.2, 1.0, -1.6, 1.6)));
		formulas.add(new Z_2_pls_Z(new FormulaProperties(-3.0, 0.8, -1.5, 1.5)));
		formulas.add(new Z_3(new FormulaProperties(-1.5, 1.5, -1.5, 1.5)));
		formulas.add(new Z_3_pls_Z_2(new FormulaProperties(-2.5, 1.5, -1.5, 1.5)));
		formulas.add(new Z_3_pls_Z_2_pls_Z(new FormulaProperties(-2.0, 1.5, -1.6, 1.6)));
		formulas.add(new Z_4(new FormulaProperties(-1.7, 1.2, -1.5, 1.5)));
		formulas.add(new Z_4_pls_Z_3(new FormulaProperties(-1.8, 1.1, -1.5, 1.5)));
		formulas.add(new Z_4_pls_Z_3_pls_Z_2(new FormulaProperties(-1.5, 0.9, -1.5, 1.5)));
		formulas.add(new Z_4_pls_Z_3_pls_Z_2_pls_Z(new FormulaProperties(-1.7, 0.8, -1.5, 1.5)));
		formulas.add(new Z_5(new FormulaProperties(-1.5, 1.5, -1.5, 1.5)));
		formulas.add(new Z_5_pls_Z_4(new FormulaProperties(-1.5, 1.0, -1.25, 1.25)));
		formulas.add(new Z_5_pls_Z_4_pls_Z_3(new FormulaProperties(-1.5, 1.0, -1.25, 1.25)));
		formulas.add(new Z_5_pls_Z_4_pls_Z_3_pls_Z_2(new FormulaProperties(-1.5, 1.0, -1.25, 1.25)));
		formulas.add(new Z_5_pls_Z_4_pls_Z_3_pls_Z_2_pls_Z(new FormulaProperties(-1.5, 1.0, -1.25, 1.25)));
		formulas.add(new Z_6(new FormulaProperties(-1.5, 1.5, -1.5, 1.5)));	
		formulas.add(new Z_8(new FormulaProperties(-1.5, 1.5, -1.5, 1.5)));
		formula = formulas.get(0);
	}
}
