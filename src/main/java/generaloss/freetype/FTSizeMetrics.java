package generaloss.freetype;

public class FTSizeMetrics {

    private final long address;

    FTSizeMetrics(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native int getXppem(long metrics);

    /**  */
    public int getXppem() {
        return getXppem(address);
    }


    private static native int getYppem(long metrics);

    /**  */
    public int getYppem() {
        return getYppem(address);
    }


    private static native int getXscale(long metrics);

    /**  */
    public int getXScale() {
        return getXscale(address);
    }


    private static native int getYscale(long metrics);

    /**  */
    public int getYscale() {
        return getYscale(address);
    }


    private static native int getAscender(long metrics);

    /**  */
    public int getAscender() {
        return FTLibrary.FTPos_toInt(getAscender(address));
    }


    private static native int getDescender(long metrics);

    /**  */
    public int getDescender() {
        return FTLibrary.FTPos_toInt(getDescender(address));
    }


    private static native int getHeight(long metrics);

    /**  */
    public int getHeight() {
        return FTLibrary.FTPos_toInt(getHeight(address));
    }


    private static native int getMaxAdvance(long metrics);

    /**  */
    public int getMaxAdvance() {
        return FTLibrary.FTPos_toInt(getMaxAdvance(address));
    }

}