package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Address;
import com.revature.services.AddressService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class AddressServlet extends HttpServlet {
    AddressService service;
    ObjectMapper mapper;

    public void init() throws ServletException{
        this.service = new AddressService();
        this.mapper = new ObjectMapper();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String addressId = request.getParameter("address_id");

        if(addressId.isEmpty()){
            response.getWriter().println(mapper.writeValueAsString(service.getAll()));
        }
        else {
            response.getWriter().println(mapper.writeValueAsString(service.getAddress(Integer.parseInt(addressId))));
        }
        response.setContentType("Application/Json; Charset=UTF-8");
        response.setStatus(200);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = request.getReader();

        while (bufferedReader.ready()){
            stringBuilder.append(bufferedReader.readLine());
        }

        service.saveAddress(mapper.readValue(stringBuilder.toString(), Address.class));
        response.setContentType("Application/Json; Charset=UTF-8");
        response.setStatus(200);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = request.getReader();

        while (bufferedReader.ready()){
            stringBuilder.append(bufferedReader.readLine());
        }
        service.updateAddress(mapper.readValue(stringBuilder.toString(), Address.class));
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        service.deleteAddress(Integer.parseInt(request.getParameter("address_id")));
    }

    public void destroy(){
    }
}
