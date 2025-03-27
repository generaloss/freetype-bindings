package generaloss.freetype;

public enum FTGlyphFormat {

    FT_GLYPH_FORMAT_NONE      (0),
    FT_GLYPH_FORMAT_COMPOSITE ('c', 'o', 'm', 'p'),
    FT_GLYPH_FORMAT_BITMAP    ('b', 'i', 't', 's'),
    FT_GLYPH_FORMAT_OUTLINE   ('o', 'u', 't', 'l'),
    FT_GLYPH_FORMAT_PLOTTER   ('p', 'l', 'o', 't'),
    FT_GLYPH_FORMAT_SVG       ('S', 'V', 'G', ' ');

    public final int value;

    FTGlyphFormat(int value) {
        this.value = value;
    }

    FTGlyphFormat(char a, char b, char c, char d) {
        this.value = FreeType.encode(a, b, c, d);
    }

    public static FTGlyphFormat byValue(int value) {
        for(FTGlyphFormat format: values())
            if(format.value == value)
                return format;
        return null;
    }

}
