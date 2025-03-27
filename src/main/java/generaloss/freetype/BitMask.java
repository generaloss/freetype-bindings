package generaloss.freetype;

class BitMask {

    private int bits;

    public BitMask(int bits) {
        this.bits = bits;
    }

    public int getBits() {
        return bits;
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
