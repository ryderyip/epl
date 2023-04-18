package ict.data_objects.entities;

public enum StaffRole {
    NORMAL("N"),
    SENIOR("S");

    private final String n;

    StaffRole(String shortName) {
        this.n = shortName;
    }

    public String getUrl() {return n;}
}
