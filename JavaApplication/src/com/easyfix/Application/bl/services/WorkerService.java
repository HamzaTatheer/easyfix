package com.easyfix.Application.bl.services;

public interface WorkerService {
    public int doesWorkerExist(int id);
    public int getActiveBookings(int id);
    public int getFinishedBookings(int id);
    public Boolean sendLocation(String newLocation);
}
