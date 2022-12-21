package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.ICheckPrinting;
import by.clevertec.check_creator.core.dto.CheckDTO;

public class CheckPrintingToConsoleAndFile implements ICheckPrinting {

    private final CheckPrintingToConsole checkPrintingToConsole;
    private final CheckPrintingToFile checkPrintingToFile;

    public CheckPrintingToConsoleAndFile() {
        this.checkPrintingToConsole = new CheckPrintingToConsole();
        this.checkPrintingToFile = new CheckPrintingToFile();
    }

    @Override
    public void print(CheckDTO check) {
        checkPrintingToConsole.print(check);
        checkPrintingToFile.print(check);
    }
}