package com.revature.services;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.ExpenseDAO;
import com.revature.pojos.Expense;

import java.util.List;

public class ExpenseService {
    ExpenseDAO dao;

    public void saveExpenseType(Expense expense){
        dao.create(expense);
    }
    public Expense getExpenseType(int id){
        return dao.read(id);
    }

    public List<Expense> getAllExpenseTypes(){
        return dao.readAll();
    }
    public void updateExpenseType(Expense expense){
        dao.update(expense);
    }
    public void deleteExpenseType(int id){
        dao.delete(id);
    }

}
