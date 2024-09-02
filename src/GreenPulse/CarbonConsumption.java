package GreenPulse.Service;

import GreenPulse.User;

import java.time.LocalDate;
import java.util.UUID;

public class CarbonConsumption {
    private int id = UUID.randomUUID().hashCode();
    private LocalDate startDate;
    private LocalDate endDate;
    private float carbon;
    private User user;


    public CarbonConsumption(LocalDate startDate, LocalDate endDate, float carbon , User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.carbon = carbon;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Float getCarbon() {
        return carbon;
    }

    public void setCarbon(float carbon) {
        this.carbon = carbon;
    }
}
