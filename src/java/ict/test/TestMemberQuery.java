package ict.test;

import ict.data_objects.entities.Member;
import ict.db.MemberDatabase;

public class TestMemberQuery {
    public static void main(String[] args) {
        MemberDatabase db = new MemberDatabase();
        for (Member m: db.queryMembers()) {
            System.out.println(m.getInfo().getName());
        }
    }
}
