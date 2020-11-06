package com.easyfix.Application.bl.services;

import com.easyfix.Application.bl.classes.Billing;
import com.easyfix.Application.models.BillingModel;

public interface BillingService {
    public BillingModel showAllBill(int cid);
    public BillingModel generateBill(int bid);
}
