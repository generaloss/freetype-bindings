package generaloss.freetype;

public class FreeTypeGlyphSlot {

    private final long address;

    FreeTypeGlyphSlot(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native long getMetrics(long slot);

    public FreeTypeGlyphMetrics getMetrics() {
        final long metrics = getMetrics(address);
        return new FreeTypeGlyphMetrics(metrics);
    }


    private static native int getLinearHoriAdvance(long slot);

    public int getLinearHoriAdvance() {
        return getLinearHoriAdvance(address);
    }


    private static native int getLinearVertAdvance(long slot);

    public int getLinearVertAdvance() {
        return getLinearVertAdvance(address);
    }


    private static native int getAdvanceX(long slot);

    public int getAdvanceX() {
        return getAdvanceX(address);
    }


    private static native int getAdvanceY(long slot);

    public int getAdvanceY() {
        return getAdvanceY(address);
    }


    private static native int getFormat(long slot);

    public int getFormat() {
        return getFormat(address);
    }


    private static native long getBitmap(long slot);

    public FreeTypeBitmap getBitmap() {
        final long bitmap = getBitmap(address);
        return new FreeTypeBitmap(bitmap);
    }


    private static native int getBitmapLeft(long slot);

    public int getBitmapLeft() {
        return getBitmapLeft(address);
    }


    private static native int getBitmapTop(long slot);

    public int getBitmapTop() {
        return getBitmapTop(address);
    }


    private static native boolean renderGlyph(long slot, int renderMode);

    public boolean renderGlyph(int renderMode) {
        return renderGlyph(address, renderMode);
    }


    private static native long getGlyph(long glyphSlot);

    public FreeTypeGlyph getGlyph() {
        final long glyph = getGlyph(address);
        if(glyph == 0)
            throw new RuntimeException("Couldn't get glyph, FreeType error code: " + FreeType.getLastErrorCode());
        return new FreeTypeGlyph(glyph);
    }

}