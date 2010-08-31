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
 * Polynomial formula calculating expression <code>Z<sup>2</sup> + Z + C</code>
 * @author Wojciech Antosiewicz
 */
public class Z_2_pls_Z extends PolynomialFormula {
	/**
	 * Creates formula with specified properties
	 * @param properties to use by this formula
	 */
	public Z_2_pls_Z(FormulaProperties properties){
		super(properties, 2);
	}
	
	/* (non-Javadoc)
	 * @see pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula#calculate(org.jscience.mathematics.numbers.Complex)
	 */
	public final Complex calculate(Complex z){
		double re2 = z.getReal() * z.getReal();
		double im2 = z.getImaginary() * z.getImaginary();

		return Complex.valueOf(
				re2 - im2 + z.getReal() + constant.getReal(), 
				(z.getReal() * z.getImaginary() * 2) + z.getImaginary() + constant.getImaginary());
	}

	@Override
	public String toString(){
		return "Z^2 + Z + C";
	}

}
