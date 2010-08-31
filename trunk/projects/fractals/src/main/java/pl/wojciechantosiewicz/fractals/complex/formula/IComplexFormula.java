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
package pl.wojciechantosiewicz.fractals.complex.formula;

import org.jscience.mathematics.numbers.Complex;

/**
 * Interface for all complex formulas
 * @author Wojciech Antosiewicz
 */
public interface IComplexFormula {
	/**
	 * Calculates value of this formula for the provided parameter.
	 * 
	 * @param param
	 *        parameter for which value of this formula is calculated
	 * @return result of calculation
	 */
	Complex calculate(Complex param);

	/**
	 * Sets constant used by this formula in calculations. This constant is denoted as <code>C</code>
	 * in all formulas.
	 * @param point new constant for this formula
	 */
	void setConstant(Complex point);

	/**
	 * Sets the new properties for this formula
	 * @param properties
	 */
	void setProperties(FormulaProperties properties);

	/**
	 * Returns properties used by this formula
	 * @return properties of this formula
	 */
	FormulaProperties getProperties();
}
