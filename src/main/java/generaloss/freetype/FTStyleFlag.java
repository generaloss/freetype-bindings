package generaloss.freetype;

public enum FTStyleFlag {

    ITALIC, // 1
    BOLD;   // 2

    public final int value;

    FTStyleFlag() {
        this.value = (this.ordinal() + 1); // simplified
    }

    public static FTStyleFlag byValue(int value) {
        if(value == 1)
            return ITALIC;
        return BOLD;
    }

}
