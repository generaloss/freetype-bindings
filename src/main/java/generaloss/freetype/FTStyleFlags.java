package generaloss.freetype;

public class FTStyleFlags extends BitMask {

    public FTStyleFlags(int bits) {
        super(bits);
    }

    public FTStyleFlags() {
        super(0);
    }

    public boolean has(FTStyleFlag flag) {
        return super.has(flag.value);
    }

    public FTStyleFlags set(FTStyleFlag flag) {
        super.set(flag.value);
        return this;
    }

    public FTStyleFlags clear(FTStyleFlag flag) {
        super.clear(flag.value);
        return this;
    }

}
