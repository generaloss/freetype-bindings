import generaloss.freetype.*;
import generaloss.freetype.bitmap.FTBitmap;
import generaloss.freetype.face.FTFace;
import generaloss.freetype.face.FTSizeMetrics;
import generaloss.freetype.glyph.FTGlyphMetrics;
import generaloss.freetype.glyph.FTRenderMode;
import jpize.util.res.Resource;

public class Test {

    public static void main(String[] args) {
        test2();
    }

    private static final String CHARS = "\0ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890\"!`?'.,;:()[]{}<>|/@\\^$-%+=#_&~*�?�?�?�?�? ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿À�?ÂÃÄÅÆÇÈÉÊËÌ�?Î�?�?ÑÒÓÔÕÖ×ØÙÚÛÜ�?Þßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ";

    private static void test2() {
        final FTLibrary library = FTLibrary.init();
        // ...
        library.done();
    }

    private static void test1() {
        final FTLibrary library = FTLibrary.init();

        final FTFace face = library.newMemoryFace(Resource.internal("/droidsans.ttf").readBytes(), 0);
        face.setPixelSizes(0, 15);
        final FTSizeMetrics faceMetrics = face.getSize().getMetrics();
        System.out.println(faceMetrics.getAscender() + ", " + faceMetrics.getDescender() + ", " + faceMetrics.getHeight());

        for(int i = 0; i < CHARS.length(); i++) {
            if(!face.loadGlyph(face.getCharIndex(CHARS.charAt(i))))
                continue;
            if(!face.getGlyph().renderGlyph(FTRenderMode.NORMAL))
                continue;

            final FTBitmap bitmap = face.getGlyph().getBitmap();
            final FTGlyphMetrics glyphMetrics = face.getGlyph().getMetrics();

            System.out.println(glyphMetrics.getHoriBearingX() + ", " + glyphMetrics.getHoriBearingY());
            System.out.println(glyphMetrics.getWidth() + ", " + glyphMetrics.getHeight() + ", " + glyphMetrics.getHoriAdvance());
            System.out.println(bitmap.getWidth() + ", " + bitmap.getRows() + ", " + bitmap.getPitch() + ", " + bitmap.getNumGray());

            for(int y = 0; y < bitmap.getRows(); y++) {
                for(int x = 0; x < bitmap.getWidth(); x++)
                    System.out.print(bitmap.getBuffer().get(x + bitmap.getPitch() * y) != 0? "X": " ");
                System.out.println();
            }
        }

        face.done();
        library.done();
    }

}
