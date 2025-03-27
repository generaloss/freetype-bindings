package generaloss.freetype;

public enum FTFaceFlag {

    SCALABLE,         // 1
    FIXED_SIZES,      // 2
    FIXED_WIDTH,      // 4
    SFNT,             // 8
    HORIZONTAL,       // 16
    VERTICAL,         // 32
    KERNING,          // 64
    FAST_GLYPHS,      // 128
    MULTIPLE_MASTERS, // 256
    GLYPH_NAMES,      // 512
    EXTERNAL_STREAM,  // 1024
    HINTER,           // 2048
    CID_KEYED,        // 4096
    TRICKY;           // 8192

    public final int value;

    FTFaceFlag() {
        this.value = (1 << this.ordinal());
    }

    public static FTFaceFlag byValue(int value) {
        final int index = Integer.numberOfTrailingZeros(value);
        return FTFaceFlag.values()[index];
    }

}
