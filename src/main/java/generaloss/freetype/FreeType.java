package generaloss.freetype;

import jpize.util.NativeLib;
import jpize.util.res.Resource;
import java.nio.ByteBuffer;

public class FreeType {

    protected static int encode(char a, char b, char c, char d) {
        return (a << 24) | (b << 16) | (c << 8) | d;
    }

    public static int toInt(int value) {
        return ((value + 63) & -64) >> 6;
    }


    private static native int getLastErrorCode();

    public static FTError getLastError() {
        return FTError.byCode(getLastErrorCode());
    }

    private static native long initFreeType();

    public static FreeType init() {
        loadLibrary();

        final long address = initFreeType();
        if(address == 0)
            throw new RuntimeException("Couldn't initialize FreeType library: " + getLastError());

        return new FreeType(address);
    }

    private static void loadLibrary() {
        final String os = System.getProperty("os.name").toLowerCase();
        final String architecture = System.getProperty("os.arch").toLowerCase();
        final String filename = NativeLib.getFilename("freetype_bindings");
        NativeLib.load(Resource.internal("/lib/freetype/" + os + "-" + architecture + "/" + filename));
    }


    private final long address;

    private FreeType(long address) {
        this.address = address;
    }

    public long getAddress() {
        return address;
    }


    private static native long newMemoryFace(long library, ByteBuffer data, int dataSize, int faceIndex);

    public FreeTypeFace newMemoryFace(ByteBuffer buffer, int faceIndex) {
        final long face = newMemoryFace(address, buffer, buffer.remaining(), faceIndex);
        if(face == 0)
            throw new RuntimeException("Couldn't load font: " + FreeType.getLastError());
        return new FreeTypeFace(face);
    }

    public FreeTypeFace newMemoryFace(byte[] data, int faceIndex) {
        final ByteBuffer buffer = ByteBuffer.allocateDirect(data.length);
        buffer.put(data);
        buffer.position(0);
        return newMemoryFace(buffer, faceIndex);
    }

    public FreeTypeFace newFace(Resource res, int faceIndex) {
        return newMemoryFace(res.readByteBuffer(), faceIndex);
    }


    private static native long strokerNew(long library);

    public FreeTypeStroker createStroker() {
        final long stroker = strokerNew(address);
        if(stroker == 0)
            throw new RuntimeException("Couldn't create FreeType stroker: " + FreeType.getLastError());
        return new FreeTypeStroker(stroker);
    }


    private static native void doneFreeType(long library);

    public void done() {
        doneFreeType(address);
    }

}
