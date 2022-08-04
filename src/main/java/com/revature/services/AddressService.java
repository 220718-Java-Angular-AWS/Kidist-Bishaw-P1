package com.revature.services;


import com.revature.daos.AddressDAO;
import com.revature.pojos.Address;

import java.util.List;

public class AddressService {

    private AddressDAO dao;

    public AddressService() {
        this.dao = new AddressDAO();
    }

    public void saveAddress(Address address) {
        dao.create(address);
    }

    public Address getAddress(int id) {
        return dao.read(id);
    }

    public List<Address> getAll() {
        return dao.readAll();
    }

    public void updateAddress(Address address) {
        dao.update(address);
    }

    public void deleteAddress(int id) {
        dao.delete(id);
    }

}
