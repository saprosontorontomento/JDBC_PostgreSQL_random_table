import org.apache.commons.lang3.RandomStringUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {

    public static void main(String[] args) {

        String first_name = RandomStringUtils.randomAlphabetic(4).toLowerCase();
        String last_name = RandomStringUtils.randomAlphabetic(7).toLowerCase();
        String login = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphanumeric(10);

        String email = RandomStringUtils.randomAlphabetic(3, 9).toLowerCase()
                + '@'
                + RandomStringUtils.randomAlphabetic(2, 3).toLowerCase()
                + '.'
                + RandomStringUtils.randomAlphabetic(2, 3).toLowerCase();
        String pass_num = "4" + RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomNumeric(6);
        String phone = "89" + RandomStringUtils.randomNumeric(9);

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String creation_date = date.format(format);




        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(login);
        System.out.println(password);
        System.out.println(email);
        System.out.println(pass_num);
        System.out.println(phone);
        System.out.println(creation_date);

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Postgresql JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.31.59:5432/postgres",
                    "postgres",
                    "postgres"
            );


            String sqlTableOne = "INSERT INTO info_user (first_name,last_name,email) VALUES (?, ?, ?)";
            PreparedStatement stmtTableOne = conn.prepareStatement(sqlTableOne);
            stmtTableOne.setString(1, first_name);
            stmtTableOne.setString(2, last_name);
            stmtTableOne.setString(3, email);

            int rowsTableOne = stmtTableOne.executeUpdate();


            String sqlTableTwo = "INSERT INTO info_pass (first_name,last_name,pass_num,phone) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtTableTwo = conn.prepareStatement(sqlTableTwo);
            stmtTableTwo.setString(1, first_name);
            stmtTableTwo.setString(2, last_name);
            stmtTableTwo.setString(3, pass_num);
            stmtTableTwo.setString(4, phone);

            int rowsTableTwo = stmtTableTwo.executeUpdate();


            String sqlTableThree = "INSERT INTO info_acc (login,password,email,creation_date) VALUES (?, ?, ?, ?::date)";
            PreparedStatement stmtTableThree = conn.prepareStatement(sqlTableThree);
            stmtTableThree.setString(1, login);
            stmtTableThree.setString(2, password);
            stmtTableThree.setString(3, email);
            stmtTableThree.setString(4, creation_date);

            int rowsTableThree = stmtTableThree.executeUpdate();



            System.out.printf("Added %d rows", rowsTableOne);
            System.out.printf("Added %d rows", rowsTableTwo);
            System.out.printf("Added %d rows", rowsTableThree);



        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

    }

}