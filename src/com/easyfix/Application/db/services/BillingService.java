package com.easyfix.Application.db.services;

import com.easyfix.Application.models.BillModel;

public interface BillingService {
    public void storeBill(BillModel Bill);
    public void getBill(BillModel Bill);
}
