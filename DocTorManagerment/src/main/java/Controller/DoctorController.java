/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataAccess.DoctorDao;
import Model.Doctor;
import Reponsitory.DoctorReponsitory;
import View.Menu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bravo
 */
public class DoctorController extends Menu {

    private DoctorReponsitory doctorReponsitory;
    static String[] option = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};

    public DoctorController() {
        super("========= Doctor Management ==========", option);
        doctorReponsitory = new DoctorReponsitory();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                doctorReponsitory.addDoctor();
                break;
            case 2:
                doctorReponsitory.updateDoctor();
                break;
            case 3:
                doctorReponsitory.deleteDoctor();
                break;
            case 4:
                doctorReponsitory.searchDoctor();
                break;
            case 5:
                System.out.println("Exit");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!!!");
        }
    }

}
