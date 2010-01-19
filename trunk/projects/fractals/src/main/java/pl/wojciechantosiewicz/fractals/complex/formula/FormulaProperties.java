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
public class FormulaProperties {
	/** DOCUMENT ME! */
    protected double minRe;

    /** DOCUMENT ME! */
    protected double maxRe;

    /** DOCUMENT ME! */
    protected double minIm;

    /** DOCUMENT ME! */
    protected double maxIm;
    
    /** DOCUMENT ME! */
    protected Complex[] points;
    
    /**
     * 
     */
    public FormulaProperties() {
		minRe = 0.0;
		maxRe = 0.0;
		minIm = 0.0;
		maxIm = 0.0;
	}
    
    public FormulaProperties(double minRe, double maxRe, double minIm, double maxIm){
    	this.minRe = minRe;
    	this.maxRe = maxRe;
    	this.minIm = minIm;
    	this.maxIm = maxIm;
    }
    
	/**
	 * @return the minRe
	 */
	public double getMinRe() {
		return minRe;
	}

	/**
	 * @param minRe the minRe to set
	 */
	public void setMinRe(double minRe) {
		this.minRe = minRe;
	}

	/**
	 * @return the maxRe
	 */
	public double getMaxRe() {
		return maxRe;
	}

	/**
	 * @param maxRe the maxRe to set
	 */
	public void setMaxRe(double maxRe) {
		this.maxRe = maxRe;
	}

	/**
	 * @return the minIm
	 */
	public double getMinIm() {
		return minIm;
	}

	/**
	 * @param minIm the minIm to set
	 */
	public void setMinIm(double minIm) {
		this.minIm = minIm;
	}

	/**
	 * @return the maxIm
	 */
	public double getMaxIm() {
		return maxIm;
	}

	/**
	 * @param maxIm the maxIm to set
	 */
	public void setMaxIm(double maxIm) {
		this.maxIm = maxIm;
	}

	/**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Complex[] getPoints() {
        return points;
    }


    
    /**
     * DOCUMENT ME!
     *
     * @param points DOCUMENT ME!
     */
    public void setPoints(Complex[] points) {
        this.points = points;
    }
}
