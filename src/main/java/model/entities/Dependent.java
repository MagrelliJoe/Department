package model.entities;

import java.sql.Date;
import java.time.LocalDate;

public class Dependent {
    private long ID;
    private String name,lastname;
    private char sex;
    private LocalDate DateOfEmployment;
    private Department department;

    public Dependent(long ID, String name, String lastname, char sex, LocalDate dateOfEmployment) {
        this.ID = ID;
        this.name = name;
        this.lastname = lastname;
        this.sex = sex;
        this.DateOfEmployment = dateOfEmployment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfEmployment() {
        return DateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        DateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "name='" + name + '\'' +
                '}';
    }
}
