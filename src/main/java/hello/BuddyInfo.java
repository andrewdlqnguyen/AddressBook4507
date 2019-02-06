package hello;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String phoneNumber;

    @ManyToOne
    private AddressBook addressBook;

    public BuddyInfo(){}

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String printBuddyInfo() {
        return "ID: " + id + "    | Name: " +
                name + "      | Phone Number: " + phoneNumber +
                "\n";
    }

    @Override
    public String toString() {
        return "BuddyInfo{" +
                " name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}' + "\n";
    }

}