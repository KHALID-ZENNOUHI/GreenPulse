package GreenPulse.Entity;

import java.time.LocalDate;

public class Transport extends CarbonConsumption {
    private Double distanceTraveled;
    private TransportType transportType;
    private int carbonConsumptionId;

    public Transport(int carbonConsumptionId, LocalDate startDate, LocalDate endDate, float carbon_consumption, GreenPulse.Entity.CarbonConsumptionType CarbonConsumptionType, int userId, Double distanceTraveled, TransportType transportType) {
        super(carbonConsumptionId, startDate, endDate, carbon_consumption, CarbonConsumptionType, userId);
        this.distanceTraveled = distanceTraveled;
        this.transportType = transportType;
    }

    public Transport () {
        super();
    }

    public Double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(Double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public int getCarbonConsumptionId() {
        return carbonConsumptionId;
    }

    public void setCarbonConsumptionId(int carbonConsumptionId) {
        this.carbonConsumptionId = carbonConsumptionId;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "distanceTraveled=" + distanceTraveled +
                ", transportType=" + transportType +
                '}';
    }

    @Override
    public Double calculeImpact() {
        Double impact = (transportType == TransportType.Car) ? 0.5 : 0.1;
        return super.getCarbon_consumption() * distanceTraveled * impact;
    }
}
