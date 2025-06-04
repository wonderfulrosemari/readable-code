package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.FileHandler;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.model.*;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final FileHandler fileHandler;

    public StudyCafePassMachine(InputHandler inputHandler, OutputHandler outputHandler, FileHandler fileHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.fileHandler = fileHandler;
    }

    public void run() {
        try {
            outputHandler.showStartMessage();

            StudyCafePassType type = askPassType();
            StudyCafePass pass = selectPass(type);
            StudyCafeLockerPass lockerPass = selectLocker(pass);

            outputHandler.showPassOrderSummary(pass, lockerPass);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePassType askPassType() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private StudyCafePass selectPass(StudyCafePassType type) {
        StudyCafePassList allPasses = fileHandler.readStudyCafePasses();
        var filtered = allPasses.getPassListByType(type);
        outputHandler.showPassListForSelection(filtered);
        return inputHandler.getSelectPass(filtered);
    }

    private StudyCafeLockerPass selectLocker(StudyCafePass pass) {
        return fileHandler.readLockerPasses()
            .getLockerPassBySelectedPass(pass)
            .filter(lp -> {
                outputHandler.askLockerPass(lp);
                return inputHandler.getLockerSelection();
            })
            .orElse(null);
    }
}
