package generaloss.freetype;

public enum FTGlyphFormat {

    NONE      (0),
    COMPOSITE ('c', 'o', 'm', 'p'),
    BITMAP    ('b', 'i', 't', 's'),
    OUTLINE   ('o', 'u', 't', 'l'),
    PLOTTER   ('p', 'l', 'o', 't'),
    SVG       ('S', 'V', 'G', ' ');

    public final int value;

    FTGlyphFormat(int value) {
        this.value = value;
    }

    FTGlyphFormat(char a, char b, char c, char d) {
        this.value = FreeType.encodeChars(a, b, c, d);
    }

    public static FTGlyphFormat byValue(int value) {
        for(FTGlyphFormat format: values())
            if(format.value == value)
                return format;
        return null;
    }

}
