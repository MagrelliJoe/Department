package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private long ID;
    private String name;
    private String address;
    private int maxCapacity;
    private List<Dependent> dependentList = new ArrayList<>();

    public Department(long ID, String name, String address, int maxCapacity) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.maxCapacity = maxCapacity;
    }

    public List<Dependent> getDependentList() {
        return dependentList;
    }

    public void setDependentList(List<Dependent> dependentList) {
        this.dependentList = dependentList;
    }

    public void addToList(Dependent dependent){
        dependentList.add(dependent);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }



    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
