package generaloss.freetype.glyph;

import generaloss.freetype.bitmap.FTBitmap;
import generaloss.freetype.FTLibrary;
import generaloss.freetype.stroker.FTStroker;

public class FTGlyph {

    private long address;
    private boolean rendered;

    public FTGlyph(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native long strokeBorder(long glyph, long stroker, boolean inside);

    /** Stroke a given outline glyph object with a given stroker, but only return either its inside or outside border.c */
    public void strokeBorder(FTStroker stroker, boolean inside) {
        address = strokeBorder(address, stroker.getAddress(), inside);
    }


    private static native long toBitmap(long glyph, int renderMode);

    /** Convert a given glyph object to a bitmap glyph object. */
    public void toBitmap(FTRenderMode renderMode) {
        final long bitmap = toBitmap(address, renderMode.value);
        if(bitmap == 0)
            throw new RuntimeException("Couldn't render glyph: " + FTLibrary.getLastError());
        address = bitmap;
        rendered = true;
    }


    private static native long getBitmap(long glyph);

    /** A descriptor for the bitmap. */
    public FTBitmap getBitmap() {
        if(!rendered)
            throw new IllegalStateException("Glyph is not rendered yet");
        return new FTBitmap(getBitmap(address));
    }


    private static native int getLeft(long glyph);

    /** The left-side bearing, i.e., the horizontal distance from the current pen position to the left border of the glyph bitmap. */
    public int getLeft() {
        if(!rendered)
            throw new IllegalStateException("Glyph is not rendered yet");
        return getLeft(address);
    }


    private static native int getTop(long glyph);

    /** The top-side bearing, i.e., the vertical distance from the current pen position to the top border of the glyph bitmap. This distance is positive for upwards y! */
    public int getTop() {
        if(!rendered)
            throw new IllegalStateException("Glyph is not rendered yet");
        return getTop(address);
    }


    private static native void done(long glyph);

    /** Destroy a given glyph. */
    public void done() {
        done(address);
    }

}