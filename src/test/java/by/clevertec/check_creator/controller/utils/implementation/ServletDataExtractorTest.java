package by.clevertec.check_creator.controller.utils.implementation;

import by.clevertec.check_creator.controller.utils.api.IDataServletExtractor;
import by.clevertec.check_creator.core.dto.InputProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServletDataExtractorTest {

    @Test
    void getProducts1() {
        IDataServletExtractor servletExtractor = new ServletDataExtractor();
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("1", new String[]{"1", "2", "3", "4", "5"});
        parameterMap.put("2", new String[]{"5"});
        parameterMap.put("card", new String[]{"1"});
        List<InputProductDTO> actual = List.of(
                new InputProductDTO(1, 15),
                new InputProductDTO(2, 5));
        List<InputProductDTO> expected = servletExtractor.getProducts(parameterMap);
        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    void getProducts2() {
        IDataServletExtractor servletExtractor = new ServletDataExtractor();
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("1", new String[]{"1"});
        parameterMap.put("2", new String[]{"5"});
        parameterMap.put("card", new String[]{"1"});
        List<InputProductDTO> actual = List.of(
                new InputProductDTO(1, 1),
                new InputProductDTO(2, 5));
        List<InputProductDTO> expected = servletExtractor.getProducts(parameterMap);
        Assertions.assertIterableEquals(actual, expected);
    }

    @Test
    void getProducts3() {
        IDataServletExtractor servletExtractor = new ServletDataExtractor();
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("card", new String[]{"1"});
        assertThrows(IllegalArgumentException.class,
                () -> servletExtractor.getProducts(parameterMap));
    }

    @Test
    void getProducts4() {
        IDataServletExtractor servletExtractor = new ServletDataExtractor();
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("1", new String[]{""});
        assertThrows(IllegalArgumentException.class,
                () -> servletExtractor.getProducts(parameterMap));
    }

    @Test
    void getNumberDiscountCard1() {
        IDataServletExtractor servletExtractor = new ServletDataExtractor();
        String[] args = {"1", "2"};
        assertThrows(IllegalArgumentException.class,
                () -> servletExtractor.getNumberDiscountCard(args));
    }

    @Test
    void getNumberDiscountCard2() {
        IDataServletExtractor servletExtractor = new ServletDataExtractor();
        String[] args = null;
        Integer actual = servletExtractor.getNumberDiscountCard(args);
        Integer expected = null;
        assertEquals(actual, expected);
    }

    @Test
    void getNumberDiscountCard3() {
        IDataServletExtractor servletExtractor = new ServletDataExtractor();
        String[] args = {"1"};
        Integer actual = servletExtractor.getNumberDiscountCard(args);
        Integer expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    void getNumberDiscountCard4() {
        IDataServletExtractor servletExtractor = new ServletDataExtractor();
        String[] args = {"a"};
        assertThrows(IllegalArgumentException.class,
                () -> servletExtractor.getNumberDiscountCard(args));
    }
}