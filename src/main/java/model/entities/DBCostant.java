package model.entities;

public class DBCostant {
    public static final String INSERT_DEPARTMENT = """
              INSERT INTO departments(id_department,name, address, max_capacity)
                     VALUES(nextval('departments_sequence'),?, ?, ?);
            """;
    public static final String DELETE_DEPARTMENT_BY_ID = """
               DELETE FROM departments
               WHERE id_department = ?
            """;
    public static final String FIND_DEPARTMENT_BY_NAME = """
            SELECT DE.NAME
            FROM DEPENDENTS AS DE join DEPARTMENTS AS D
            ON DE.ID_DEPARTMENT = D.ID_DEPARTMENT AND D.NAME = ?
            """;
}
