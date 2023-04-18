package ict.data_objects.entities;

import javax.management.relation.Role;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.Set;


public class Staff extends User {
    private StaffRole role;
    private Set<Venue> venuesInCharge;
    
    public Staff(int id, UserCommonInfo info, Set<Venue> venuesInCharge, StaffRole role) {
        super(id, info);
        this.venuesInCharge = venuesInCharge;
        this.role = role;
    }

    public Set<Venue> getVenuesInCharge() {
        return venuesInCharge;
    }

    public void setVenuesInCharge(Set<Venue> venuesInCharge) {
        this.venuesInCharge = venuesInCharge;
    }

    public StaffRole getRole() {
        return role;
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String type) throws SQLException {
        super.readSQL(sqlInput, type);
        setRole(StaffRole.valueOf(sqlInput.readString()));
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        super.writeSQL(sqlOutput);
    }
}

