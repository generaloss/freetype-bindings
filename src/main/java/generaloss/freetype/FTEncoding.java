package generaloss.freetype;

public enum FTEncoding {

    NONE           (0),
    MS_SYMBOL      ('s', 'y', 'm', 'b'),
    UNICODE        ('u', 'n', 'i', 'c'),
    SJIS           ('s', 'j', 'i', 's'),
    GB2312         ('g', 'b', ' ', ' '),
    BIG5           ('b', 'i', 'g', '5'),
    WANSUNG        ('w', 'a', 'n', 's'),
    JOHAB          ('j', 'o', 'h', 'a'),
    ADOBE_STANDARD ('A', 'D', 'O', 'B'),
    ADOBE_EXPERT   ('A', 'D', 'B', 'E'),
    ADOBE_CUSTOM   ('A', 'D', 'B', 'C'),
    ADOBE_LATIN_1  ('l', 'a', 't', '1'),
    OLD_LATIN_2    ('l', 'a', 't', '2'),
    APPLE_ROMAN    ('a', 'r', 'm', 'n');

    public final int value;

    FTEncoding(int value) {
        this.value = value;
    }

    FTEncoding(char a, char b, char c, char d) {
        this.value = FreeType.encodeChars(a, b, c, d);
    }

    public static FTEncoding byValue(int value) {
        for(FTEncoding encoding: values())
            if(encoding.value == value)
                return encoding;
        return null;
    }

}
