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
package pl.wojciechantosiewicz.fractals.complex;

import java.util.ArrayList;
import java.util.List;

import pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula;
import pl.wojciechantosiewicz.fractals.palette.FractalPalette;


/**
 * Convenience class for creation of complex fractals. The only method left for implementation
 * is rgbColor.
 * 
 * @author Wojciech Antosiewicz
 *
 */
public abstract class ComplexFractal {
	/**
	 * Name of the fractal
	 */
	protected String name;
	
	/**
	 * Formula currently used to calculate color of the fractal in specified point
	 */
	protected IComplexFormula formula;

	/**
	 * Color palette currently used by the fractal
	 */
	protected FractalPalette palette;

	/**
	 * List of all formulas defined for this fractal
	 */
	protected List<IComplexFormula> formulas;

	/**
	 * Type of this fractal
	 */
	protected FractalType type = FractalType.Undefined;

	/**
	 * Creates a new ComplexFractal object.
	 * 
	 * @param name of fractal
	 * @param type of fractal
	 * @throws NullPointerException if <code>name<code> is null
	 */
	public ComplexFractal(String name, FractalType type) {
		if(name == null){
			throw new NullPointerException("Argument name is null");
		}
		this.name = name;
		this.type = type;
		formulas = new ArrayList<IComplexFormula>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return name;
	}


	/**
	 * Returns integer which contains RGB color calculated for this fractal with the use
	 * of currently selected formula in point u + i*v
	 * @param u real part of point
	 * @param v imaginary part of point
	 * @return integer which contains color in RGB format
	 */
	public abstract int rgbColor(double u, double v);


	/**
	 * Returns currently selected formula
	 * @return formula for this fractal
	 */
	public IComplexFormula getFormula(){
		return formula;
	}

	/**
	 * Sets the new formula to use by this fractal
	 * @param f new formula
	 */
	public void setFormula(IComplexFormula f){
		formula = f;
	}

	/**
	 * Returns all formulas defined for this fractal
	 * @return formulas of this fractal
	 */
	public List<IComplexFormula> getFormulas(){
		return formulas;
	}

	/**
	 * Returns name of the fractal
	 * @return name of the fractal
	 */
	public String getName(){
		return name;
	}

	/**
	 * Returns currently used palette
	 * @return palette 
	 */
	public FractalPalette getPalette(){
		return palette;
	}

	/**
	 * Sets the new palette for this fractal
	 * @param palette new palette to use by this fractal
	 */
	public void setPalette(FractalPalette palette){
		this.palette = palette;
	}

	/**
	 * Returns type of this fractal
	 * @return type of thw fractal
	 */
	public FractalType getType(){
		return type;
	}
}
