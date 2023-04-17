/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;

import ict.db.Database;

public class TestCreateCustTable {
    public static void main(String[] arg) {
        Database db = new Database(url, username, password);
        db.createCustTable();
    }
}

