package GreenPulse.Entity;

import java.time.LocalDate;

public class Food extends CarbonConsumption {
    private FoodType foodType;
    private Float weight;
    private int carbonConsumptionId;

    public Food(int carbonConsumptionId, LocalDate startDate, LocalDate endDate, float carbon_consumption, GreenPulse.Entity.CarbonConsumptionType CarbonConsumptionType, int userId, FoodType foodType, Float weight) {
        super(carbonConsumptionId, startDate, endDate, carbon_consumption, CarbonConsumptionType, userId);
        this.foodType = foodType;
        this.weight = weight;
//        this.carbonConsumptionId = carbonConsumptionId;
    }

    public Food () {
        super();
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public int getCarbonConsumptionId() {
        return carbonConsumptionId;
    }

    public void setCarbonConsumptionId(int carbonConsumptionId) {
        this.carbonConsumptionId = carbonConsumptionId;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodType=" + foodType +
                ", weight=" + weight +
                '}';
    }

    @Override
    public Double calculeImpact() {
        Double impact = (foodType == FoodType.Meat) ? 5.0 : 0.5;
        return super.getCarbon_consumption() * impact * weight;
    }
}
