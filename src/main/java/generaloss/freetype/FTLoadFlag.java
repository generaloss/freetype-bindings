package generaloss.freetype;

public enum FTLoadFlag {

    DEFAULT                     (0),
    NO_SCALE                    (1),
    NO_HINTING                  (1 << 1),  // 2
    RENDER                      (1 << 2),  // 4
    NO_BITMAP                   (1 << 3),  // 8
    VERTICAL_LAYOUT             (1 << 4),  // 16
    FORCE_AUTOHINT              (1 << 5),  // 32
    CROP_BITMAP                 (1 << 6),  // 64
    PEDANTIC                    (1 << 7),  // 128
    IGNORE_GLOBAL_ADVANCE_WIDTH (1 << 9),  // 512
    NO_RECURSE                  (1 << 10), // 1024
    IGNORE_TRANSFORM            (1 << 11), // 2048
    MONOCHROME                  (1 << 12), // 4096
    LINEAR_DESIGN               (1 << 13), // 8192
    SBITS_ONLY                  (1 << 14), // 16384
    NO_AUTOHINT                 (1 << 15), // 32768
    COLOR                       (1 << 20), // 1048576
    COMPUTE_METRICS             (1 << 21), // 2097152
    BITMAP_METRICS_ONLY         (1 << 22), // 4194304
    NO_SVG                      (1 << 24); // 16777216

    public final int value;

    FTLoadFlag(int value) {
        this.value = value;
    }

}
