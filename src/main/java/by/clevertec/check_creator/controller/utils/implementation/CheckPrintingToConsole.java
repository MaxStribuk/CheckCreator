package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.ICheckPrinting;
import by.clevertec.check_creator.core.dto.CheckDTO;

public class CheckPrintingToConsole implements ICheckPrinting {

    @Override
    public void print(CheckDTO check) {
        System.out.println(check);
    }
}