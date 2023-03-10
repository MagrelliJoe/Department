package model.data.abstracted;

import model.entities.Department;

import java.util.List;

public interface DepartmentRepository {

    Department create(Department department);
    void deleteDepartmentByID(long ID);
    List<Object> findDepartmentByName(String part);
}
