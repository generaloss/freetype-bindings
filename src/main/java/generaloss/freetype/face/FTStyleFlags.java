package generaloss.freetype.face;

import generaloss.freetype.BitMask;

public class FTStyleFlags extends BitMask {

    public FTStyleFlags() { }

    public FTStyleFlags(int bits) {
        super(bits);
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


    public boolean hasItalic() {
        return this.has(FTStyleFlag.ITALIC);
    }

    public boolean hasBold() {
        return this.has(FTStyleFlag.BOLD);
    }


}
