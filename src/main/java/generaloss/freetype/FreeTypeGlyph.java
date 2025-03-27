package generaloss.freetype;

public class FreeTypeGlyph {

    private long address;
    private boolean rendered;

    FreeTypeGlyph(long address) {
        this.address = address;
    }

    private static native long strokeBorder(long glyph, long stroker, boolean inside);

    public void strokeBorder(FreeTypeStroker stroker, boolean inside) {
        address = strokeBorder(address, stroker.getAddress(), inside);
    }

    public long getAddress() {
        return address;
    }


    private static native long toBitmap(long glyph, int renderMode);

    public void toBitmap(int renderMode) {
        final long bitmap = toBitmap(address, renderMode);
        if(bitmap == 0)
            throw new RuntimeException("Couldn't render glyph, FreeType error code: " + FreeType.getLastErrorCode());
        address = bitmap;
        rendered = true;
    }


    private static native long getBitmap(long glyph);

    public FreeTypeBitmap getBitmap() {
        if(!rendered)
            throw new RuntimeException("Glyph is not yet rendered");
        return new FreeTypeBitmap(getBitmap(address));
    }


    private static native int getLeft(long glyph);

    public int getLeft() {
        if(!rendered)
            throw new RuntimeException("Glyph is not yet rendered");
        return getLeft(address);
    }


    private static native int getTop(long glyph);

    public int getTop() {
        if(!rendered)
            throw new RuntimeException("Glyph is not yet rendered");
        return getTop(address);
    }


    private static native void done(long glyph);

    public void done() {
        done(address);
    }

}