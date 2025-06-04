package cleancode.studycafe.tobe.model;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권", "%s시간권 - %d원"),
    WEEKLY("주 단위 이용권", "%s주권 - %d원"),
    FIXED("1인 고정석", "%s주권 - %d원");

    private final String description;
    private final String displayFormat;

    StudyCafePassType(String description, String displayFormat) {
        this.description = description;
        this.displayFormat = displayFormat;
    }

    public String formatDisplay(int duration, int price) {
        return String.format(displayFormat, duration, price);
    }
}
