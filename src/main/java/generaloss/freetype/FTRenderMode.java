package generaloss.freetype;

public enum FTRenderMode {

    NORMAL, // 0
    LIGHT,  // 1
    MONO,   // 2
    LCD,    // 3
    LCD_V,  // 4
    MAX;    // 5

    public final int value;

    FTRenderMode() {
        this.value = this.ordinal();
    }

    public static FTRenderMode byValue(int value) {
        return values()[value];
    }

}
