/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitory;
import DataAccess.DoctorDao;

/**
 *
 * @author Bravo
 */
public class DoctorReponsitory implements IDoctorReponsitory {

    @Override
    public void addDoctor() {
        DoctorDao.instance().CreateDoctor();
    }

    @Override
    public void updateDoctor() {
        DoctorDao.instance().updateDoctor();
    }

    @Override
    public void deleteDoctor() {
        DoctorDao.instance().deleteDoctor();
    }

    @Override
    public void searchDoctor() {
        DoctorDao.instance().searchDoctor();
    }

}
