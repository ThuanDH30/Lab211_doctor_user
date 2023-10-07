/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reponsitory;

import DataAccess.UserDao;

/**
 *
 * @author Bravo
 */
public class UserReponsitory implements IuserReponsitory {
    private UserDao view = new UserDao();

    @Override
    public void addUser() {
        view.createNewAccount();
    }

    @Override
    public void UserSystem() {
        view.loginSystem();
    }
    
}
