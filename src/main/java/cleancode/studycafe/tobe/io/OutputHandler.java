package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;

import java.util.List;

public interface OutputHandler {
    void showStartMessage();
    void askPassTypeSelection();
    void showSimpleMessage(String message);
    void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);
    void showPassListForSelection(List<StudyCafePass> passes);
    void askLockerPass(StudyCafeLockerPass lockerPass);
}
