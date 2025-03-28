package generaloss.freetype;

public class FTLoadFlags extends BitMask {

    public FTLoadFlags(int bits) {
        super(bits);
    }

    public boolean has(FTLoad flag) {
        return super.has(flag.value);
    }

    public boolean set(FTLoad flag) {
        return super.has(flag.value);
    }

    public boolean clear(FTLoad flag) {
        return super.has(flag.value);
    }

}
