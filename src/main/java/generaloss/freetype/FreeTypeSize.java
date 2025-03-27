package generaloss.freetype;

public class FreeTypeSize {

    private final long address;

    FreeTypeSize(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native long getMetrics(long address);

    public FreeTypeSizeMetrics getMetrics() {
        final long metrics = getMetrics(address);
        return new FreeTypeSizeMetrics(metrics);
    }

}