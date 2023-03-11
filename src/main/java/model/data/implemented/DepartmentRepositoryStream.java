package model.data.implemented;

import model.data.abstracted.DepartmentRepository;
import model.entities.Department;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryStream implements DepartmentRepository {
    static List<Department> departmentList = new ArrayList<>();
    private long id;

    @Override
    public Department create(Department department) throws SQLException {
        departmentList.add(department);
        department.setID(id);
        id++;
        return department;
    }

    @Override
    public void deleteDepartmentByID(long ID) throws SQLException {
       departmentList.removeIf(department -> department.getID()==ID);
    }

    public List<Department> findDepartmentByNameStream(String part) throws SQLException {
        List<Department> list1 = new ArrayList<>();
        departmentList.stream().filter(department->department.getName().contains(part))
                .allMatch(list1::add);
            for(int i=0;i<list1.size();i++) {
                System.out.println(list1.get(i).getDependentList().toString());
            }
        return list1;
    }
    public static List<Department> getDepartmentList() {
        return departmentList;
    }
    @Override
    public List<Object> findDepartmentByName(String part) throws SQLException {
        return null;
    }
}
