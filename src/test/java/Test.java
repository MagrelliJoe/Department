import model.data.implemented.DepartmentRepositoryMemory;
import model.data.implemented.DepartmentRepositoryStream;
import model.entities.Department;
import model.entities.Dependent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    Department d1 = new Department(0,"messina","via dei mille",5);
    Department d2 = new Department(0,"esso","via dei mille",5);
    Department d3 = new Department(0,"empoli","via dei mille",5);
    Dependent de1 = new Dependent(0,"mario","rossi",'M',LocalDate.now());
    Dependent de2 = new Dependent(0,"ciccio","papero",'M',LocalDate.now());
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
        assertEquals(4,repo.findDepartmentByName("messina").size());

    }
    @org.junit.jupiter.api.Test
    void deleteDepartmentByIDSTREAM() throws SQLException {
        DepartmentRepositoryStream repo1 = new DepartmentRepositoryStream();
        repo1.create(d1);
        repo1.create(d2);
        repo1.create(d3);
        d1.addToList(de1);
        d1.addToList(de2);
        d1.addToList(de3);
        System.out.println(DepartmentRepositoryStream.getDepartmentList().size());
        repo1.deleteDepartmentByID(1);
        System.out.println(DepartmentRepositoryStream.getDepartmentList().size());
    }

    @org.junit.jupiter.api.Test
    void findDepartmentByIDSTREAM() throws SQLException {
        DepartmentRepositoryStream repo1 = new DepartmentRepositoryStream();
        repo1.create(d1);
        repo1.create(d2);
        repo1.create(d3);
        d1.addToList(de1);
        d1.addToList(de2);
        d1.addToList(de3);
        assertEquals(3,DepartmentRepositoryStream.getDepartmentList().size());
        int n = repo1.findDepartmentByNameStream("m").size();
        assertEquals(2,n);
    }



}
