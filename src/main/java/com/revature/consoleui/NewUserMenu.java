package com.revature.consoleui;

import com.revature.ConnectionManager;
import com.revature.daos.UserDAO;
import com.revature.pojos.User;

import java.util.Scanner;

public class NewUserMenu extends View{
    public NewUserMenu() {
        viewName = "NewUser";
        viewManager = ViewManager.getViewManager();
    }


    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=========== New User ===========");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User newUser = new User(username, email, password);
        UserDAO dao = new UserDAO(ConnectionManager.getConnection());
        dao.create(newUser);

        viewManager.navigate("MainMenu");

    }
}
