package ir.hatami.onlinereservation.domain.type;

public enum TimePeriod {
    TEN(1, "10"),
    TEN_HALF(2, "10:30"),
    ELEVEN(3, "11"),
    ELEVEN_HALF(4, "11:30"),
    TWELVE(5, "12"),

    SEVENTEEN(6, "17"),
    SEVENTEEN_HALF(7, "17:30"),
    EIGHTEEN(8, "18"),
    EIGHTEEN_HALF(9, "18:30"),
    NINETEEN(10, "19"),
    ;

    private final int code;
    private final String value;

    TimePeriod(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static TimePeriod of(int code) {
        for (TimePeriod tp : TimePeriod.values()) {
            if (tp.code == code) return tp;
        }
        return null;
    }

    public static TimePeriod of(String value) {
        for (TimePeriod tp : TimePeriod.values()) {
            if (tp.value.equals(value)) return tp;
        }
        return null;
    }
}
