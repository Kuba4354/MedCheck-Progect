package service.Impl;

import dao.DepartmentDao;
import dao.Impl.DepartmentDaoImpl;
import generic.GenericService;
import model.Department;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService, GenericService<Department> {

    DepartmentDaoImpl departmentDao =  new DepartmentDaoImpl();
    @Override
    public Department add(Long hospitalId, Department department) {
        return departmentDao.add(hospitalId, department);
    }

    @Override
    public void removeById(Long id) {
        departmentDao.removeById(id);
    }

    @Override
    public String upDateById(Long id, Department department) {
        return departmentDao.upDateById(id, department);
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }
}
