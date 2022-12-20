package by.clevertec.check_creator.controller.servlets;

import by.clevertec.check_creator.controller.utils.api.ICheckPrinting;
import by.clevertec.check_creator.controller.utils.api.IDataServletExtractor;
import by.clevertec.check_creator.controller.utils.fabrics.CheckPrintingSingleton;
import by.clevertec.check_creator.controller.utils.fabrics.DataServletExtractorSingleton;
import by.clevertec.check_creator.core.dto.CheckDTO;
import by.clevertec.check_creator.core.dto.InputProductDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;
import by.clevertec.check_creator.service.api.ICheckService;
import by.clevertec.check_creator.service.fabrics.CheckServiceSengleton;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckServlet", urlPatterns = "/check")
public class CheckServlet extends HttpServlet {

    private final IDataServletExtractor dataExtractor;
    private final ICheckService checkService;
    private final ICheckPrinting checkPrinting;
    private static final String CARD_PARAM_NAME = "card";

    public CheckServlet() {
        this.dataExtractor = DataServletExtractorSingleton.getInstance();
        this.checkService = CheckServiceSengleton.getInstance();
        this.checkPrinting = CheckPrintingSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PurchaseDTO purchase = createPurchase(req);
        CheckDTO check = checkService.createCheck(purchase);
        checkPrinting.print(check);
    }

    private PurchaseDTO createPurchase(HttpServletRequest req)
            throws IllegalArgumentException {
        Integer numberDiscountCard = dataExtractor.getNumberDiscountCard(
                req.getParameterValues(CARD_PARAM_NAME));
        List<InputProductDTO> inputProducts = dataExtractor.getProducts(
                req.getParameterMap());
        return new PurchaseDTO(inputProducts, numberDiscountCard);
    }
}