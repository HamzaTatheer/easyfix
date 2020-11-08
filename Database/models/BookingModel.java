package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingModel {
    public int id;
    public int WorkerName;
    public int customerName;
    public String text;
    public String status;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public ArrayList<Integer> spareParts;
}
