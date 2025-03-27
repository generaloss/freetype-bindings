package generaloss.freetype;

public enum FTStrokerLinejoinRound {

    ROUND          (0),
    BEVEL          (1),
    MITER          (2),
    MITER_VARIABLE (2),
    MITER_FIXED    (3);

    public final int value;

    FTStrokerLinejoinRound(int value) {
        this.value = value;
    }

    public static FTStrokerLinejoinRound byValue(int value) {
        if(value > 2)
            value++;
        return values()[value];
    }

}
