package com.easyfix.Application.bl.services;

import com.easyfix.Application.bl.classes.Billing;
import com.easyfix.Application.models.BillingModel;

public interface BillingService {
    public BillingModel showBill(int bid) throws Exception;
}
