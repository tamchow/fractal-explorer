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
 * Convenience class implementing IComplexFormula interface with the except for calculate method.
 * 
 * @author Wojciech Antosiewicz
 */
public abstract class ComplexFormula implements IComplexFormula {
	/**
	 * Properties of this formula
	 */
	protected FormulaProperties properties;

	/** Constant value of the formula */
	protected Complex constant = Complex.ZERO;

	/**
     * Creates new ComplexFormula with default properties
     */
	public ComplexFormula() {
		properties = new FormulaProperties();
	}

	/**
	 * @param properties
	 */
	public ComplexFormula(FormulaProperties properties) {
		super();
		this.properties = properties;
	}

	/*
	 * (non-Javadoc)
	 * @see pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula#getProperties()
	 */
	public FormulaProperties getProperties(){
		return properties;
	}

	/*
	 * (non-Javadoc)
	 * @see pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula#setConstant(org.jscience.mathematics.numbers.Complex)
	 */
	public void setConstant(Complex point){
		constant = point;
	}

	/*
	 * (non-Javadoc)
	 * @seepl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula#setProperties(pl.wojciechantosiewicz.fractals.complex.formula.
	 * FormulaProperties)
	 */
	public void setProperties(FormulaProperties properties){
		this.properties = properties;
	}

}
