package generaloss.freetype.face;

public class FTSize {

    private final long address;

    public FTSize(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    // TODO: face, generic


    private static native long getMetrics(long address);

    /** Metrics for this size object. */
    public FTSizeMetrics getMetrics() {
        final long metrics = getMetrics(address);
        return new FTSizeMetrics(metrics);
    }

}