import java.sql.*;

public class TP09 {
    public static void main(String[] args) {
        /*Connection conn = null;
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/poo_a?user=root&password=my-secret-pw");

            Statement stm = conn.createStatement();
            // stm.executeUpdate("insert into user(fullname, login, pwd) values (\"Souha Jhinaoui\", \"Sasouki\", \"123\")");

            try (ResultSet resultSet = stm.executeQuery("select * from user")) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String fullname = resultSet.getString("fullname");
                    String login = resultSet.getString("login");
                    String pwd = resultSet.getString("pwd");
                    System.out.println(id + " " + fullname + " " + login + " " + pwd);
                }
            }
        *//*} catch (ClassNotFoundException ex) {
            System.err.println("Driver non chargé");*//*
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }*/

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/poo_a?user=root&password=my-secret-pw");
                Statement stm = conn.createStatement();
                ResultSet resultSet = stm.executeQuery("select * from user");
        ) {
            // Class.forName("com.mysql.cj.jdbc.Driver");


            // stm.executeUpdate("insert into user(fullname, login, pwd) values (\"Souha Jhinaoui\", \"Sasouki\", \"123\")");


            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String fullname = resultSet.getString("fullname");
                String login = resultSet.getString("login");
                String pwd = resultSet.getString("pwd");
                System.out.println(id + " " + fullname + " " + login + " " + pwd);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
