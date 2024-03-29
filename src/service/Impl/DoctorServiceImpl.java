package service.Impl;

import dao.DoctorDao;
import dao.Impl.DoctorDaoImpl;
import generic.GenericService;
import model.Department;
import model.Doctor;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {
    DoctorDaoImpl doctorDao = new DoctorDaoImpl();

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorDao.assignDoctorToDepartment(departmentId, doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }

    @Override
    public Doctor add(Long hospitalId, Doctor doctor) {
        return doctorDao.add(hospitalId, doctor);
    }

    @Override
    public void removeById(Long id) {
        doctorDao.removeById(id);
    }

    @Override
    public String upDateById(Long id, Doctor doctor) {
        return doctorDao.upDateById(id, doctor);
    }
}
