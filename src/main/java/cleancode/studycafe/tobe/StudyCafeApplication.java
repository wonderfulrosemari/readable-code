package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.io.*;

public class StudyCafeApplication {
    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        FileHandler fileHandler = new StudyCafeFileHandler();

        StudyCafePassMachine machine = new StudyCafePassMachine(
            inputHandler,
            outputHandler,
            fileHandler
        );

        machine.run();
    }
}
