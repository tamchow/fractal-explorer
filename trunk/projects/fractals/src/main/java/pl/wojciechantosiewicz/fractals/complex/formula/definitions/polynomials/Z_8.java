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
package pl.wojciechantosiewicz.fractals.complex.formula.definitions.polynomials;

import org.jscience.mathematics.numbers.Complex;

import pl.wojciechantosiewicz.fractals.complex.formula.FormulaProperties;
import pl.wojciechantosiewicz.fractals.complex.formula.PolynomialFormula;

/**
 * Polynomial formula calculating expression <code>Z<sup>8</sup> + C</code>
 * @author Wojciech Antosiewicz
 */
public class Z_8 extends PolynomialFormula {
	/**
	 * Creates formula with specified properties
	 * @param properties to use by this formula
	 */
	public Z_8(FormulaProperties properties){
		super(properties, 8);
	}
	
	/* (non-Javadoc)
	 * @see pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula#calculate(org.jscience.mathematics.numbers.Complex)
	 */
	public final Complex calculate(Complex z){
		double re2 = z.getReal() * z.getReal();
		double im2 = z.getImaginary() * z.getImaginary();
		double a = re2 - (3 * im2);
		double b = (3 * re2) - im2;
		double c = re2 - im2;

		return Complex.valueOf(
				((re2 * re2 * a * a) + (im2 * im2 * b * b)) - (2 * re2 * im2 * ((8 * c * c) + (a * b)))
					+ constant.getReal(), 
				(8 * z.getReal() * z.getImaginary() * c * ((re2 * a) - (im2 * b))) + constant.getImaginary());
	}

	@Override
	public String toString(){
		return "Z^8 + C";
	}
}
