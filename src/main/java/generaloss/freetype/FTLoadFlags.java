package generaloss.freetype;

public class FTLoadFlags extends BitMask {

    public FTLoadFlags(int bits) {
        super(bits);
    }

    public FTLoadFlags() {
        super(0);
    }


    public boolean has(FTLoadFlag flag) {
        return super.has(flag.value);
    }

    public FTLoadFlags set(FTLoadFlag flag) {
       super.set(flag.value);
        return this;
    }

    public FTLoadFlags clear(FTLoadFlag flag) {
        super.clear(flag.value);
        return this;
    }


    public boolean has(FTLoadTarget target) {
        return super.has(target.value);
    }

    public FTLoadFlags set(FTLoadTarget target) {
        super.set(target.value);
        return this;
    }

    public FTLoadFlags clear(FTLoadTarget target) {
        super.clear(target.value);
        return this;
    }

}
