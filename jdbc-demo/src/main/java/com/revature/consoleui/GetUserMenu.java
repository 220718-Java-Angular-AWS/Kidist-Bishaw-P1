package com.revature.consoleui;

import com.revature.ConnectionManager;
import com.revature.daos.UserDAO;
import com.revature.pojos.User;

import java.util.Scanner;

public class GetUserMenu extends View{
    public GetUserMenu() {
        viewName = "GetUser";
        viewManager = ViewManager.getViewManager();
    }


    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========== Get User ==========");
        System.out.println("Enter user ID: ");
        String input = sc.nextLine();
        Integer userId = Integer.parseInt(input);

        UserDAO dao = new UserDAO(ConnectionManager.getConnection());
        User user = dao.read(userId);

        System.out.println(user);
        viewManager.navigate("MainMenu");

    }
}
