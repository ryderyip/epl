package ict.test;

import ict.bean.CustomerBean;
import ict.db.Database;

public class TestEditRecord {
    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        Database db = new Database(url, username, password);
        CustomerBean newCusto = new CustomerBean("1", "Thomas", "12341234", 30);
        db.editRecord(newCusto);
    }
}
