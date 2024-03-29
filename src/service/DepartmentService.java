package service;

import model.Department;
import service.Impl.DepartmentServiceImpl;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}
