package dao.Impl;

import dataBase.Database;
import generic.GenericService;
import model.Department;
import model.Doctor;
import model.Hospital;
import service.DoctorService;

import java.util.List;

public class DoctorDaoImpl implements DoctorService, GenericService<Doctor> {

    @Override
    public Doctor add(Long hospitalId, Doctor doctor) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(hospitalId)) {
                hospital.getDoctors().add(doctor);
            }

        }
        return doctor;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId().equals(id)) {
                    hospital.getDoctors().remove(doctor);
                    System.out.println("success fyllu");
                }
            }
        }

    }

    @Override
    public String upDateById(Long id, Doctor doctor) {
        for (Hospital hospital : Database.hospitals) {
            for (Doctor doctor1 : hospital.getDoctors()) {
                if (doctor1.getId().equals(id)) {

                }
            }

        }
        return "not succes";
    }


    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId().equals(id)) {
                    return doctor;
                }
            }

        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(departmentId)) {
                    for (Doctor doctor : hospital.getDoctors()) {
                        if (doctorsId.contains(doctor.getId())) {
                            department.getDoctors().add(doctor);
                            hospital.getDoctors().remove(doctor);
                            return "success";
                        }
                    }
                }
            }
        }
        return "not fount";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getDoctors();

            }

        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    return department.getDoctors();
                }
            }

        }
        return null;
    }
}

