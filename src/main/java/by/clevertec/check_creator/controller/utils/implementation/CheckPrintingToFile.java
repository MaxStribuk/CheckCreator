package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.ICheckPrinting;
import by.clevertec.check_creator.core.dto.CheckDTO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckPrintingToFile implements ICheckPrinting {

    private final Path path;
    private static final String SUCCESSFULL_WRITE_CHECK_TO_FILE =
            "Successfully written check to the file";

    public CheckPrintingToFile() {
        this.path = Paths.get("check.txt");
    }

    @Override
    public void print(CheckDTO check) {
        try (FileOutputStream fos = new FileOutputStream(String.valueOf(path));
             OutputStreamWriter osw = new OutputStreamWriter(fos,
                     StandardCharsets.UTF_8))
        {
            osw.write(check.toString());
            System.out.println(SUCCESSFULL_WRITE_CHECK_TO_FILE);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}