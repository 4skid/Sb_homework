import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost: 3306/skillbox";
        String user = "root";
        String pass = "Skillbox2022";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    """
                            SELECT\s
                                course_name,
                                ROUND(COUNT(course_name) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1),
                                        2) avgPurchaseRatio
                            FROM
                                purchaselist
                            WHERE
                                YEAR(subscription_date) = 2018
                            GROUP BY course_name;""");

            System.out.println("Среднее количество покупок в месяц для каждого курса за 2018 год:".concat("\n"));

            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String avgPurchaseRatio = resultSet.getString("avgPurchaseRatio");
                System.out.println(courseName.concat(" - ") + avgPurchaseRatio);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
