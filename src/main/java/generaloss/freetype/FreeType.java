package generaloss.freetype;

import jpize.util.NativeLib;
import jpize.util.res.Resource;
import java.nio.ByteBuffer;

public class FreeType {

    public static int FT_PIXEL_MODE_NONE = 0;
    public static int FT_PIXEL_MODE_MONO = 1;
    public static int FT_PIXEL_MODE_GRAY = 2;
    public static int FT_PIXEL_MODE_GRAY2 = 3;
    public static int FT_PIXEL_MODE_GRAY4 = 4;
    public static int FT_PIXEL_MODE_LCD = 5;
    public static int FT_PIXEL_MODE_LCD_V = 6;

    private static int encode(char a, char b, char c, char d) {
        return (a << 24) | (b << 16) | (c << 8) | d;
    }

    public static int FT_ENCODING_NONE = 0;
    public static int FT_ENCODING_MS_SYMBOL = encode('s', 'y', 'm', 'b');
    public static int FT_ENCODING_UNICODE = encode('u', 'n', 'i', 'c');
    public static int FT_ENCODING_SJIS = encode('s', 'j', 'i', 's');
    public static int FT_ENCODING_GB2312 = encode('g', 'b', ' ', ' ');
    public static int FT_ENCODING_BIG5 = encode('b', 'i', 'g', '5');
    public static int FT_ENCODING_WANSUNG = encode('w', 'a', 'n', 's');
    public static int FT_ENCODING_JOHAB = encode('j', 'o', 'h', 'a');
    public static int FT_ENCODING_ADOBE_STANDARD = encode('A', 'D', 'O', 'B');
    public static int FT_ENCODING_ADOBE_EXPERT = encode('A', 'D', 'B', 'E');
    public static int FT_ENCODING_ADOBE_CUSTOM = encode('A', 'D', 'B', 'C');
    public static int FT_ENCODING_ADOBE_LATIN_1 = encode('l', 'a', 't', '1');
    public static int FT_ENCODING_OLD_LATIN_2 = encode('l', 'a', 't', '2');
    public static int FT_ENCODING_APPLE_ROMAN = encode('a', 'r', 'm', 'n');

    public static int FT_FACE_FLAG_SCALABLE = 1;
    public static int FT_FACE_FLAG_FIXED_SIZES = 2;
    public static int FT_FACE_FLAG_FIXED_WIDTH = 4;
    public static int FT_FACE_FLAG_SFNT = 8;
    public static int FT_FACE_FLAG_HORIZONTAL = 16;
    public static int FT_FACE_FLAG_VERTICAL = 32;
    public static int FT_FACE_FLAG_KERNING = 64;
    public static int FT_FACE_FLAG_FAST_GLYPHS = 128;
    public static int FT_FACE_FLAG_MULTIPLE_MASTERS = 256;
    public static int FT_FACE_FLAG_GLYPH_NAMES = 512;
    public static int FT_FACE_FLAG_EXTERNAL_STREAM = 1024;
    public static int FT_FACE_FLAG_HINTER = 2048;
    public static int FT_FACE_FLAG_CID_KEYED = 4096;
    public static int FT_FACE_FLAG_TRICKY = 8192;

    public static int FT_STYLE_FLAG_ITALIC = 1;
    public static int FT_STYLE_FLAG_BOLD = 2;

    public static int FT_LOAD_DEFAULT = 0;
    public static int FT_LOAD_NO_SCALE = 1;
    public static int FT_LOAD_NO_HINTING = 2;
    public static int FT_LOAD_RENDER = 4;
    public static int FT_LOAD_NO_BITMAP = 8;
    public static int FT_LOAD_VERTICAL_LAYOUT = 16;
    public static int FT_LOAD_FORCE_AUTOHINT = 32;
    public static int FT_LOAD_CROP_BITMAP = 64;
    public static int FT_LOAD_PEDANTIC = 128;
    public static int FT_LOAD_IGNORE_GLOBAL_ADVANCE_WIDTH = 512;
    public static int FT_LOAD_NO_RECURSE = 1024;
    public static int FT_LOAD_IGNORE_TRANSFORM = 2048;
    public static int FT_LOAD_MONOCHROME = 4096;
    public static int FT_LOAD_LINEAR_DESIGN = 8192;
    public static int FT_LOAD_NO_AUTOHINT = 32768;

    public static int FT_LOAD_TARGET_NORMAL = 0;
    public static int FT_LOAD_TARGET_LIGHT = 65536;
    public static int FT_LOAD_TARGET_MONO = 131072;
    public static int FT_LOAD_TARGET_LCD = 196608;
    public static int FT_LOAD_TARGET_LCD_V = 262144;

    public static int FT_RENDER_MODE_NORMAL = 0;
    public static int FT_RENDER_MODE_LIGHT = 1;
    public static int FT_RENDER_MODE_MONO = 2;
    public static int FT_RENDER_MODE_LCD = 3;
    public static int FT_RENDER_MODE_LCD_V = 4;
    public static int FT_RENDER_MODE_MAX = 5;

    public static int FT_KERNING_DEFAULT = 0;
    public static int FT_KERNING_UNFITTED = 1;
    public static int FT_KERNING_UNSCALED = 2;

    public static int FT_STROKER_LINECAP_BUTT = 0;
    public static int FT_STROKER_LINECAP_ROUND = 1;
    public static int FT_STROKER_LINECAP_SQUARE = 2;

    public static int FT_STROKER_LINEJOIN_ROUND = 0;
    public static int FT_STROKER_LINEJOIN_BEVEL = 1;
    public static int FT_STROKER_LINEJOIN_MITER_VARIABLE = 2;
    public static int FT_STROKER_LINEJOIN_MITER = FT_STROKER_LINEJOIN_MITER_VARIABLE;
    public static int FT_STROKER_LINEJOIN_MITER_FIXED = 3;


    public static native int getLastErrorCode();

    private static native long initFreeType();

    public static FreeType init() {
        loadLibrary();

        final long address = initFreeType();
        if(address == 0)
            throw new RuntimeException("Couldn't initialize FreeType library, FreeType error code: " + getLastErrorCode());

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
            throw new RuntimeException("Couldn't load font, FreeType error code: " + FreeType.getLastErrorCode());
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
            throw new RuntimeException("Couldn't create FreeType stroker, FreeType error code: " + FreeType.getLastErrorCode());
        return new FreeTypeStroker(stroker);
    }


    private static native void doneFreeType(long library);

    public void done() {
        doneFreeType(address);
    }

}
