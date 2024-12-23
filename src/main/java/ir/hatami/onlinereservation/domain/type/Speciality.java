package ir.hatami.onlinereservation.domain.type;

public enum Speciality {
    VAL1(1),
    VAL2(2),
    ;
    private int code;

    Speciality(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Speciality of(int code) {
        for (Speciality spec : values()) {
            if (spec.getCode() == code) return spec;
        }
        return null;
    }
}
