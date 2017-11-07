import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/main/resources/myRes/currentRes/myProperty.properties");
        property.load(fis);
        String url = property.getProperty("url");
        String name = property.getProperty("name");
        String password = property.getProperty("password");
        Connection connection = DriverManager.getConnection(url, name, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");
        while (resultSet.next()) {
            System.out.println("Номер в выборке " + resultSet.getRow() + " column_1 = " + resultSet.getString("column_1"));
        }
    }
}
