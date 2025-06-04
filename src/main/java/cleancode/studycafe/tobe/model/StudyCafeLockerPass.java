package cleancode.studycafe.tobe.model;

public class StudyCafeLockerPass implements Pass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public boolean equalsType(StudyCafePassType passType) {
        return this.passType == passType;
    }

    public boolean equalsDuration(int duration) {
        return this.duration == duration;
    }

    @Override
    public boolean isHourlyType() {
        return this.passType == StudyCafePassType.HOURLY;
    }

    @Override
    public boolean isWeeklyType() {
        return this.passType == StudyCafePassType.WEEKLY;
    }

    @Override
    public boolean isFixedType() {
        return this.passType == StudyCafePassType.FIXED;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public StudyCafePassType getPassType() {
        return this.passType;
    }
}
