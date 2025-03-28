package generaloss.freetype;

public class FTLoadFlags extends BitMask {

    public FTLoadFlags(int bits) {
        super(bits);
    }

    public FTLoadFlags() {
        super(0);
    }

    public boolean has(FTLoad flag) {
        return super.has(flag.value);
    }

    public FTLoadFlags set(FTLoad flag) {
       super.set(flag.value);
        return this;
    }

    public FTLoadFlags clear(FTLoad flag) {
        super.clear(flag.value);
        return this;
    }

}
