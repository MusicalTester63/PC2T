

public enum EmployeeType {

    ACTIVE("active","Active employee"),
    INACTIVE("inactive", "Employee vacation,"),
    DELETED("deleted", "Fired"),
    NAPITY("drunk","nic ine neumi");




    private String internalName;
    private String description;

    private EmployeeType(String internalName, String description) {
        this.internalName = internalName;
        this.description = description;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
