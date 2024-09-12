package GreenPulse.Entity;

import java.time.LocalDate;

public abstract class CarbonConsumption {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private float carbon_consumption;
    private int userId;
    private CarbonConsumptionType CarbonConsumptionType;


    public CarbonConsumption(int id, LocalDate startDate, LocalDate endDate, float carbon_consumption, CarbonConsumptionType CarbonConsumptionType, int userId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.carbon_consumption = carbon_consumption;
        this.CarbonConsumptionType = CarbonConsumptionType;
        this.userId = userId;
    }

    public CarbonConsumption () {

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

    public float getCarbon_consumption() {
        return carbon_consumption;
    }

    public void setCarbon_consumption(float carbon_consumption) {
        this.carbon_consumption = carbon_consumption;
    }

    public CarbonConsumptionType getCarbonConsumptionType() {
        return CarbonConsumptionType;
    }

    public void setCarbonConsumptionType(CarbonConsumptionType carbonConsumptionType) {
        CarbonConsumptionType = carbonConsumptionType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CarbonConsumption{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", carbon_consumption=" + carbon_consumption +
                ", userId=" + userId +
                ", CarbonConsumptionType=" + CarbonConsumptionType +
                '}';
    }

    public abstract Double calculeImpact();
}
