package ict.db;

import ict.data_objects.entities.Venue;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VenueDatabase {
    final Database<Venue> db;

    public VenueDatabase() {
        db = new Database<>(rs -> new Venue(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("location"),
                rs.getBoolean("available"),
                rs.getString("image"),
                rs.getString("description"),
                rs.getString("type"),
                rs.getInt("capacity"),
                new BookingFeeDatabase().queryById(rs.getInt("booking_fee_id"))
        ));
    }

    public Set<Venue> queryByInChargeStaffId(int staffId) {
        List<Venue> list;
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "SELECT * FROM venue " +
                            "join staff_venues_in_charge svic on venue.id = svic.venue_id " +
                            "where svic.id = ?;");
            statement.setInt(1, staffId);
            list = db.query(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new HashSet<>(list);
    }

    public Venue queryById(int id) {
        return db.queryById(id, "venue");
    }
}
