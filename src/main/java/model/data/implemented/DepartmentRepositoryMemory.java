package model.data.implemented;
import model.data.abstracted.DepartmentRepository;
import model.entities.Department;
import model.entities.Dependent;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryMemory implements DepartmentRepository {
    static List<Department> departmentList = new ArrayList<>();
    private long id;
    @Override
    public Department create(Department department) {
        departmentList.add(department);
        department.setID(id);
        id++;
        return department;
    }

    @Override
    public void deleteDepartmentByID(long ID) {
       for(Department department: departmentList){
           if(department.getID()==ID){
               departmentList.remove(department);
               break;
           }
       }
    }

    @Override
    public List<Object> findDepartmentByName(String part) {
        List<Object> list = new ArrayList<>();
        for(Department department : departmentList){
            if(department.getName().equalsIgnoreCase(part)){
                list.add(department);
                for(Dependent dependent : department.getDependentList()){
                    list.add(dependent);
                }
            }
        }
        System.out.println(list.toString());
        return list;
    }

    public static List<Department> getDepartmentList() {
        return departmentList;
    }
}
