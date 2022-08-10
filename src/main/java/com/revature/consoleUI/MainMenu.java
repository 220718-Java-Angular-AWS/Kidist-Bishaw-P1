package com.revature.consoleUI;

import com.revature.services.ConsoleService;

import java.sql.SQLOutput;
import java.util.Scanner;

//we will be replacing it with an API very soon.
public class MainMenu extends View{
    public MainMenu() {
        viewName = "MainMenu";
        consoleService = ConsoleService.getConsoleService();
    }

    @Override
    public void renderView() {
        System.out.println("==================Main Menu================");
        System.out.println("N) New User \n U) Update User \n D) Delete User");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input){
            case "N":
                System.out.println("Navigating...");
                consoleService.navigate("NewUser");
                break;
            case "U":
                consoleService.navigate("UpdateUser");
                break;
            case "D":
                consoleService.navigate("DeleteUser");
                break;
            case "G":
                consoleService.navigate("GetUser");
                break;
            case "A":
                consoleService.navigate("GetAllUsers");
                break;
            case "Q":
                consoleService.quit();
                break;
        }

    }
}
