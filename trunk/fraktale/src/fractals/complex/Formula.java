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
package fractals.complex;

import org.jscience.mathematics.numbers.Complex;


/**
 * DOCUMENT ME!
 *
 * @version $Revision: 000 $
*/
public abstract class Formula {
    //~ Instance fields ----------------------------------------------------------------------------------------------

    /** DOCUMENT ME! */
    protected Complex cons = Complex.ZERO;

    /** DOCUMENT ME! */
    protected double re2;

    /** DOCUMENT ME! */
    protected double im2;

    /** DOCUMENT ME! */
    private double minX;

    /** DOCUMENT ME! */
    private double maxX;

    /** DOCUMENT ME! */
    private double minY;

    /** DOCUMENT ME! */
    private double maxY;

    /** DOCUMENT ME! */
    private Complex[] points;

    //~ Constructors -------------------------------------------------------------------------------------------------

/**
     * Creates a new Formula object.
     *
     * @param minX DOCUMENT ME!
     * @param maxX DOCUMENT ME!
     * @param minY DOCUMENT ME!
     * @param maxY DOCUMENT ME!
     */
    public Formula(double minX, double maxX, double minY, double maxY) {
        super();
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    //~ Methods ------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param value DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public abstract Complex calculate(Complex value);


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param c DOCUMENT ME!
     */
    public void setConstans(Complex c) {
        cons = c;
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param re DOCUMENT ME!
     * @param im DOCUMENT ME!
     */
    public void setConstant(double re, double im) {
        cons = new Complex(re, im);
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Complex[] getPoints() {
        return points;
    }


    //******************************************************************************
    /**
     * DOCUMENT ME!
     *
     * @param points DOCUMENT ME!
     */
    public void setPoints(Complex[] points) {
        this.points = points;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the maxX
     */
    public double getMaxX() {
        return maxX;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param maxX the maxX to set
     */
    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the maxY
     */
    public double getMaxY() {
        return maxY;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param maxY the maxY to set
     */
    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the minX
     */
    public double getMinX() {
        return minX;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param minX the minX to set
     */
    public void setMinX(double minX) {
        this.minX = minX;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @return the minY
     */
    public double getMinY() {
        return minY;
    }


    /**
     * 
    DOCUMENT ME!
     *
     * @param minY the minY to set
     */
    public void setMinY(double minY) {
        this.minY = minY;
    }

	public abstract int getPolynomialOrder();
}
