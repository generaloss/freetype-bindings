package generaloss.freetype;

public enum FTLoadTarget {

    NORMAL (0),
    LIGHT  (65536),
    MONO   (131072),
    LCD    (196608),
    LCD_V  (262144);

    public final int value;

    FTLoadTarget(int value) {
        this.value = value;
    }

    public FTLoadTarget byValue(int value) {
        for(FTLoadTarget target: values())
            if(target.value == value)
                return target;
        return null;
    }

}
