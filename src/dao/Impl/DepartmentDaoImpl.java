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
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    hospital.getDepartments().remove(department);
                    System.out.println("successfyllu removed");
                    return;
                }
            }
            throw new RuntimeException("not found id " + id);

        }
    }

    @Override
    public String upDateById(Long id, Department department) {
        for (Hospital hospital : Database.hospitals) {
            for (Department department1 : hospital.getDepartments()) {
                if (department1.getId().equals(id)) {
                    department1.setDepartmentName(department.getDepartmentName());
                    return "successfully removed";
                }
            }


        }
        return "not found";
    }
}
