package generaloss.freetype;

public class FreeTypeGlyphMetrics {

    private final long address;

    FreeTypeGlyphMetrics(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native int getWidth(long metrics);

    public int getWidth() {
        return FreeType.FTPos_toInt(getWidth(address));
    }


    private static native int getHeight(long metrics);

    public int getHeight() {
        return FreeType.FTPos_toInt(getHeight(address));
    }


    private static native int getHoriBearingX(long metrics);

    public int getHoriBearingX() {
        return FreeType.FTPos_toInt(getHoriBearingX(address));
    }


    private static native int getHoriBearingY(long metrics);

    public int getHoriBearingY() {
        return FreeType.FTPos_toInt(getHoriBearingY(address));
    }


    private static native int getHoriAdvance(long metrics);

    public int getHoriAdvance() {
        return FreeType.FTPos_toInt(getHoriAdvance(address));
    }


    private static native int getVertBearingX(long metrics);

    public int getVertBearingX() {
        return FreeType.FTPos_toInt(getVertBearingX(address));
    }


    private static native int getVertBearingY(long metrics);

    public int getVertBearingY() {
        return FreeType.FTPos_toInt(getVertBearingY(address));
    }


    private static native int getVertAdvance(long metrics);

    public int getVertAdvance() {
        return FreeType.FTPos_toInt(getVertAdvance(address));
    }

}