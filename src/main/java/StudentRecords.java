import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentRecords {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Sowjanya@10";

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully!");


            Statement statement = connection.createStatement();

            String query = "SELECT * FROM students";

            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("\nStudent Records:");
            System.out.println("-----------------------------");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                int age = resultSet.getInt("age");

                System.out.println(
                        "ID: " + id +
                                ", Name: " + name +
                                ", Course: " + course +
                                ", Age: " + age
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}