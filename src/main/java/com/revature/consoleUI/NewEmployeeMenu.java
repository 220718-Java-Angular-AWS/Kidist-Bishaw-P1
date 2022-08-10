package com.revature.consoleUI;

import com.revature.pojos.Employee;
import com.revature.services.ConsoleService;
import com.revature.services.EmployeeService;

import java.util.Scanner;

public class NewEmployeeMenu extends View{

    private EmployeeService service;

    public NewEmployeeMenu() {
        viewName = "NewUser";
        consoleService = ConsoleService.getConsoleService();
        service = new EmployeeService();
    }

    @Override
    public void renderView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================New User==============");
        System.out.println("Enter First Name");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name");
        String lastName = scanner.nextLine();
        System.out.println("Enter Address");
        String addressId = scanner.nextLine();
        System.out.println("Enter Email");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        System.out.println("Enter role");
        String role = scanner.nextLine();

        //Employee newEmployee = new Employee( firstName, lastName, addressId, email, password, role );

       //service.saveEmployee(newEmployee);

        consoleService.navigate("MainMenu");
    }
}
