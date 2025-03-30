package generaloss.freetype;

import jpize.util.NativeLib;
import jpize.util.res.Resource;
import java.nio.ByteBuffer;

public class FTLibrary {

    protected static int encodeChars(char a, char b, char c, char d) {
        return (a << 24) | (b << 16) | (c << 8) | d;
    }

    public static int FTPos_toInt(int value) {
        return ((value + 63) & -64) >> 6;
    }


    private static native int getLastErrorCode();

    public static FTError getLastError() {
        return FTError.byCode(getLastErrorCode());
    }

    private static native long initFreeType();

    public static FTLibrary init() {
        loadLibrary();

        final long address = initFreeType();
        if(address == 0)
            throw new RuntimeException("Couldn't initialize FreeType library: " + getLastError());

        return new FTLibrary(address);
    }

    private static void loadLibrary() {
        final String os = System.getProperty("os.name").toLowerCase();
        final String architecture = System.getProperty("os.arch").toLowerCase();
        final String filename = NativeLib.getFilename("freetype_bindings");
        NativeLib.load(Resource.internal("/lib/freetype/" + os + "-" + architecture + "/" + filename));
    }


    private final long address;

    private FTLibrary(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native long newMemoryFace(long library, ByteBuffer data, int dataSize, int faceIndex);

    public FTFace newMemoryFace(ByteBuffer buffer, int faceIndex) {
        final long face = newMemoryFace(address, buffer, buffer.remaining(), faceIndex);
        if(face == 0)
            throw new RuntimeException("Couldn't load font: " + FTLibrary.getLastError());
        return new FTFace(face);
    }

    public FTFace newMemoryFace(byte[] data, int faceIndex) {
        final ByteBuffer buffer = ByteBuffer.allocateDirect(data.length);
        buffer.put(data);
        buffer.position(0);
        return newMemoryFace(buffer, faceIndex);
    }

    public FTFace newMemoryFace(Resource res, int faceIndex) {
        return newMemoryFace(res.readByteBuffer(), faceIndex);
    }


    private static native long strokerNew(long library);

    public FTStroker strokerNew() {
        final long stroker = strokerNew(address);
        if(stroker == 0)
            throw new RuntimeException("Couldn't create FreeType stroker: " + FTLibrary.getLastError());
        return new FTStroker(stroker);
    }


    private static native void doneFreeType(long library);

    public void done() {
        doneFreeType(address);
    }

}
