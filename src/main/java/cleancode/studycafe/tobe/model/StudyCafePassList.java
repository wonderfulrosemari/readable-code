package cleancode.studycafe.tobe.model;

import java.util.List;
import java.util.stream.Collectors;

public class StudyCafePassList {
  private final List<StudyCafePass> passes;

  public StudyCafePassList(List<StudyCafePass> passes) {
    this.passes = passes;
  }

  public List<StudyCafePass> getAll() {
    return passes;
  }

  public List<StudyCafePass> getPassListByType(StudyCafePassType type) {
    return passes.stream()
        .filter(pass -> pass.getPassType() == type)
        .collect(Collectors.toList());
  }
}
