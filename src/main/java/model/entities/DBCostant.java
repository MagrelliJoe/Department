package model.entities;

public class DBCostant {
    public static final String INSERT_DEPARTMENT = """
            INSERT INTO departments(name, address, capacity)
            VALUES(nextval('departments_sequence'),?, ?, ?, ?);
            """;
    public static final String DELETE_DEPARTMENT_BY_ID = """
               DELETE FROM departments
               WHERE id_department = ?
            """;
    public static final String FIND_DEPARTMENT_BY_ID = """
            SELECT d.id_department , d.dependent
            FROM departments as d JOIN dependents as de
            WHERE d.name = ?
            """;
}
