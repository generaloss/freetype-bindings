package generaloss.freetype;

public enum FTPixelMode {

    NONE,  // 0
    MONO,  // 1
    GRAY,  // 2
    GRAY2, // 3
    GRAY4, // 4
    LCD,   // 5
    LCD_V; // 6

    public final int value;

    FTPixelMode() {
        this.value = this.ordinal();
    }

    public static FTPixelMode byValue(int value) {
        return values()[value];
    }

}
