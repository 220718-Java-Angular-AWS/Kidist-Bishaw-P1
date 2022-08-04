package com.revature.daos;

import com.revature.pojos.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ExpenseDAO implements DataSourceCRUD<Expense> {

    Connection connection;

    public ExpenseDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Expense expenseType) {

        try {
            String sql = "INSERT INTO expensetypes(expense_type, description, costlimit) VALUES( ?, ?, 0)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, expenseType.getExpenseType());
            statement.setString(2, expenseType.getDescription());
            statement.setDouble(3, expenseType.getCostLimit());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Expense read(int id) {

        Expense expenseType = new Expense();
        try {
            String sql = "SELECT expense_id, expense_type, description, costlimit FROM expensetypes WHERE expense_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                expenseType.setExpenseId(resultSet.getInt("expense_id"));
                expenseType.setExpenseType(resultSet.getString("expense_type"));
                expenseType.setDescription(resultSet.getString("description"));
                expenseType.setCostLimit(resultSet.getInt("costlimit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenseType;
    }

    @Override
    public List<Expense> readAll() {

        List<Expense> expenseList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM expensetypes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Expense expenseType = new Expense();

                expenseType.setExpenseId(resultSet.getInt("expense_id"));
                expenseType.setExpenseType(resultSet.getString("expense_type"));
                expenseType.setDescription(resultSet.getString("description"));
                expenseType.setCostLimit(resultSet.getInt("costlimit"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenseList;
    }

    @Override
    public void update(Expense expenseType) {

        try {
            String sql = "UPDATE expensetypes SET expense_type = ?, description = ?, costlimit = 0 WHERE expense_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, expenseType.getExpenseType());
            statement.setString(2, expenseType.getDescription());
            statement.setDouble(3, expenseType.getCostLimit());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM expensetypes WHERE expense_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
