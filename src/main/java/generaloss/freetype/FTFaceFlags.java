package generaloss.freetype;

public class FTFaceFlags extends BitMask {

    public FTFaceFlags(int bits) {
        super(bits);
    }

    public boolean has(FTFaceFlag flag) {
        return super.has(flag.value);
    }

    public boolean set(FTFaceFlag flag) {
        return super.has(flag.value);
    }

    public boolean clear(FTFaceFlag flag) {
        return super.has(flag.value);
    }

}
