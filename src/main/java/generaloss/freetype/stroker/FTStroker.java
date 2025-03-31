package generaloss.freetype.stroker;

public class FTStroker {

    private final long address;

    public FTStroker(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native void set(long stroker, int radius, int lineCap, int lineJoin, int miterLimit);

    /** he radius is expressed in the same units as the outline coordinates.
      * The miter_limit multiplied by the radius gives the maximum size of a miter spike, at which it is clipped for FTStrokerLinejoin.MITER_VARIABLE or replaced with a bevel join for FTStrokerLinejoin.MITER_FIXED.
      * This function calls FT_Stroker_Rewind automatically. */
    public void set(int radius, FTStrokerLinecap lineCap, FTStrokerLinejoin lineJoin, int miterLimit) {
        set(address, radius, lineCap.value, lineJoin.value, miterLimit);
    }


    // TODO: rewind, parseOutline, beginSubPath, endSubPath, lineTo, conicTo, cubicTo, getBorderCounts, exportBorder, getCounts, export


    private static native void done(long stroker);

    /** Destroy a stroker object. */
    public void done() {
        done(address);
    }

}