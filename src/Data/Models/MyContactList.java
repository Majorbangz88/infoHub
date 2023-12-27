package Data.Models;

public class MyContactList {

    private String name;
    private String address;
    private String telephone;
    private String email;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String design = "=".repeat(35);
        return design +
                "\nName: " + getName() +
                "\nAddress: " + getAddress() +
                "\nTelephone: " + getTelephone() +
                "\nEmail: " + getEmail() +
                "\nId: " + getId() + "\n" + design;
    }
}
