package ict.db;

import ict.data_objects.entities.Staff;
import ict.data_objects.entities.StaffRole;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StaffDatabase {
    final Database<Staff> db;

    public StaffDatabase() {
        this.db = new Database<>(resultSet -> new Staff(
                resultSet.getInt("id"),
                new UserCommonInfoDb().queryById(resultSet.getInt("info_id")),
                new VenueDatabase().queryByInChargeStaffId(resultSet.getInt("venue_in_charge_id")),
                StaffRole.valueOf(resultSet.getString("role"))
        ));
    }

    public List<Staff> query() {
        List<Staff> list;
        try {
            PreparedStatement s = db.getConnection().prepareStatement("SELECT * FROM staff;");
            list = db.query(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
