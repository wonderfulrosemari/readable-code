package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.StudyCafeLockerPasses;
import cleancode.studycafe.tobe.model.StudyCafePassList;

public interface FileHandler {
  StudyCafePassList readStudyCafePasses();
  StudyCafeLockerPasses readLockerPasses();
}
