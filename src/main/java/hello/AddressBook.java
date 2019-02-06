package hello;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfoList;

    public AddressBook() {
        this.buddyInfoList = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo b){
        buddyInfoList.add(b);
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public List<BuddyInfo> getAddressBook() {
        return buddyInfoList;
    }

    public void setAddressBook(List<BuddyInfo> buddyInfoList) {
        this.buddyInfoList = buddyInfoList;
    }

    public void printAddressBook(){
        for(int i = 0; i < buddyInfoList.size(); i++){
            System.out.print(i+1 + ": Name: " + buddyInfoList.get(i).getName() +
                    ", Phone Number: " + buddyInfoList.get(i).getPhoneNumber() + "\n");
        }
    }

        public static void main(String[] args) {
        BuddyInfo b0 = new BuddyInfo("Homer", "416-669-9068");
        BuddyInfo b1 = new BuddyInfo("Marge", "416-666-7776");
        BuddyInfo b2 = new BuddyInfo("Bart", "647-625-7879");
        BuddyInfo b3 = new BuddyInfo("Lisa", "416-234-1231");
        BuddyInfo b4 = new BuddyInfo("Maggie", "613-777-9080");
        AddressBook a = new AddressBook();
        a.addBuddy(b0);
        a.addBuddy(b1);
        a.addBuddy(b2);
        a.addBuddy(b3);
        a.addBuddy(b4);

        System.out.println(a.getAddressBook());
    }
}