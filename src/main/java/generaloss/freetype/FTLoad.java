package generaloss.freetype;

public enum FTLoad {

    DEFAULT,                     // 0
    NO_SCALE,                    // 1
    NO_HINTING,                  // 2
    RENDER,                      // 4
    NO_BITMAP,                   // 8
    VERTICAL_LAYOUT,             // 16
    FORCE_AUTOHINT,              // 32
    CROP_BITMAP,                 // 64
    PEDANTIC,                    // 128
    IGNORE_GLOBAL_ADVANCE_WIDTH, // 512
    NO_RECURSE,                  // 1024
    IGNORE_TRANSFORM,            // 2048
    MONOCHROME,                  // 4096
    LINEAR_DESIGN,               // 8192
    NO_AUTOHINT;                 // 32768

    public final int value;

    FTLoad() {
        final int i = (this.ordinal() - 1);
        this.value = (i == -1) ? 0 : 1 << i;
    }

    public static FTLoad byValue(int value) {
        final int i = Integer.numberOfTrailingZeros(value);
        if(i == 32)
            return values()[0];
        return values()[i + 1];
    }

}
