package com.easyfix.Application.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingModel {
    public int id;
    public WorkerModel workerModel;
    public CustomerModel customerModel;
    public String text;
    public String status;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public ArrayList<SparePartModel> spareParts;
}
