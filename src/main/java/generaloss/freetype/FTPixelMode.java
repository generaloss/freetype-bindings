package generaloss.freetype;

public enum FTPixelMode {

    FT_PIXEL_MODE_NONE,  // 0
    FT_PIXEL_MODE_MONO,  // 1
    FT_PIXEL_MODE_GRAY,  // 2
    FT_PIXEL_MODE_GRAY2, // 3
    FT_PIXEL_MODE_GRAY4, // 4
    FT_PIXEL_MODE_LCD,   // 5
    FT_PIXEL_MODE_LCD_V; // 6

    public final int value;

    FTPixelMode() {
        this.value = this.ordinal();
    }

    public FTPixelMode byValue(int value) {
        return values()[value];
    }

}
