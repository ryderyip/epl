package ict.test;

import ict.db.Database;

public class TestAddRecord {
    public static void main(String[] arg) {
        Database db = new Database();
        db.addRecord("1", "Peter", "12345688", 18);
        db.addRecord("2", "Nancy", "12345678", 21);
        db.addRecord("3", "Glycogen", "12345671", 16);
        db.addRecord("4", "Monosaccharide", "12345672", 15);
    }
}
