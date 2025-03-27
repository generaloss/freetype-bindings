package generaloss.freetype;

import java.nio.ByteBuffer;

public class FreeTypeBitmap {

    private final long address;

    protected FreeTypeBitmap(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native int getRows(long bitmap);

    public int getRows() {
        return getRows(address);
    }


    private static native int getWidth(long bitmap);

    public int getWidth() {
        return getWidth(address);
    }


    private static native int getPitch(long bitmap);

    public int getPitch() {
        return getPitch(address);
    }


    private static native ByteBuffer getBuffer(long bitmap);

    public ByteBuffer getBuffer() {
        if(this.getRows() == 0)
            return ByteBuffer.allocateDirect(1);
        return getBuffer(address);
    }


    private static native int getNumGray(long bitmap);

    public int getNumGray() {
        return getNumGray(address);
    }


    private static native int getPixelMode(long bitmap);

    public FTPixelMode getPixelMode() {
        return FTPixelMode.byValue(getPixelMode(address));
    }

}