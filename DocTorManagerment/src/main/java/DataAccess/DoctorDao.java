/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Model.Doctor;
import common.Validation;
import java.util.ArrayList;

/**
 *
 * @author Bravo
 */
public class DoctorDao {

    private ArrayList<Doctor> doctorList;

    public DoctorDao() {
        this.doctorList = new ArrayList<>();
    }

    private static DoctorDao instance = null;

    public static DoctorDao instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    public boolean CreateDoctor() {
        String choice;
        do {
            System.out.print("Enter code: ");
            String code = Validation.checkInputString();
            if (!Validation.checkCodeExist(doctorList, code)) {
                System.err.println("Code exists.");
                return false;
            }
            System.out.print("Enter name: ");
            String name = Validation.checkInputString();
            System.out.print("Enter specialization: ");
            String specialization = Validation.checkInputString();
            System.out.print("Enter availability: ");
            int availability = Validation.checkInputInt();
            if (!Validation.checkDuplicate(doctorList, code, name, specialization, availability)) {
                System.err.println("Duplicate entry.");
                return false;
            }
            doctorList.add(new Doctor(code, name, specialization, availability));
            System.out.println("Do you want to add more Doctors (Y/N)?");
            choice = Validation.checkInputString();
        } while (choice.equalsIgnoreCase("Y"));
        if (choice.equalsIgnoreCase("N")) {
            System.out.println("Doctor(s) added successfully!");
        }
        return true;
    }

    public boolean updateDoctor() {
        String choiceU;
        do {
            System.out.println("All Doctors:");
            displayAllDoctors();
            System.out.print("Enter code: ");
            String code = Validation.checkInputString();
            Doctor doctor = getDoctorByCode(code);
            if (doctor == null) {
                System.err.println("Doctor not found.");
                return false;
            }

            System.out.print("Enter new code: ");
            String codeUpdate = Validation.checkInputString();
            System.out.print("Enter new name: ");
            String name = Validation.checkInputString();
            System.out.print("Enter new specialization: ");
            String specialization = Validation.checkInputString();
            System.out.print("Enter new availability: ");
            int availability = Validation.checkInputInt();
            if (!Validation.checkChangeInfo(doctor, codeUpdate, name, specialization, availability)) {
                System.err.println("No changes made.");
                return false;
            }

            doctor.setCode(codeUpdate);
            doctor.setName(name);
            doctor.setSpecialization(specialization);
            doctor.setAvailability(availability);
            System.out.println("Doctor updated successfully!");
            System.out.print("Do you want to update more Doctors (Y/N)? ");
            choiceU = Validation.checkInputString();
        } while (choiceU.equalsIgnoreCase("Y"));
        return true;
    }

    public boolean deleteDoctor() {
        String choiceD;
        do {
            System.out.println("All Doctors:");
            displayAllDoctors();
            System.out.print("Enter code: ");
            String code = Validation.checkInputString();
            Doctor doctor = getDoctorByCode(code);
            if (doctor == null) {
                System.err.println("Doctor not found.");
            } else {
                doctorList.remove(doctor);
                System.out.println("Doctor deleted successfully!");
            }
            System.out.print("Do you want to delete more Doctors (Y/N)? ");
            choiceD = Validation.checkInputString();
        } while (choiceD.equalsIgnoreCase("Y"));
        return true;
    }

    public boolean searchDoctor() {
        String choiceS;
        do {
            System.out.println("All Doctors:");
            displayAllDoctors();
            System.out.print("Enter name: ");
            String nameSearch = Validation.checkInputString();
            ArrayList<Doctor> listFoundByName = listFoundByName(nameSearch);
            if (listFoundByName.isEmpty()) {
                System.err.println("No Doctors found with that name.");
            } else {
                System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                        "Specialization", "Availability");
                for (Doctor doctor : listFoundByName) {
                    System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                            doctor.getName(), doctor.getSpecialization(),
                            doctor.getAvailability());
                }
            }
            System.out.print("Do you want to search more Doctors (Y/N)? ");
            choiceS = Validation.checkInputString();
        } while (choiceS.equalsIgnoreCase("Y"));
        return true;
    }

    public Doctor getDoctorByCode(String code) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> listFoundByName(String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }

    private void displayAllDoctors() {
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                        "Specialization", "Availability");
        for (Doctor doctor : doctorList) {
             System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                            doctor.getName(), doctor.getSpecialization(),
                            doctor.getAvailability());
        }
    }
}
