package ict.test;

import ict.bean.CustomerBean;
import ict.db.Database;

import java.util.ArrayList;

public class TestQueryCustByName {
    public static void main(String[] arg) {
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        Database db = new Database(url, username, password);
        ArrayList<CustomerBean> customers = db.queryCustByName("Peter");
        customers.forEach(System.out::println);
    }
}
