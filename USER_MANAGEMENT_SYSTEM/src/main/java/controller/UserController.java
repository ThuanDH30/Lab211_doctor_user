/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import reponsitory.UserReponsitory;
import view.Menu;

/**
 *
 * @author Bravo
 */
public class UserController extends Menu {
    private UserReponsitory UserReponsitory;
    static String[] option = {"Create a new account", "Login system","Exit"};

    public UserController() {
        super("====== USER MANAGEMENT SYSTEM ======", option);
        UserReponsitory = new UserReponsitory();
    }
    

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:
                UserReponsitory.addUser();
                break;
            case 2:
                UserReponsitory.UserSystem();
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid!!1");
        }
    }
    
}
