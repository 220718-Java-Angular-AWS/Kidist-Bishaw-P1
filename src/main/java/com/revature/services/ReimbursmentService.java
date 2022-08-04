package com.revature.services;

import com.revature.daos.ReimbursmentDAO;
import com.revature.pojos.Reimbusment;

import java.util.List;

public class ReimbursmentService {
    ReimbursmentDAO dao;

    public void saveReimbursment(Reimbusment reimbusment) {
        dao.create(reimbusment);
    }

    public Reimbusment getReimbursment(int id) {
        return dao.read(id);
    }

    public List<Reimbusment> getAllReimbursments() {
        return dao.readAll();
    }

    public void updateReimbursment(Reimbusment reimbusment) {
        dao.update(reimbusment);
    }

    public void deleteReimbursment(int id) {
        dao.delete(id);
    }

}
