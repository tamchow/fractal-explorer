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
package pl.wojciechantosiewicz.fractals.palette;

import java.awt.Color;

import pl.wojciechantosiewicz.fractals.palette.FractalPalette.PaletteType;
import pl.wojciechantosiewicz.image.GradientGenerator;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class Palettes {
	// ~ Static fields/initializers -----------------------------------------------------------------------------------

	private static FractalPalette[] palettesDivergent = new FractalPalette[3];
	private static FractalPalette[] palettesConvergent = new FractalPalette[3];

	static{ // create all palettes
		palettesConvergent[0] = getPaletteConvergent1();
		palettesConvergent[1] = getPaletteConvergent2();
		palettesConvergent[2] = getPaletteConvergent3();

		palettesDivergent[0] = getPaletteDivergent1();
		palettesDivergent[1] = getPaletteDivergent2();
		palettesDivergent[2] = getPaletteDivergent3();
	}

	// ~ Methods ------------------------------------------------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 * 
	 * @param index
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int getPaletteDivergentSize(int index){
		return palettesDivergent[index].getSize();
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param index
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int getPaletteConvergentSize(int index){
		return palettesConvergent[index].getSize();
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param index
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static FractalPalette getPaletteConvergent(int index){
		return palettesConvergent[index];
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param index
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static FractalPalette getPaletteDivergent(int index){
		return palettesDivergent[index];
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private static FractalPalette getPaletteDivergent1(){
		Color[] colors = new Color[128];

		final int segmentSize = 32;
		int[] offset = new int[colors.length / segmentSize];

		for(int i = 0; i < offset.length; i++){
			offset[i] = segmentSize * i;
		}

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[][] rgb = new Color[][] { gr.generateColors(new Color(0, 128, 255), new Color(255, 0, 0)),
				gr.generateColors(new Color(255, 0, 0), new Color(255, 255, 0)),
				gr.generateColors(new Color(128, 255, 0), new Color(0, 128, 64)),
				gr.generateColors(new Color(0, 128, 64), new Color(255, 255, 255)) };

		for(int j = 0; j < rgb.length; j++){
			for(int i = 0; i < segmentSize; i++){
				colors[offset[j] + i] = rgb[j][i];
			}
		}

		return new FractalPalette(colors, segmentSize, PaletteType.DIVERGENT);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private static FractalPalette getPaletteDivergent2(){
		Color[] colors = new Color[256];

		final int segmentSize = 32;

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[][] rgb = new Color[][] { gr.generateColors(new Color(255, 255, 255), new Color(0, 128, 128)),
				gr.generateColors(new Color(0, 128, 128), new Color(0, 192, 128)),
				gr.generateColors(new Color(0, 192, 128), new Color(255, 255, 0)),
				gr.generateColors(new Color(255, 255, 0), new Color(255, 0, 0)),
				gr.generateColors(new Color(255, 0, 0), new Color(128, 0, 128)),
				gr.generateColors(new Color(128, 0, 128), new Color(0, 0, 192)),
				gr.generateColors(new Color(0, 0, 192), new Color(128, 128, 128)),
				gr.generateColors(new Color(128, 128, 128), new Color(255, 255, 255)) };

		int[] offset = new int[colors.length / segmentSize];

		for(int i = 0; i < offset.length; i++){
			offset[i] = segmentSize * i;
		}

		for(int j = 0; j < rgb.length; j++){
			for(int i = 0; i < segmentSize; i++){
				colors[offset[j] + i] = rgb[j][i];
			}
		}

		return new FractalPalette(colors, segmentSize, PaletteType.DIVERGENT);
	}

	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private static FractalPalette getPaletteDivergent3(){
		Color[] colors = new Color[512];

		final int segmentSize = 64;
		int[] offset = new int[colors.length / segmentSize];

		for(int i = 0; i < offset.length; i++){
			offset[i] = segmentSize * i;
		}

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[][] rgb = new Color[][] { gr.generateColors(new Color(192, 0, 128), new Color(0, 192, 0)),
				gr.generateColors(new Color(0, 192, 0), Color.yellow), gr.generateColors(Color.yellow, Color.red),
				gr.generateColors(Color.red, new Color(0, 255, 204)), gr.generateColors(new Color(0, 255, 204), new Color(128, 0, 192)),
				gr.generateColors(new Color(128, 0, 192), Color.white), gr.generateColors(Color.white, new Color(255, 153, 0)),
				gr.generateColors(new Color(255, 153, 0), new Color(102, 255, 102)) };

		for(int j = 0; j < rgb.length; j++){
			for(int i = 0; i < segmentSize; i++){
				colors[offset[j] + i] = rgb[j][i];
			}
		}

		return new FractalPalette(colors, segmentSize, PaletteType.DIVERGENT);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private static FractalPalette getPaletteConvergent1(){
		Color[] colors = new Color[192];

		final int segmentSize = 64;
		int[] offset = new int[colors.length / segmentSize];

		for(int i = 0; i < offset.length; i++){
			offset[i] = segmentSize * i;
		}

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[][] rgb = new Color[][] { gr.generateColors(new Color(0, 0, 0), new Color(255, 255, 255)),
				gr.generateColors(new Color(0, 0, 0), new Color(255, 255, 255)),
				gr.generateColors(new Color(0, 0, 0), new Color(255, 255, 255)), };

		for(int j = 0; j < rgb.length; j++){
			for(int i = 0; i < segmentSize; i++){
				colors[offset[j] + i] = rgb[j][i];
			}
		}

		return new FractalPalette(colors, segmentSize, PaletteType.CONVERGENT);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private static FractalPalette getPaletteConvergent2(){
		Color[] colors = new Color[128];

		final int segmentSize = 32;
		int[] offset = new int[colors.length / segmentSize];

		for(int i = 0; i < offset.length; i++){
			offset[i] = segmentSize * i;
		}

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[][] rgb = new Color[][] { gr.generateColors(new Color(50, 30, 0), new Color(255, 204, 0)),
				gr.generateColors(new Color(50, 0, 0), new Color(255, 0, 0)), gr.generateColors(new Color(0, 50, 0), new Color(0, 255, 0)),
				gr.generateColors(new Color(0, 0, 50), new Color(0, 0, 255)), };

		for(int j = 0; j < rgb.length; j++){
			for(int i = 0; i < segmentSize; i++){
				colors[offset[j] + i] = rgb[j][i];
			}
		}

		return new FractalPalette(colors, segmentSize, PaletteType.CONVERGENT);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private static FractalPalette getPaletteConvergent3(){
		Color[] colors = new Color[144];

		final int segmentSize = 48;
		int[] offset = new int[colors.length / segmentSize];

		for(int i = 0; i < offset.length; i++){
			offset[i] = segmentSize * i;
		}

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[][] rgb = new Color[][] { gr.generateColors(new Color(255, 0, 0), new Color(0, 0, 0)),
				gr.generateColors(new Color(0, 255, 0), new Color(0, 0, 0)), gr.generateColors(new Color(0, 0, 255), new Color(0, 0, 0)), };

		for(int j = 0; j < offset.length; j++){
			for(int i = 0; i < segmentSize; i++){
				colors[offset[j] + i] = rgb[j][i];
			}
		}

		return new FractalPalette(colors, segmentSize, PaletteType.CONVERGENT);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return the palettesConvergent
	 */
	public static FractalPalette[] getPalettesConvergent(){
		return palettesConvergent;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return the palettesDivergent
	 */
	public static FractalPalette[] getPalettesDivergent(){
		return palettesDivergent;
	}
}
