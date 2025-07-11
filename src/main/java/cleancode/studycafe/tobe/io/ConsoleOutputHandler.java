package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler {

  @Override
  public void showStartMessage() {
    showWelcomeMessage();
    showAnnouncement();
  }

  @Override
  public void askPassTypeSelection() {
    System.out.println("사용하실 이용권을 선택해 주세요.");
    System.out.println("1. 시간 이용권(자유석) | 2. 주단위 이용권(자유석) | 3. 1인 고정석");
  }

  @Override
  public void showPassListForSelection(List<StudyCafePass> passes) {
    System.out.println();
    System.out.println("이용권 목록");
    for (int index = 0; index < passes.size(); index++) {
      StudyCafePass pass = passes.get(index);
      System.out.println(String.format("%s. ", index + 1) + pass.getPassType().formatDisplay(pass.getDuration(), pass.getPrice()));
    }
  }

  @Override
  public void askLockerPass(StudyCafeLockerPass lockerPass) {
    System.out.println();
    String askMessage = String.format(
        "사물함을 이용하시겠습니까? (%s)",
        lockerPass.getPassType().formatDisplay(lockerPass.getDuration(), lockerPass.getPrice())
    );
    System.out.println(askMessage);
    System.out.println("1. 예 | 2. 아니오");
  }

  @Override
  public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
    System.out.println();
    System.out.println("이용 내역");
    System.out.println("이용권: " + selectedPass.getPassType().formatDisplay(selectedPass.getDuration(), selectedPass.getPrice()));
    if (lockerPass != null) {
      System.out.println("사물함: " + lockerPass.getPassType().formatDisplay(lockerPass.getDuration(), lockerPass.getPrice()));
    }

    double discountRate = selectedPass.getDiscountRate();
    int discountPrice = (int) (selectedPass.getPrice() * discountRate);
    if (discountPrice > 0) {
      System.out.println("이벤트 할인 금액: " + discountPrice + "원");
    }

    int totalPrice = selectedPass.getPrice() - discountPrice + (lockerPass != null ? lockerPass.getPrice() : 0);
    System.out.println("총 결제 금액: " + totalPrice + "원");
    System.out.println();
  }

  @Override
  public void showSimpleMessage(String message) {
    System.out.println(message);
  }

  private void showWelcomeMessage() {
    System.out.println("*** 프리미엄 스터디카페 ***");
  }

  private void showAnnouncement() {
    System.out.println("* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)");
    System.out.println("* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)");
    System.out.println();
  }
}
