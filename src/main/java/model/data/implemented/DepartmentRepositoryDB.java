package model.data.implemented;

import model.data.abstracted.DepartmentRepository;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.entities.DBCostant.*;

public class DepartmentRepositoryDB implements DepartmentRepository {

    @Override
    public Department create(Department department) throws SQLException {
        try (Connection con = DriverManager.getConnection("ff", "ff", "ff");
             PreparedStatement st = con.prepareStatement(INSERT_DEPARTMENT);) {
            st.setString(1, department.getName());
            st.setString(2, department.getAddress());
            st.setInt(3, department.getMaxCapacity());
            st.executeUpdate();
            return department;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("errore dell'inserimento nel database");
        }
    }

    @Override
    public void deleteDepartmentByID(long ID) throws SQLException {

        try (Connection con = DriverManager.getConnection("ff", "ff", "ff");
             PreparedStatement st = con.prepareStatement(DELETE_DEPARTMENT_BY_ID);) {
            st.setLong(1, ID);
            int numLines = st.executeUpdate();
            if (numLines != 1) {
                throw new SQLException("Non e' stato trovato nessun department con questo ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("errore nella lettura dei dipartimenti dal database", e);
        }
    }

    @Override
    public List<Object> findDepartmentByName(String part) throws SQLException {
        try (Connection con = DriverManager.getConnection("ff", "ff", "ff");
             PreparedStatement st = con.prepareStatement(FIND_DEPARTMENT_BY_NAME);) {
            st.setString(1, "%" + part + "%");
            ResultSet rs = st.executeQuery();
            List<Object> objectList = new ArrayList<>();
            while (rs.next()) {
                objectList.add(rs);
            }
            return objectList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("errore nella lettura dei dipartimenti dal database", e);
        }

    }

}
