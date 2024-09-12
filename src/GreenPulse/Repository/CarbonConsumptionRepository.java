package GreenPulse.Repository;


import GreenPulse.Config.DataBaseConnection;
import GreenPulse.Entity.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarbonConsumptionRepository {
    private Connection connection;

    public CarbonConsumptionRepository() throws SQLException {
        this.connection = DataBaseConnection.getInstance().getConnection();
    }

    public int save(CarbonConsumption carbonConsumption) throws SQLException {
        String query = "INSERT INTO carbon_consumption (start_date, end_date, carbon_consumption, carbon_consumption_type, user_id) values (?,?,?,?::carbon_consumption_type,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setDate(1, java.sql.Date.valueOf(carbonConsumption.getStartDate()));
        preparedStatement.setDate(2, java.sql.Date.valueOf(carbonConsumption.getEndDate()));
        preparedStatement.setFloat(3, carbonConsumption.getCarbon_consumption());
        preparedStatement.setObject(4, carbonConsumption.getCarbonConsumptionType().name());
        preparedStatement.setInt(5, carbonConsumption.getUserId());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            carbonConsumption.setId(resultSet.getInt(1));
        }
        return carbonConsumption.getId();

    }

    public Food saveFood(Food food) throws SQLException {
        int carbonConsumptionId = save(food);
        String query = "INSERT INTO food (carbonConsumptionId, foodType, weight) values (?,?::food_type,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, carbonConsumptionId);
        preparedStatement.setObject(2, food.getFoodType().name());
        preparedStatement.setFloat(3, food.getWeight());
        preparedStatement.executeUpdate();
        return food;
    }


    public Transport saveTransport(Transport transport) throws SQLException {
        int carbonConsumptionId = save(transport);
        String query = "INSERT INTO transport (carbon_consumption_id, transport_type, distance_traveled) values (?,?::transport_type,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, carbonConsumptionId);
        preparedStatement.setObject(2, transport.getTransportType().name());
        preparedStatement.setDouble(3, transport.getDistanceTraveled());
        preparedStatement.executeUpdate();
        return transport;
    }


    public Housing saveHousing(Housing housing) throws SQLException {
        int carbonConsumptionId = save(housing);
        String query = "INSERT INTO housing (carbon_consumption_id, energy_type, energy_consumption) values (?,?::energy_type,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, carbonConsumptionId);
        preparedStatement.setObject(2, housing.getEnergyType().name());
        preparedStatement.setDouble(3, housing.getEnergyConsumption());
        preparedStatement.executeUpdate();
        return housing;
    }

    public int update(CarbonConsumption carbonConsumption) throws SQLException {
        String query = "UPDATE carbon_consumption SET start_date = ?, end_date = ?, carbon_consumption = ?, carbon_consumption_type = ?::carbon_consumption_type, user_id = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setDate(1, java.sql.Date.valueOf(carbonConsumption.getStartDate()));
        preparedStatement.setDate(2, java.sql.Date.valueOf(carbonConsumption.getEndDate()));
        preparedStatement.setFloat(3, carbonConsumption.getCarbon_consumption());
        preparedStatement.setObject(4, carbonConsumption.getCarbonConsumptionType().name());
        preparedStatement.setInt(5, carbonConsumption.getUserId());
        preparedStatement.setInt(6, carbonConsumption.getId());
        preparedStatement.executeUpdate();
        return carbonConsumption.getId();
    }


    public Food updateFood(Food food) throws SQLException {
        int carbonConsumptionId = update(food);
        String query = "UPDATE food SET foodType = ?::food_type, weight = ? WHERE carbonConsumptionId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setObject(1, food.getFoodType().name());
        preparedStatement.setFloat(2, food.getWeight());
        preparedStatement.setInt(3, carbonConsumptionId);
        preparedStatement.executeUpdate();
        return food;
    }

    public Transport updateTransport(Transport transport) throws SQLException {
        int carbonConsumptionId = update(transport);
        String query = "UPDATE transport SET transport_type = ?::transport_type, distance_traveled = ? WHERE carbon_consumption_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setObject(1, transport.getTransportType().name());
        preparedStatement.setDouble(2, transport.getDistanceTraveled());
        preparedStatement.setInt(3, carbonConsumptionId);
        preparedStatement.executeUpdate();
        return transport;
    }

    public Housing updateHousing(Housing housing) throws SQLException {
        int carbonConsumptionId = update(housing);
        String query = "UPDATE housing SET energy_type = ?::energy_type, energy_consumption = ? WHERE carbon_consumption_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setObject(1, housing.getEnergyType().name());
        preparedStatement.setDouble(2, housing.getEnergyConsumption());
        preparedStatement.setInt(3, carbonConsumptionId);
        preparedStatement.executeUpdate();
        return housing;
    }

    public Optional<Food> deleteFood(int id) throws SQLException {
        // First, try to find the Food entity by its ID
        Optional<Food> foodOpt = findFoodById(id);

        if (foodOpt.isPresent()) {
            // If the entity is found, delete it
            String query = "DELETE FROM food WHERE carbonConsumptionId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            // Return the deleted entity
            return foodOpt;
        } else {
            // If not found, return Optional.empty()
            return Optional.empty();
        }
    }

    public Optional<Transport> deleteTransport(int id) throws SQLException {
        // First, try to find the Transport entity by its ID
        Optional<Transport> transportOpt = findTransportById(id);

        if (transportOpt.isPresent()) {
            // If the entity is found, delete it
            String query = "DELETE FROM transport WHERE carbon_consumption_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            // Return the deleted entity
            return transportOpt;
        } else {
            // If not found, return Optional.empty()
            return Optional.empty();
        }
    }

    public Optional<Housing> deleteHousing(int id) throws SQLException {
        // First, try to find the Housing entity by its ID
        Optional<Housing> housingOpt = findHousingById(id);

        if (housingOpt.isPresent()) {
            // If the entity is found, delete it
            String query = "DELETE FROM housing WHERE carbon_consumption_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            // Return the deleted entity
            return housingOpt;
        } else {
            // If not found, return Optional.empty()
            return Optional.empty();
        }
    }

    public Optional<Food> findFoodById(int id) throws SQLException {
        String query = "SELECT * FROM food WHERE carbonConsumptionId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Assuming you have a constructor or method to create a Food object from a ResultSet
            Food food = new Food();
            food.setCarbonConsumptionId(id); // Assuming id is carbonConsumptionId
            food.setFoodType(FoodType.valueOf(resultSet.getString("foodType")));
            food.setWeight(resultSet.getFloat("weight"));
            return Optional.of(food);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Transport> findTransportById(int id) throws SQLException {
        String query = "SELECT * FROM transport WHERE carbon_consumption_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Assuming you have a constructor or method to create a Transport object from a ResultSet
            Transport transport = new Transport();
            transport.setCarbonConsumptionId(id); // Assuming id is carbon_consumption_id
            transport.setTransportType(TransportType.valueOf(resultSet.getString("transport_type")));
            transport.setDistanceTraveled(resultSet.getDouble("distance_traveled"));
            return Optional.of(transport);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Housing> findHousingById(int id) throws SQLException {
        String query = "SELECT * FROM housing WHERE carbon_consumption_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Assuming you have a constructor or method to create a Housing object from a ResultSet
            Housing housing = new Housing();
            housing.setCarbonConsumptionId(id); // Assuming id is carbon_consumption_id
            housing.setEnergyType(EnergyType.valueOf(resultSet.getString("energy_type")));
            housing.setEnergyConsumption(resultSet.getFloat("energy_consumption"));
            return Optional.of(housing);
        } else {
            return Optional.empty();
        }
    }

    public List<CarbonConsumption> findAllUserCarbonConsumptions(User user) throws SQLException {
        String query = "SELECT * FROM carbon_consumption WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CarbonConsumption> carbonConsumptions = new ArrayList<>();

        while (resultSet.next()) {
            int carbonConsumptionId = resultSet.getInt("carbon_consumption_id");
            LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
            LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
            float carbonConsumption = resultSet.getFloat("carbon_consumption");
            CarbonConsumptionType carbonConsumptionType = CarbonConsumptionType.valueOf(resultSet.getString("carbon_consumption_type"));

            if (carbonConsumptionType.equals(CarbonConsumptionType.Transport)) {
                Double distanceTraveled  = resultSet.getDouble("distance_traveled");
                TransportType transportType = TransportType.valueOf(resultSet.getString("transport_type"));
                Transport transport = new Transport(carbonConsumptionId, startDate, endDate, carbonConsumption, carbonConsumptionType, user.getId(), distanceTraveled, transportType);
                carbonConsumptions.add(transport);
            } else if (carbonConsumptionType.equals(CarbonConsumptionType.Housing)) {
                Float energyConsumption = resultSet.getFloat("energy_consumption");
                EnergyType energyType = EnergyType.valueOf(resultSet.getString("energy_type"));
                Housing housing = new Housing(carbonConsumptionId, startDate, endDate, carbonConsumption, carbonConsumptionType, user.getId(), energyConsumption, energyType);
                carbonConsumptions.add(housing);
            }else {
                Float weight = resultSet.getFloat("weight");
                FoodType foodType = FoodType.valueOf(resultSet.getString("foodType"));
                Food food = new Food(carbonConsumptionId, startDate, endDate,carbonConsumption, carbonConsumptionType, user.getId(), foodType, weight);
                carbonConsumptions.add(food);
            }
        }
        return carbonConsumptions;
    }

}
