package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

  private static final Scanner SCANNER = new Scanner(System.in);

  @Override
  public StudyCafePassType getPassTypeSelectingUserAction() {
    String userInput = SCANNER.nextLine();
    if ("1".equals(userInput)) return StudyCafePassType.HOURLY;
    if ("2".equals(userInput)) return StudyCafePassType.WEEKLY;
    if ("3".equals(userInput)) return StudyCafePassType.FIXED;
    throw new AppException("잘못된 입력입니다.");
  }

  @Override
  public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
    int selectedIndex = Integer.parseInt(SCANNER.nextLine()) - 1;
    return passes.get(selectedIndex);
  }

  @Override
  public boolean getLockerSelection() {
    return "1".equals(SCANNER.nextLine());
  }
}
