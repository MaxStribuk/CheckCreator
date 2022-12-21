package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.IDataConsoleExtractor;
import by.clevertec.check_creator.core.dto.InputProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleDataExtractorTest {

    @Test
    void getProducts1() {
        IDataConsoleExtractor consoleExtractor = new ConsoleDataExtractor();
        String[] args = {"1-1", "2-2", "card-1"};
        List<InputProductDTO> actual = consoleExtractor.getProducts(args);
        List<InputProductDTO> expected = List.of(
                new InputProductDTO(1,1),
                new InputProductDTO(2,2));
        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    void getProducts2() {
        IDataConsoleExtractor consoleExtractor = new ConsoleDataExtractor();
        String[] args = {"1-1", "1-5", "card-1"};
        List<InputProductDTO> actual = consoleExtractor.getProducts(args);
        List<InputProductDTO> expected = List.of(
                new InputProductDTO(1,6));
        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    void getProducts3() {
        IDataConsoleExtractor consoleExtractor = new ConsoleDataExtractor();
        String[] args = {"card-1"};
        assertThrows(IllegalArgumentException.class,
                () -> consoleExtractor.getProducts(args));
    }

    @Test
    void getProducts4() {
        IDataConsoleExtractor consoleExtractor = new ConsoleDataExtractor();
        String[] args = {"1-1-1", "2-2", "card-1"};
        assertThrows(IllegalArgumentException.class,
                () -> consoleExtractor.getProducts(args));
    }

    @Test
    void getNumberDiscountCard1() {
        IDataConsoleExtractor consoleExtractor = new ConsoleDataExtractor();
        String[] args = {"1-1", "2-2", "card-1"};
        Integer actual = consoleExtractor.getNumberDiscountCard(args);
        Integer expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getNumberDiscountCard2() {
        IDataConsoleExtractor consoleExtractor = new ConsoleDataExtractor();
        String[] args = {"1-1", "2-2"};
        Integer actual = consoleExtractor.getNumberDiscountCard(args);
        Integer expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void getNumberDiscountCard3() {
        IDataConsoleExtractor consoleExtractor = new ConsoleDataExtractor();
        String[] args = {"1-1", "2-2", "card-1", "card-2"};
        assertThrows(IllegalArgumentException.class,
                () -> consoleExtractor.getNumberDiscountCard(args));
    }

    @Test
    void getNumberDiscountCard4() {
        IDataConsoleExtractor consoleExtractor = new ConsoleDataExtractor();
        String[] args = {"1-1", "card-1-1"};
        assertThrows(IllegalArgumentException.class,
                () -> consoleExtractor.getNumberDiscountCard(args));
    }
}