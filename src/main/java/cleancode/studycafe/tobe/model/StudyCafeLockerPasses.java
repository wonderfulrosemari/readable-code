package cleancode.studycafe.tobe.model;

import java.util.List;
import java.util.Optional;

public class StudyCafeLockerPasses {
  private final List<StudyCafeLockerPass> studyCafeLockerPasses;

  public StudyCafeLockerPasses(List<StudyCafeLockerPass> studyCafeLockerPasses) {
    this.studyCafeLockerPasses = studyCafeLockerPasses;
  }

  public Optional<StudyCafeLockerPass> getLockerPassBySelectedPass(StudyCafePass selectedPass) {
    return studyCafeLockerPasses.stream()
        .filter(selectedPass::isValidTypeAndDuration)
        .findFirst();
  }
}
