import java.util.ArrayList;

/**
 * Created by ifarfan
 */
public class Contact {

    private String name;
    private String phoneNumber;
    private String work;
    private String home;
    private String city;

    public Contact(String name, String phoneNumber, String work, String home, String city) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.work = work;
        this.home = home;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWork() {
        return work;
    }

    public String getHome() {
        return home;
    }

    public String getCity() {
        return city;
    }

    public static Contact createContact(String name, String phoneNumber, String work, String home, String city) {
        return new Contact(name, phoneNumber, work, home, city);
    }

    ArrayList<String> contactList = new ArrayList<String>();

    public ArrayList<String> getContactList() {
        return contactList;
    }
}
