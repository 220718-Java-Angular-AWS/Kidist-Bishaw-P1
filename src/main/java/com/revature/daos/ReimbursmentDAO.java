package com.revature.daos;

import com.revature.pojos.Reimbusment;
import com.revature.services.DataAccessService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReimbursmentDAO implements DataSourceCRUD<Reimbusment> {

    Connection connection;

    public ReimbursmentDAO() {
        this.connection = DataAccessService.getConnection();
    }

    @Override
    public void create(Reimbusment reimbusment) {

        try {
            String sql = "INSERT INTO reimbursments (expense_id, emp_id, amount, description, reimbursment_status) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,reimbusment.getExpenseId());
            statement.setInt(2, reimbusment.getEmployeeId());
            statement.setDouble(3,reimbusment.getAmount());
            statement.setString(4, reimbusment.getDescription());
            statement.setString(5, reimbusment.getStatus());

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Reimbusment read(int id) {
        Reimbusment reimbusment = new Reimbusment();
        try {
            String sql = "SELECT * FROM reimbursments WHERE reimbursment_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reimbusment.setExpenseId(resultSet.getInt("expense_id"));
                reimbusment.setEmployeeId(resultSet.getInt("emp_id"));
                reimbusment.setAmount(resultSet.getDouble("amount"));
                reimbusment.setDescription(resultSet.getString("description"));
                reimbusment.setStatus(resultSet.getString("reimbursment_status"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return reimbusment;
    }

    @Override
    public List<Reimbusment> readAll() {
        List<Reimbusment> reimbusmentList = new LinkedList<>();

        try {
            String sql = "SELECT * FROM reimbursments";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Reimbusment reimbusment = new Reimbusment();
                reimbusment.setReimbursmentId(resultSet.getInt("reimbursment_id"));
                reimbusment.setExpenseId(resultSet.getInt("expense_id"));
                reimbusment.setEmployeeId(resultSet.getInt("emp_id"));
                reimbusment.setAmount(resultSet.getDouble("amount"));
                reimbusment.setDescription(resultSet.getString("description"));
                reimbusment.setStatus(resultSet.getString("reimbursment_status"));
                reimbusmentList.add(reimbusment);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reimbusmentList;
    }

    @Override
    public void update(Reimbusment reimbusment) {
        try {
            String sql = "UPDATE reimbursments SET expense_id = ?, emp_id = ?, amount = ?, description = ?, reimbursment_status = ? WHERE reimbursment_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, reimbusment.getExpenseId());
            statement.setInt(2,reimbusment.getEmployeeId());
            statement.setDouble(3,reimbusment.getAmount());
            statement.setString(4, reimbusment.getDescription());
            statement.setString(5, reimbusment.getStatus());
            statement.setInt(6, reimbusment.getReimbursmentId());
            statement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM reimbursments WHERE reimbursment_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
