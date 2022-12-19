package by.clevertec.check_creator.controller.utils.implementation.api;

import by.clevertec.check_creator.core.dto.CheckDTO;
import by.clevertec.check_creator.core.dto.PurchaseDTO;

public interface ICheckService {

    CheckDTO createCheck(PurchaseDTO purchase);
}