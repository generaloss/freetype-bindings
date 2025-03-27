package generaloss.freetype;

public enum FTStrokerLinecap {

    BUTT,   // 0
    ROUND,  // 1
    SQUARE; // 2

    public final int value;

    FTStrokerLinecap() {
        this.value = this.ordinal();
    }

    public static FTStrokerLinecap byValue(int value) {
        return values()[value];
    }

}
