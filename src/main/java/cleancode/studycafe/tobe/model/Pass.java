package cleancode.studycafe.tobe.model;

public interface Pass {

  boolean isHourlyType();
  boolean isWeeklyType();
  boolean isFixedType();

  int getDuration();
  int getPrice();
  StudyCafePassType getPassType();
}
