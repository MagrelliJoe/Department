package model.data.abstracted;

import model.entities.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentRepository {

    Department create(Department department) throws SQLException;
    void deleteDepartmentByID(long ID) throws SQLException;
    List<Object> findDepartmentByName(String part);
}
