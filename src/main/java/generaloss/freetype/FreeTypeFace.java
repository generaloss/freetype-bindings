package generaloss.freetype;

public class FreeTypeFace {

    private final long address;

    public FreeTypeFace(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native int getFaceFlags(long face);

    public FTFaceFlags getFaceFlags() {
        final int flags = getFaceFlags(address);
        return new FTFaceFlags(flags);
    }


    private static native int getStyleFlags(long face);

    public FTStyleFlags getStyleFlags() {
        final int flags = getStyleFlags(address);
        return new FTStyleFlags(flags);
    }


    private static native int getNumGlyphs(long face);

    public int getNumGlyphs() {
        return getNumGlyphs(address);
    }


    private static native int getAscender(long face);

    public int getAscender() {
        return getAscender(address);
    }


    private static native int getDescender(long face);

    public int getDescender() {
        return getDescender(address);
    }


    private static native int getHeight(long face);

    public int getHeight() {
        return getHeight(address);
    }


    private static native int getMaxAdvanceWidth(long face);

    public int getMaxAdvanceWidth() {
        return getMaxAdvanceWidth(address);
    }


    private static native int getMaxAdvanceHeight(long face);

    public int getMaxAdvanceHeight() {
        return getMaxAdvanceHeight(address);
    }


    private static native int getUnderlinePosition(long face);

    public int getUnderlinePosition() {
        return getUnderlinePosition(address);
    }


    private static native int getUnderlineThickness(long face);

    public int getUnderlineThickness() {
        return getUnderlineThickness(address);
    }


    private static native boolean selectSize(long face, int strike_index);

    public boolean selectSize(int strikeIndex) {
        return selectSize(address, strikeIndex);
    }


    private static native boolean setCharSize(long face, int charWidth, int charHeight, int horzResolution, int vertResolution);

    public boolean setCharSize(int charWidth, int charHeight, int horzResolution, int vertResolution) {
        return setCharSize(address, charWidth, charHeight, horzResolution, vertResolution);
    }


    private static native boolean setPixelSizes(long face, int pixelWidth, int pixelHeight);

    public boolean setPixelSizes(int pixelWidth, int pixelHeight) {
        return setPixelSizes(address, pixelWidth, pixelHeight);
    }


    private static native boolean loadGlyph(long face, int glyphIndex, int loadFlags);

    public boolean loadGlyph(int glyphIndex, int loadFlags) {
        return loadGlyph(address, glyphIndex, loadFlags);
    }


    private static native boolean loadChar(long face, int charCode, int loadFlags);

    public boolean loadChar(int charCode, int loadFlags) {
        return loadChar(address, charCode, loadFlags);
    }


    private static native long getGlyph(long face);

    public FreeTypeGlyphSlot getGlyph() {
        final long glyph = getGlyph(address);
        return new FreeTypeGlyphSlot(glyph);
    }


    private static native long getSize(long face);

    public FreeTypeSize getSize() {
        final long size = getSize(address);
        return new FreeTypeSize(size);
    }


    private static native boolean hasKerning(long face);

    public boolean hasKerning() {
        return hasKerning(address);
    }


    private static native int getKerning(long face, int leftGlyph, int rightGlyph, int kernMode);

    public int getKerning(int leftGlyph, int rightGlyph, int kernMode) {
        return getKerning(address, leftGlyph, rightGlyph, kernMode);
    }


    private static native int getCharIndex(long face, int charCode);

    public int getCharIndex(int charCode) {
        return getCharIndex(address, charCode);
    }


    private static native void doneFace(long face);

    public void done() {
        doneFace(address);
    }

}