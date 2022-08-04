package com.revature.daos;

import com.revature.pojos.Address;
import com.revature.services.DataAccessService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AddressDAO implements DataSourceCRUD<Address> {

    Connection connection;

    public AddressDAO() {
        this.connection = DataAccessService.getConnection();
    }

    @Override
    public void create(Address address) {
        try {
            String sql = "INSERT INTO address (address, city, state, zip) VALUES(?, ?, ?, 0)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, address.getAddress());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getState());
            statement.setString(4, address.getZip());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Address read(int id) {
        Address address = new Address();

        try {
            String sql = "SELECT address_id, address, city, state, zip FROM address WHERE address_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                address.setAddressId(resultSet.getInt("address_id"));
                address.setAddress(resultSet.getString("address"));
                address.setCity(resultSet.getString("city"));
                address.setState(resultSet.getString("state"));
                address.setZip(resultSet.getString("zip"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public List<Address> readAll() {
        List<Address> addressList = new LinkedList<>();

        try {
            String sql = "SELECT * FROM address";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Address address = new Address();
                address.setAddressId(resultSet.getInt("address_id"));
                address.setAddress(resultSet.getString("address"));
                address.setCity(resultSet.getString("city"));
                address.setState(resultSet.getString("state"));
                address.setZip(resultSet.getString("zip"));

                addressList.add(address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addressList;
    }

    @Override
    public void update(Address address) {
        try {
            String sql = "UPDATE address SET address = ?, city = ?, state = ?, zip = ? WHERE address_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, address.getAddress());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getState());
            statement.setString(4, address.getZip());
            statement.setInt(5, address.getAddressId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM address WHERE address_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}