package auto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    public JDBC() {

    }

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String connectionUrl = "jdbc:jtds:sqlserver://pro-inf-1.vsqt.local:1456;useNTLMv2=true;user = yuriy.stetsiv;domain = vsqt;password =";

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to the database!!! Getting table list...");

            try {
                stmt = conn.createStatement();
            } catch (SQLException var10) {
                Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE,(String)null, var10);
            }

            rs = stmt.executeQuery("Select count(*) from nohbian_datamart_02.dbo.vatbsum");

            while(rs.next()) {
                System.out.println(rs.getString(""));
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            conn.close();
            rs.close();
        }

    }
}

