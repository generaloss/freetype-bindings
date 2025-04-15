package generaloss.freetype;

public class BitMask {

    private int bits;

    public BitMask() { }

    public BitMask(int bits) {
        this.bits = bits;
    }


    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }


    public boolean isDefault() {
        return (bits == 0);
    }


    public boolean has(int bit) {
        return (bits & bit) != 0;
    }

    public void set(int bit) {
        bits |= bit;
    }

    public void clear(int bit) {
        bits &= ~bit;
    }

}