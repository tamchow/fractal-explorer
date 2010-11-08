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
import java.util.ArrayList;
import java.util.List;

//import pl.wojciechantosiewicz.fractals.palette.FractalPalette.PaletteType;
import pl.wojciechantosiewicz.image.GradientGenerator;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision: 000 $
 */
public class Palettes {
	private List<FractalPalette> palettesDivergent;
	private List<FractalPalette> palettesConvergent;
	private static Palettes instance;
	
	private Palettes(){
		super();
		palettesConvergent = new ArrayList<FractalPalette>(3);
		palettesConvergent.add(createPaletteConvergent1());
		palettesConvergent.add(createPaletteConvergent2());
		palettesConvergent.add(createPaletteConvergent3());
		
		palettesDivergent = new ArrayList<FractalPalette>(3);
		palettesDivergent.add(createPaletteDivergent1());
		palettesDivergent.add(createPaletteDivergent2());
		palettesDivergent.add(createPaletteDivergent3());
	}
	
	public static Palettes getInstace(){
		if(instance == null){
			instance = new Palettes();
		}
		return instance;
	}
	
	/**
	 * DOCUMENT ME!
	 * 
	 * @param index
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
//	 */
//	public static int getPaletteDivergentSize(int index){
//		return palettesDivergent[index].getSize();
//	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param index
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
//	public static int getPaletteConvergentSize(int index){
//		return palettesConvergent[index].getSize();
//	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param index
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
//	public static FractalPalette getPaletteConvergent(int index){
//		return palettesConvergent[index];
//	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param index
	 *        DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
//	public static FractalPalette getPaletteDivergent(int index){
//		return palettesDivergent[index];
//	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private FractalPalette createPaletteDivergent1(){
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

		return new FractalPalette(colors/*, PaletteType.DIVERGENT*/);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private FractalPalette createPaletteDivergent2(){
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

		return new FractalPalette(colors/*, PaletteType.DIVERGENT*/);
	}

	// ******************************************************************************
	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private FractalPalette createPaletteDivergent3(){
		Color[] colors = new Color[512];

		final int segmentSize = 64;
		int[] offset = new int[colors.length / segmentSize];

		for(int i = 0; i < offset.length; i++){
			offset[i] = segmentSize * i;
		}

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[][] rgb = new Color[][] { 
				gr.generateColors(new Color(192, 0, 128), new Color(0, 192, 0)),
				gr.generateColors(new Color(0, 192, 0), Color.yellow), 
				gr.generateColors(Color.yellow, Color.red),
				gr.generateColors(Color.red, new Color(0, 255, 204)), 
				gr.generateColors(new Color(0, 255, 204), new Color(128, 0, 192)),
				gr.generateColors(new Color(128, 0, 192), Color.white), 
				gr.generateColors(Color.white, new Color(255, 153, 0)),
				gr.generateColors(new Color(255, 153, 0), new Color(102, 255, 102)) };

		for(int j = 0; j < rgb.length; j++){
			for(int i = 0; i < segmentSize; i++){
				colors[offset[j] + i] = rgb[j][i];
			}
		}

		return new FractalPalette(colors/*, PaletteType.DIVERGENT*/);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private FractalPalette createPaletteConvergent1(){
		final int segmentSize = 64;
		final int segments = 3;
		Color[] colors = new Color[segmentSize * segments];

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[] segmentColors = gr.generateColors(Color.black, Color.white);
		int currSegment = 0;
		System.arraycopy(segmentColors, 0, colors, segmentSize * currSegment++, segmentColors.length);
		System.arraycopy(segmentColors, 0, colors, segmentSize * currSegment++, segmentColors.length);
		System.arraycopy(segmentColors, 0, colors, segmentSize * currSegment++, segmentColors.length);
		
		return new FractalPalette(colors, segments);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private FractalPalette createPaletteConvergent2(){
		final int segmentSize = 32;
		final int segments = 4;
		Color[] colors = new Color[segments * segmentSize];

		
		int[] offset = new int[colors.length / segmentSize];

		for(int i = 0; i < offset.length; i++){
			offset[i] = segmentSize * i;
		}

		GradientGenerator gr = new GradientGenerator(segmentSize);

		Color[][] rgb = new Color[][] { 
				gr.generateColors(new Color(50, 30, 0), new Color(255, 204, 0)),
				gr.generateColors(new Color(50, 0, 0), new Color(255, 0, 0)), 
				gr.generateColors(new Color(0, 50, 0), new Color(0, 255, 0)),
				gr.generateColors(new Color(0, 0, 50), new Color(0, 0, 255)), };

		for(int j = 0; j < rgb.length; j++){
			for(int i = 0; i < segmentSize; i++){
				colors[offset[j] + i] = rgb[j][i];
			}
		}

		return new FractalPalette(colors, segments/*, PaletteType.CONVERGENT*/);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * @todo DOCUMENT ME!
	 */
	private FractalPalette createPaletteConvergent3(){
		final int segmentSize = 48;
		final int segments = 3;
		Color[] colors = new Color[segmentSize * segments];

		GradientGenerator gr = new GradientGenerator(segmentSize);

		int currSegment = 0;
		Color[] segmentColors = gr.generateColors(Color.red, Color.black);
		System.arraycopy(segmentColors, 0, colors, segmentSize * currSegment++, segmentColors.length);
		
		segmentColors = gr.generateColors(Color.green, Color.black);
		System.arraycopy(segmentColors, 0, colors, segmentSize * currSegment++, segmentColors.length);
		
		segmentColors = gr.generateColors(Color.blue, Color.black);
		System.arraycopy(segmentColors, 0, colors, segmentSize * currSegment++, segmentColors.length);

		return new FractalPalette(colors, segments);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return the palettesConvergent
	 */
	public List<FractalPalette> getPalettesConvergent(){
		return palettesConvergent;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @return the palettesDivergent
	 */
	public List<FractalPalette> getPalettesDivergent(){
		return palettesDivergent;
	}
}
