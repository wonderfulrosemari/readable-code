package cleancode.studycafe.tobe.model;

public class StudyCafePass implements Pass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafePass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafePass(passType, duration, price, discountRate);
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public boolean isValidTypeAndDuration(StudyCafeLockerPass lockerPass) {
        return lockerPass.equalsType(this.passType) && lockerPass.equalsDuration(this.duration);
    }

    @Override
    public boolean isHourlyType() {
        return passType == StudyCafePassType.HOURLY;
    }

    @Override
    public boolean isWeeklyType() {
        return passType == StudyCafePassType.WEEKLY;
    }

    @Override
    public boolean isFixedType() {
        return passType == StudyCafePassType.FIXED;
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

    public boolean equalsPassType(StudyCafePassType studyCafePassType) {
        return this.passType == studyCafePassType;
    }
}
