package dao.Impl;

import dataBase.Database;
import generic.GenericService;
import model.Department;
import model.Hospital;
import service.DepartmentService;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentService, GenericService<Department> {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {

        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                return hospital.getDepartments();
            }

        }

        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department : hospital.getDepartments()) {
                if (department.getDepartmentName().equals(name)) {
                    return department;
                }
            }

        }
        return null;
    }

    @Override
    public Department add(Long hospitalId, Department department) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(hospitalId)) {
                hospital.getDepartments().add(department);
                return department;

            }

        }
        System.out.println("Hospital id no correct");
        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                for (Department department : hospital.getDepartments()) {
                    Database.hospitals.remove(department);
                    System.out.println("success fyllu removed");
                }
            } else {
                System.out.println("not found id " + id);
            }
        }

    }

    @Override
    public String upDateById(Long id, Department department) {
        for (Hospital hospital : Database.hospitals) {
            if (hospital.getId().equals(id)) {
                hospital.getDepartments().add(department);
                return "success ful removed";
            }


        }
        return null;
    }
}
