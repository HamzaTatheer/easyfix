package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingModel {
    public int id;
    public int wid;
    public int cid;
    public String text;
    public String status;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public ArrayList<Integer> spareParts;
}
