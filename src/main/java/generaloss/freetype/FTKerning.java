package generaloss.freetype;

public enum FTKerning {

    DEFAULT,  // 0
    UNFITTED, // 1
    UNSCALED; // 2

    public final int value;

    FTKerning() {
        this.value = this.ordinal();
    }

    public static FTKerning byValue(int value) {
        return values()[value];
    }

}
