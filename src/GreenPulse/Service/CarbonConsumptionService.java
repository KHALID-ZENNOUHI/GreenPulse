package GreenPulse.Service;

import GreenPulse.Entity.*;
import GreenPulse.Repository.CarbonConsumptionRepository;
import GreenPulse.Util.Date;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarbonConsumptionService {
    private CarbonConsumptionRepository carbonConsumptionRepository;

    public CarbonConsumptionService() throws SQLException {
        this.carbonConsumptionRepository = new CarbonConsumptionRepository();
    }

    public Food saveFood(Food food) throws SQLException {
        return carbonConsumptionRepository.saveFood(food);
    }

    public Transport saveTransport(Transport transport) throws SQLException {
        return carbonConsumptionRepository.saveTransport(transport);
    }

    public Housing saveHousing(Housing housing) throws SQLException {
        return carbonConsumptionRepository.saveHousing(housing);
    }

    public int update(CarbonConsumption carbonConsumption) throws SQLException {
        return carbonConsumptionRepository.update(carbonConsumption);
    }

    public Food updateFood(Food food) throws SQLException {
        return carbonConsumptionRepository.updateFood(food);
    }

    public Transport updateTransport(Transport transport) throws SQLException {
        return carbonConsumptionRepository.updateTransport(transport);
    }

    public Housing updateHousing(Housing housing) throws SQLException {
        return carbonConsumptionRepository.updateHousing(housing);
    }

    public Food deleteFood(int id) throws SQLException {
        return carbonConsumptionRepository.deleteFood(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Transport deleteTransport(int id) throws SQLException {
        return carbonConsumptionRepository.deleteTransport(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Housing deleteHousing(int id) throws SQLException {
        return carbonConsumptionRepository.deleteHousing(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Food findFoodById(int id) throws SQLException {
        return carbonConsumptionRepository.findFoodById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Transport findTransportById(int id) throws SQLException {
        return carbonConsumptionRepository.findTransportById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public Housing findHousingById(int id) throws SQLException {
        return carbonConsumptionRepository.findHousingById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }



    public Double totalCarbonConsumption(User user) throws SQLException {
        return carbonConsumptionRepository.findAllUserCarbonConsumptions(user).stream().mapToDouble(CarbonConsumption::calculeImpact).sum();
    }

    public Double averageCarbonConsumptionInPeriod(User user, LocalDate startDate, LocalDate endDate) throws SQLException {
        if (!startDate.isAfter(endDate)) {
            List<CarbonConsumption> carbonConsumptions = carbonConsumptionRepository.findAllUserCarbonConsumptions(user);
            List<LocalDate> dates = Date.periodToDates(startDate, endDate);

            return (carbonConsumptions.stream().filter(carbonConsumption -> !Date.isAvailableDate(carbonConsumption.getStartDate(), carbonConsumption.getEndDate(), dates)).mapToDouble(CarbonConsumption::calculeImpact).sum()) / dates.size();

        }
        return 0.0;
    }




}
