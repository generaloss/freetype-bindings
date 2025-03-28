package generaloss.freetype;

public class FTFaceFlags extends BitMask {

    public FTFaceFlags(int bits) {
        super(bits);
    }

    public FTFaceFlags() {
        super(0);
    }

    public boolean has(FTFaceFlag flag) {
        return super.has(flag.value);
    }

    public FTFaceFlags set(FTFaceFlag flag) {
        super.set(flag.value);
        return this;
    }

    public FTFaceFlags clear(FTFaceFlag flag) {
        super.clear(flag.value);
        return this;
    }

}
