import model.data.implemented.DepartmentRepositoryMemory;
import model.entities.Department;
import model.entities.Dependent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    Department d1 = new Department(0,"cia","via dei mille",5);
    Department d2 = new Department(0,"ciao","via dei mille",5);
    Department d3 = new Department(0,"cio","via dei mille",5);
    Dependent de1 = new Dependent(0,"mario","rossi",'M',LocalDate.now());
    Dependent de2 = new Dependent(1,"ciccio","papero",'M',LocalDate.now());
    Dependent de3 = new Dependent(0,"pippo","pluto",'M',LocalDate.now());

    @BeforeEach
    void setUp() throws IOException {
    }

    @AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void deleteDepartmentByID(){
        DepartmentRepositoryMemory repo = new DepartmentRepositoryMemory();
        List<Department> list = new ArrayList<>();
        repo.create(d1);
        repo.create(d2);
        repo.create(d3);
        System.out.println(d1.getDependentList().size());
        System.out.println(DepartmentRepositoryMemory.getDepartmentList().size());
        repo.deleteDepartmentByID(1);
        System.out.println(DepartmentRepositoryMemory.getDepartmentList().size());

    }
    @org.junit.jupiter.api.Test
    void findDepartmentByName(){
        DepartmentRepositoryMemory repo = new DepartmentRepositoryMemory();
        List<Department> list = new ArrayList<>();
        repo.create(d1);
        repo.create(d2);
        repo.create(d3);
        d1.addToList(de1);
        d1.addToList(de2);
        d1.addToList(de3);
        System.out.println(d1.getDependentList().size());
        assertEquals(4,repo.findDepartmentByName("cia").size());


    }

}
