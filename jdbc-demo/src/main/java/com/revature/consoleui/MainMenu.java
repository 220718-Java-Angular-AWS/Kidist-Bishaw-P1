package com.revature.consoleui;

import java.util.Scanner;

public class MainMenu extends View{

    public MainMenu() {
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        //prompt user
        System.out.println("========== Main Menu ==========");
        System.out.println("N) New User \nU) Update User \nD) Delete User \nG) Get User \nA) Get all Users \n\nQ) Quit ");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        switch(input) {
            case "N":
                System.out.println("Navigating...");
                viewManager.navigate("NewUser");
                break;
            case "U":
                viewManager.navigate("UpdateUser");
                break;
            case "D":
                viewManager.navigate("DeleteUser");
                break;
            case "G":
                viewManager.navigate("GetUser");
                break;
            case "A":
                viewManager.navigate("GetAllUsers");
                break;
            case "Q":
                viewManager.quit();
                break;
        }
        System.out.println("Nav complete?");

    }
}
