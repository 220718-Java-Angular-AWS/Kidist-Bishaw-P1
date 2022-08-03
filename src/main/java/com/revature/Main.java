package com.revature;

import com.revature.consoleui.*;
import com.revature.daos.UserDAO;
import com.revature.pojos.User;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Connecting...");
        Connection connection = ConnectionManager.getConnection();

        ViewManager viewManager = ViewManager.getViewManager();
        viewManager.registerView(new MainMenu());
        viewManager.registerView(new UpdateUserMenu());
        viewManager.registerView(new NewUserMenu());
        viewManager.registerView(new GetUserMenu());
        viewManager.registerView(new GetAllUsersMenu());
        viewManager.registerView(new DeleteUserMenu());

        viewManager.navigate("MainMenu");

        while(viewManager.isRunning()){
            viewManager.render();
        }







        //System.out.println("Done!");
    }
}
