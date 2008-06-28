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
 * $Id$
 */
package fractals.complex.convergent;

import org.jscience.mathematics.functions.Polynomial;
import org.jscience.mathematics.numbers.Complex;

import fractals.complex.ComplexFractal;
import fractals.complex.Formula;


/**
 * DOCUMENT ME!
 *
 * @author $Author: author $
 * @version $Rev: 000 $
 *
 * @todo DOCUMENT ME!
*/
public class ConvergentFractal extends ComplexFractal {
    //~ Instance fields ----------------------------------------------------------------------------------------------

    /** TODO: DOCUMENT ME! */
    protected Complex z = Complex.ZERO;

    /** TODO: DOCUMENT ME! */
    protected Polynomial<Complex> function;

    /** TODO: DOCUMENT ME! */
    protected Polynomial<Complex> derivative;

    /** TODO: DOCUMENT ME! */
    private double accuracy = 0.001;

    /** DOCUMENT ME! */
    protected Complex[] roots;

    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new ConvergentFractal object.
     *
     * @param name DOCUMENT ME!
     */
    public ConvergentFractal(String name) {
        super(name, ComplexFractal.Type.Convergent);
    }


/**
     *  Creates a new ConvergentFractal object.
    *
     *  @param name TODO: DOCUMENT ME!
     *  @param function TODO: DOCUMENT ME!
    */
    public ConvergentFractal(String name, final Polynomial<Complex> func) {
        super(name, ComplexFractal.Type.Convergent);
        this.function = func;
    }


/**
     * Creates a new ConvergentFractal object.
     *
     * @param name DOCUMENT ME!
     * @param func DOCUMENT ME!
     * @param roots DOCUMENT ME!
     */
    public ConvergentFractal(String name, final Polynomial<Complex> func, Complex[] roots) {
        super(name, ComplexFractal.Type.Convergent);
        this.function = func;
        this.roots = roots;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param u TODO: DOCUMENT ME!
     * @param v TODO: DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public int rgbColor(double u, double v) {
        int i = 0;
        z = Complex.valueOf(u, v);
        final int paletteSize = palette.getSize();
        while (i < (paletteSize >> 2)) {
        	// zn+1 = zn - fn[zn]/f'[zn]
        	z = z.minus(formula.calculate(z));
        	i++;

        	Complex[] roots = formula.getPoints();

        	for (int k = 0; k < roots.length; k++) {
        		int idx = 0;
        		try {
        			if (z.minus(roots[k]).magnitude() < accuracy) {
        				idx = ((paletteSize * k) / roots.length) + i-1;
        				return palette.getRGB(idx);
        			}
        		} catch (ArrayIndexOutOfBoundsException a) {
        			System.out.println("palette.length = "+palette.getSize()+", idx="+idx);
        		}
        	}

        }

        return 0x000000;
    }


    /**
     * DOCUMENT ME!
     *
     * @param f TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    @Override
    public void setFormula(Formula f) {
        this.formula = f;
    }


    /**
     * DOCUMENT ME!
     *
     * @param roots DOCUMENT ME!
     */
    public void setRoots(Complex[] roots) {
        this.roots = roots;
    }


    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Complex[] gerRoots() {
        return roots;
    }
}
