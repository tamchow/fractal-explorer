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
package pl.wojciechantosiewicz.fractals.complex.formula.definitions.trigonometric;

import org.jscience.mathematics.numbers.Complex;

import pl.wojciechantosiewicz.fractals.complex.formula.ComplexFormula;
import pl.wojciechantosiewicz.fractals.complex.formula.FormulaProperties;
import pl.wojciechantosiewicz.fractals.complex.formula.definitions.Utils;

/**
 * Formula calculating expression <code>C * cos(Z)</code>
 * @author Wojciech Antosiewicz
 *
 */
public class Cosinus extends ComplexFormula {
	/**
	 * Creates cosine formula
	 */
	public Cosinus() {
		super();
	}
	
	/**
	 * Creates cosine formula with specified properties
	 * @param properties to use by this formula
	 */
	public Cosinus(FormulaProperties properties) {
		super(properties);
	}

	/* (non-Javadoc)
	 * @see pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula#calculate(org.jscience.mathematics.numbers.Complex)
	 */
	public final Complex calculate(Complex z){
		double cosRe_x_coshIm = Math.cos(z.getReal()) * Utils.cosh(z.getImaginary());
		double sinRe_x_sinhIm = Math.sin(z.getReal()) * Utils.sinh(z.getImaginary());

		return Complex.valueOf(
				(constant.getReal() * cosRe_x_coshIm) - (constant.getImaginary() * sinRe_x_sinhIm), 
				(constant.getImaginary() * sinRe_x_sinhIm) + (constant.getImaginary() * cosRe_x_coshIm));
	}

	@Override
	public String toString(){
		return "C * cos(Z)";
	}

}
