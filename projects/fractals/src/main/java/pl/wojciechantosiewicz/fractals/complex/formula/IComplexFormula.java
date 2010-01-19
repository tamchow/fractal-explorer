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
 * @author Wojciech Antosiewicz
 *
 */
public interface IComplexFormula {
	/**
	 * Calculates value of this formula for the provided parameter.
	 * @param param parameter for which value of this formula is calculated
	 * @return calculated value of this formula for given parameter
	 */
	Complex calculate(Complex param);

	/**
	 * @param point
	 */
	void setConstant(Complex point);
	
	/**
	 * @param properties
	 */
	void setProperties(FormulaProperties properties);
	
	/**
	 * @return
	 */
	FormulaProperties getProperties();
}
