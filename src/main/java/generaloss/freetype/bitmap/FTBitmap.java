package generaloss.freetype.bitmap;

import java.nio.ByteBuffer;

public class FTBitmap {

    private final long address;

    public FTBitmap(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native int getRows(long bitmap);

    /** The number of bitmap rows. */
    public int getRows() {
        return getRows(address);
    }


    private static native int getWidth(long bitmap);

    /** The number of pixels in bitmap row. */
    public int getWidth() {
        return getWidth(address);
    }


    private static native int getPitch(long bitmap);

    /** The pitch's absolute value is the number of bytes taken by one bitmap row, including padding. However, the pitch is positive when the bitmap has a ‘down’ flow, and negative when it has an ‘up’ flow. In all cases, the pitch is an offset to add to a bitmap pointer in order to go down one row.
      * Note that ‘padding’ means the alignment of a bitmap to a byte border, and FreeType functions normally align to the smallest possible integer value.
      * For the B/W rasterizer, pitch is always an even number.
      * To change the pitch of a bitmap (say, to make it a multiple of 4), use FT_Bitmap_Convert. Alternatively, you might use callback functions to directly render to the application's surface; see the file example2.cpp in the tutorial for a demonstration. */
    public int getPitch() {
        return getPitch(address);
    }


    private static native ByteBuffer getBuffer(long bitmap);

    /** A typeless pointer to the bitmap buffer. This value should be aligned on 32-bit boundaries in most cases. */
    public ByteBuffer getBuffer() {
        if(this.getRows() == 0)
            return ByteBuffer.allocateDirect(1);
        return getBuffer(address);
    }


    private static native int getNumGray(long bitmap);

    /** This field is only used with FTPixelMode.GRAY; it gives the number of gray levels used in the bitmap. */
    public int getNumGray() {
        return getNumGray(address);
    }


    private static native int getPixelMode(long bitmap);

    /** The pixel mode, i.e., how pixel bits are stored. See FTPixelMode for possible values. */
    public FTPixelMode getPixelMode() {
        return FTPixelMode.byValue(getPixelMode(address));
    }

    // TODO: palette_mode, palette

}