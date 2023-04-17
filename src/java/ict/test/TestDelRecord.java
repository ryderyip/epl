package ict.test;

import ict.db.Database;

public class TestDelRecord {
    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        Database db = new Database(url, username, password);
        db.delRecord("2");
    }
}

