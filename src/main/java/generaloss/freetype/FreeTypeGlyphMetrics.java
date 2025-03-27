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
        return getWidth(address);
    }


    private static native int getHeight(long metrics);

    public int getHeight() {
        return getHeight(address);
    }


    private static native int getHoriBearingX(long metrics);

    public int getHoriBearingX() {
        return getHoriBearingX(address);
    }


    private static native int getHoriBearingY(long metrics);

    public int getHoriBearingY() {
        return getHoriBearingY(address);
    }


    private static native int getHoriAdvance(long metrics);

    public int getHoriAdvance() {
        return getHoriAdvance(address);
    }


    private static native int getVertBearingX(long metrics);

    public int getVertBearingX() {
        return getVertBearingX(address);
    }


    private static native int getVertBearingY(long metrics);

    public int getVertBearingY() {
        return getVertBearingY(address);
    }


    private static native int getVertAdvance(long metrics);

    public int getVertAdvance() {
        return getVertAdvance(address);
    }

}