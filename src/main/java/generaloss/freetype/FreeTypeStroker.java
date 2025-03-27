package generaloss.freetype;

import jpize.util.Disposable;

public class FreeTypeStroker implements Disposable {

    private final long address;

    FreeTypeStroker(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native void set(long stroker, int radius, int lineCap, int lineJoin, int miterLimit);

    public void set(int radius, int lineCap, int lineJoin, int miterLimit) {
        set(address, radius, lineCap, lineJoin, miterLimit);
    }


    private static native void done(long stroker);

    @Override
    public void dispose() {
        done(address);
    }

}