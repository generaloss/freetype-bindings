package generaloss.freetype;

public class FTStyleFlags extends BitMask {

    public FTStyleFlags(int bits) {
        super(bits);
    }

    public boolean has(FTStyleFlag flag) {
        return super.has(flag.value);
    }

    public boolean set(FTStyleFlag flag) {
        return super.has(flag.value);
    }

    public boolean clear(FTStyleFlag flag) {
        return super.has(flag.value);
    }

}
