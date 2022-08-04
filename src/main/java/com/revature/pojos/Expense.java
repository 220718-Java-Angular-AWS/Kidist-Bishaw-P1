package com.revature.pojos;

import java.util.Objects;

public class Expense {

    private Integer expenseId;
    private String expenseType;
    private String description;
    private double costLimit;

    public Expense() {
    }

    public Expense(Integer expenseId, String expenseType, String description, double costLimit) {
        this.expenseId = expenseId;
        this.expenseType = expenseType;
        this.description = description;
        this.costLimit = costLimit;
    }

    public Expense(String expenseType, String description, double costLimit) {
        this.expenseType = expenseType;
        this.description = description;
        this.costLimit = costLimit;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCostLimit() {
        return costLimit;
    }

    public void setCostLimit(double costLimit) {
        this.costLimit = costLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.costLimit, costLimit) == 0 && Objects.equals(expenseId, expense.expenseId) && Objects.equals(expenseType, expense.expenseType) && Objects.equals(description, expense.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, expenseType, description, costLimit);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", expenseType='" + expenseType + '\'' +
                ", description='" + description + '\'' +
                ", costLimit=" + costLimit +
                '}';
    }
}
