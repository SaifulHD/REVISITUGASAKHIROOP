package Connection;

import java.sql.Connection;

public class MainConnection {

    public static void main(String[] args) {
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        System.out.println(conn+" Koneksi Tersedia");
    }
}
