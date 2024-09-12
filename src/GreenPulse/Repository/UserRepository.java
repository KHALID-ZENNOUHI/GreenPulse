package GreenPulse.Repository;


import GreenPulse.Config.DataBaseConnection;
import GreenPulse.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
        private Connection connection;

        public UserRepository () throws SQLException {
            this.connection = DataBaseConnection.getInstance().getConnection();
        }

        public User save(User user) throws SQLException {
            String query = "INSERT INTO users (firstName, lastNAme, age) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.executeUpdate();
            return user;
        }

        public User update(User user) throws SQLException {
            String query = "UPDATE users SET firstName = ?, lastName = ?, age = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            return user;
        }

        public Boolean delete(int id) throws SQLException {
                Optional<User> optionalUser = findById(id);
                String query = "DELETE FROM users WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
                return optionalUser.isPresent();
        }

        public Optional<User> findById(int id) throws SQLException {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User( resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getInt("age"));
                user.setId(resultSet.getInt("id"));
                return Optional.of(user);
            }
            return Optional.empty();
        }

        public List<User> findAll() throws SQLException {
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getInt("age")));
            }
            return users;
        }


    }
