package com.revature.pojos;

import java.util.Objects;

public class Reimbusment {

    private Integer reimbursmentId;
    private Integer expenseId;
    private Integer employeeId;
    private Double amount;
    private String description;
    private String status;

    public Reimbusment() {
    }

    public Reimbusment(Integer reimbursmentId, Integer expenseId, Integer employeeId, Double amount, String description, String status) {
        this.reimbursmentId = reimbursmentId;
        this.expenseId = expenseId;
        this.employeeId = employeeId;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public Reimbusment(Integer expenseId, Integer employeeId, Double amount, String description, String status) {
        this.expenseId = expenseId;
        this.employeeId = employeeId;
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public Integer getReimbursmentId() {
        return reimbursmentId;
    }

    public void setReimbursmentId(Integer reimbursmentId) {
        this.reimbursmentId = reimbursmentId;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbusment that = (Reimbusment) o;
        return Objects.equals(reimbursmentId, that.reimbursmentId) && Objects.equals(expenseId, that.expenseId) && Objects.equals(employeeId, that.employeeId) && Objects.equals(amount, that.amount) && Objects.equals(description, that.description) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbursmentId, expenseId, employeeId, amount, description, status);
    }

    @Override
    public String toString() {
        return "Reimbusment{" +
                "reimbursmentId=" + reimbursmentId +
                ", expenseId=" + expenseId +
                ", employeeId=" + employeeId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
