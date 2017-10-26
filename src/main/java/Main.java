import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/MY";
        String name = "admin";
        String password = "mypass";
        Connection connection = DriverManager.getConnection(url, name, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");
        while (resultSet.next()) {
            System.out.println("Номер в выборке " + resultSet.getRow() + " column_1 = " + resultSet.getString("column_1"));
        }
    }
}
