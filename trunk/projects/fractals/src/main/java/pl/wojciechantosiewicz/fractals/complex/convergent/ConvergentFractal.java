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
package pl.wojciechantosiewicz.fractals.complex.convergent;

import org.jscience.mathematics.functions.Polynomial;
import org.jscience.mathematics.numbers.Complex;

import pl.wojciechantosiewicz.fractals.complex.ComplexFractal;
import pl.wojciechantosiewicz.fractals.complex.FractalType;
import pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula;

/**
 * DOCUMENT ME!
 * 
 * @author $Author: author $
 * @version $Rev: 000 $
 * @todo DOCUMENT ME!
 */
public class ConvergentFractal extends ComplexFractal {

	/** TODO: DOCUMENT ME! */
	private double accuracy = 0.001;

	// ~ Constructors -------------------------------------------------------------------------------------------------

	/**
	 * Creates a new ConvergentFractal object.
	 * 
	 * @param name
	 *        DOCUMENT ME!
	 */
	public ConvergentFractal(String name) {
		super(name, FractalType.Convergent);
	}

	/**
	 * Creates a new ConvergentFractal object.
	 * 
	 * @param name
	 *        DOCUMENT ME!
	 * @param func
	 *        DOCUMENT ME!
	 * @param roots
	 *        DOCUMENT ME!
	 */
	public ConvergentFractal(String name, final Polynomial<Complex> func, Complex[] roots) {
		super(name, FractalType.Convergent);
	}

	// ~ Methods ------------------------------------------------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 * 
	 * @param u
	 *        TODO: DOCUMENT ME!
	 * @param v
	 *        TODO: DOCUMENT ME!
	 * @return TODO: DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	@Override
	public int rgbColor(double u, double v){
		
		Complex z = Complex.valueOf(u, v);
		final int paletteSize = palette.getSize();
		final int segmentSize = paletteSize / palette.getNumberOfSegments();
		
		Complex[] roots = formula.getProperties().getPoints();

		for(int i = 0; i < paletteSize; i++){
			// zn+1 = zn - fn[zn]/f'[zn]
			z = z.minus(formula.calculate(z));
			
			for(int k = 0; k < roots.length; k++){
				float position = 0;
				try{
					if(z.minus(roots[k]).magnitude() < accuracy){
						float posOffset = paletteSize * k / (float)roots.length; 
						position = (posOffset + i / (float)segmentSize)/paletteSize;
//						System.out.println("i="+i+", k="+k+", palette.size = " + paletteSize + ", segmentSize = " + segmentSize + ", posOffset=" + posOffset + ", position=" + position);
						return palette.getRGB(position);
					}
				}catch(ArrayIndexOutOfBoundsException a){
					System.out.println("AIOOBE: palette.size = " + paletteSize + ", segmentSize = " + segmentSize + ", idx=" + position);
				}
			}
		}

		return 0x000000;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param f
	 *        TODO: DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	@Override
	public void setFormula(IComplexFormula f){
		this.formula = f;
	}
}
