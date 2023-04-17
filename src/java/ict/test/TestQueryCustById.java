package ict.test;

import ict.bean.CustomerBean;
import ict.db.Database;

public class TestQueryCustById {
    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        Database db = new Database(url, username, password);
        CustomerBean customer = db.queryCustByID("1");
        System.out.println(customer);
    }
}
