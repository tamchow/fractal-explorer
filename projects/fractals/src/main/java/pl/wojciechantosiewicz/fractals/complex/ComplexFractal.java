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
/*
 * $Id: file.java 000 2006-09-01 00:00:00Z author $
 */
package pl.wojciechantosiewicz.fractals.complex;

import java.util.ArrayList;

import pl.wojciechantosiewicz.fractals.complex.formula.IComplexFormula;
import pl.wojciechantosiewicz.fractals.palette.FractalPalette;


/**
 * DOCUMENT ME!
 *
 * @author $Author: author $
 * @version $Rev: 000 $
 *
 * @todo DOCUMENT ME!
*/
public abstract class ComplexFractal {
    //~ Instance fields ----------------------------------------------------------------------------------------------

    /** TODO: DOCUMENT ME! */
    protected String name;

    /** TODO: DOCUMENT ME! */
    protected IComplexFormula formula;

    /** DOCUMENT ME! */
    protected FractalPalette palette;

    /** TODO: DOCUMENT ME! */
    protected ArrayList<IComplexFormula> formulas = new ArrayList<IComplexFormula>();

    /** DOCUMENT ME! */
    protected Type type = Type.Undefined;

    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     *  Creates a new ComplexFractal object.
    *
     *  @param name TODO: DOCUMENT ME!
 * @param type 
    */
    public ComplexFractal(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    @Override
	public String toString() {
        return name;
    }


    // ******************************************************************************
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
    public abstract int rgbColor(double u, double v);


    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public IComplexFormula getFormula() {
        return formula;
    }


    /**
     * DOCUMENT ME!
     *
     * @param f TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public void setFormula(IComplexFormula f) {
        formula = f;
    }


    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public ArrayList<IComplexFormula> getFormulas() {
        return formulas;
    }

    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public String getName() {
        return name;
    }


    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public FractalPalette getPalette() {
        return palette;
    }


    /**
     * DOCUMENT ME!
     *
     * @param palette DOCUMENT ME!
     */
    public void setPalette(FractalPalette palette) {
        this.palette = palette;
    }


    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Type getType() {
        return type;
    }

    //~ Enumerations -------------------------------------------------------------------------------------------------

    /**
     * @author wa
     *
     */
    public enum Type {//~ Enumeration constant initializers ------------------------------------------------------------------------

        /**
         * 
         */
        Convergent, 
        /**
         * 
         */
        Divergent, 
        /**
         * 
         */
        Undefined;
    }
}
