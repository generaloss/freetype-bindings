package generaloss.freetype.flags;

public enum FTStyleFlag {

    /** The face style is italic or oblique. */
    ITALIC, // 1

    /** The face is bold. */
    BOLD;   // 2

    public final int value;

    FTStyleFlag() {
        this.value = (1 << this.ordinal());
    }

}
