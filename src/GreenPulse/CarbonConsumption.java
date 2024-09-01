package GreenPulse;

import java.time.LocalDate;
import java.util.UUID;

public class Consumption {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Float carbon;
    private User user;
    private UUID uuid;

    public Consumption(LocalDate startDate, LocalDate endDate, Float carbon , User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.carbon = carbon;
        this.user = user;
        this.id = UUID.randomUUID().hashCode();
    }

    public UUID generateId(){
        return this.uuid = UUID.randomUUID();
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

    public void setCarbon(Float carbon) {
        this.carbon = carbon;
    }
}
