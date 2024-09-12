package GreenPulse.Entity;

import java.time.LocalDate;

public class Housing extends CarbonConsumption {
    private Float energyConsumption;
    private EnergyType energyType;
    private int carbonConsumptionId;

    public Housing(int carbonConsumptionId,LocalDate startDate, LocalDate endDate, float carbon_consumption, GreenPulse.Entity.CarbonConsumptionType CarbonConsumptionType, int userId, Float energyConsumption, EnergyType energyType) {
        super(carbonConsumptionId, startDate, endDate, carbon_consumption, CarbonConsumptionType, userId);
        this.energyConsumption = energyConsumption;
        this.energyType = energyType;
    }

    public Housing() {
        super();
    }

    public Float getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(Float energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    public int getCarbonConsumptionId() {
        return carbonConsumptionId;
    }

    public void setCarbonConsumptionId(int carbonConsumptionId) {
        this.carbonConsumptionId = carbonConsumptionId;
    }

    @Override
    public String toString() {
        return "Housing{" +
                "energyConsumption=" + energyConsumption +
                ", energyType=" + energyType +
                '}';
    }

    @Override
    public Double calculeImpact() {
        Double impact = (energyType == EnergyType.Gas) ? 2.0 : 1.5;
        return super.getCarbon_consumption() * energyConsumption * impact;
    }
}
