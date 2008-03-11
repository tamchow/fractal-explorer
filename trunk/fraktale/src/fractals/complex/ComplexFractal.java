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
package fractals.complex;

import fractals.palette.FractalPalette;

import java.util.ArrayList;


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
    protected Formula formula;

    /** DOCUMENT ME! */
    protected FractalPalette palette;

    /** TODO: DOCUMENT ME! */
    protected ArrayList<Formula> formulas = new ArrayList<Formula>();

    /** DOCUMENT ME! */
    protected Type type = Type.Undefined;

    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     *  Creates a new ComplexFractal object.
    *
     *  @param name TODO: DOCUMENT ME!
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
    public Formula getFormula() {
        return formula;
    }


    /**
     * DOCUMENT ME!
     *
     * @param f TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public void setFormula(Formula f) {
        formula = f;
    }


    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public ArrayList<Formula> getFormulas() {
        return formulas;
    }


    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public double getMaxX() {
        return formula.getMaxX();
    }


    /**
     * DOCUMENT ME!
     *
     * @param maxX TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public void setMaxX(double maxX) {
        formula.setMaxX(maxX);
    }


    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public double getMaxY() {
        return formula.getMaxY();
    }


    /**
     * DOCUMENT ME!
     *
     * @param maxY TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public void setMaxY(double maxY) {
        formula.setMaxY(maxY);
    }


    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public double getMinX() {
        return formula.getMinX();
    }


    /**
     * DOCUMENT ME!
     *
     * @param minX TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public void setMinX(double minX) {
        formula.setMinX(minX);
    }


    /**
     * DOCUMENT ME!
     *
     * @return TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public double getMinY() {
        return formula.getMinY();
    }


    /**
     * DOCUMENT ME!
     *
     * @param minY TODO: DOCUMENT ME!
     *
     * @todo DOCUMENT ME!
     */
    public void setMinY(double minY) {
        formula.setMinY(minY);
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

    public enum Type {//~ Enumeration constant initializers ------------------------------------------------------------------------

        Convergent, Divergent, Undefined;
    }
}
