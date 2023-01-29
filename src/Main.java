import javax.swing.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/myshopdb";
        String user = "root";
        String pass = "12345";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, pass);

            GUIPaginaPrincipala gui = new GUIPaginaPrincipala(connection);
            gui.setVisible(true);
            gui.setLocationRelativeTo(null);
            gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}