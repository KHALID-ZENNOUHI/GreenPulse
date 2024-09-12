package GreenPulse.Service;

import GreenPulse.Entity.CarbonConsumption;
import GreenPulse.Entity.User;
import GreenPulse.Repository.CarbonConsumptionRepository;
import GreenPulse.Repository.UserRepository;
import GreenPulse.Util.Date;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static GreenPulse.Util.Date.periodToDates;

public class UserService {
    private UserRepository userRepository;
    private CarbonConsumptionRepository carbonConsumptionRepository;

    public UserService() throws SQLException {
        this.userRepository = new UserRepository();
        this.carbonConsumptionRepository = new CarbonConsumptionRepository();

    }

    public User save(User user) throws SQLException {
        return this.userRepository.save(user);
    }


    public User update(User user) throws SQLException {
        return this.userRepository.update(user);
    }

    public Boolean delete(int id) throws SQLException {
       return this.userRepository.delete(id);
    }

    public User findById(int id) throws SQLException {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public List<User> filterByTotalCarbonConsumption(List<User> users, float consumptionFilteredBy) throws SQLException {
        CarbonConsumptionService carbonConsumptionService = new CarbonConsumptionService();
        List<User> filteredUsers = users.stream().filter(user -> {
            try {
                return carbonConsumptionService.totalCarbonConsumption(user) > consumptionFilteredBy;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        return filteredUsers;
    }

    public List<User> findUsersWithoutConsumptionInPeriod(List<User> users, LocalDate startDate, LocalDate endDate) throws SQLException {
        List<LocalDate> dates = Date.periodToDates(startDate, endDate);
        List<User> filteredUsers = new ArrayList<>();

        for (User user : users) {
            List< CarbonConsumption> consumptions = carbonConsumptionRepository.findAllUserCarbonConsumptions(user);
           if(consumptions.stream().filter(consumption -> !Date.isAvailableDate(consumption.getStartDate(), consumption.getEndDate(), dates)).collect(Collectors.toList()).isEmpty()) filteredUsers.add(user);
        }
        return filteredUsers;
    }

    public List<User> sortUsers

}



