package generaloss.freetype.glyph;

import generaloss.freetype.FTLibrary;

public class FTGlyphMetrics { // done

    private final long address;

    public FTGlyphMetrics(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native int getWidth(long metrics);

    /** The glyph's width. */
    public int getWidth() {
        return FTLibrary.FTPos_toInt(getWidth(address));
    }


    private static native int getHeight(long metrics);

    /** The glyph's height. */
    public int getHeight() {
        return FTLibrary.FTPos_toInt(getHeight(address));
    }


    private static native int getHoriBearingX(long metrics);

    /** Left side bearing for horizontal layout. */
    public int getHoriBearingX() {
        return FTLibrary.FTPos_toInt(getHoriBearingX(address));
    }


    private static native int getHoriBearingY(long metrics);

    /** Top side bearing for horizontal layout. */
    public int getHoriBearingY() {
        return FTLibrary.FTPos_toInt(getHoriBearingY(address));
    }


    private static native int getHoriAdvance(long metrics);

    /** Advance width for horizontal layout. */
    public int getHoriAdvance() {
        return FTLibrary.FTPos_toInt(getHoriAdvance(address));
    }


    private static native int getVertBearingX(long metrics);

    /** Left side bearing for vertical layout. */
    public int getVertBearingX() {
        return FTLibrary.FTPos_toInt(getVertBearingX(address));
    }


    private static native int getVertBearingY(long metrics);

    /** Top side bearing for vertical layout. Larger positive values mean further below the vertical glyph origin. */
    public int getVertBearingY() {
        return FTLibrary.FTPos_toInt(getVertBearingY(address));
    }


    private static native int getVertAdvance(long metrics);

    /** Advance height for vertical layout. Positive values mean the glyph has a positive advance downward. */
    public int getVertAdvance() {
        return FTLibrary.FTPos_toInt(getVertAdvance(address));
    }

}