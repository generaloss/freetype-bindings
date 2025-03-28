package generaloss.freetype;

public enum FTKerningMode {

    DEFAULT,  // 0
    UNFITTED, // 1
    UNSCALED; // 2

    public final int value;

    FTKerningMode() {
        this.value = this.ordinal();
    }

    public static FTKerningMode byValue(int value) {
        return values()[value];
    }

}
