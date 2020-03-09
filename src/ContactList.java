import java.util.ArrayList;

/**
 * Created by ifarfan
 */
public class ContactList {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public ContactList(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    // Adding a new contact
    public boolean addNewContact(Contact contact) {

        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
        }

        //If Not exist then add contact
        myContacts.add(contact);
        return true;
    }

    //Update Contact
    public boolean updateContact(Contact oldContact , Contact newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getName() + " , was not found");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    // Remove Contact
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if(foundPosition < 0) {
            System.out.println(contact.getName() + " , was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

    // Find Contact Position
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    // Find Contact Names
    private int findContact(String contactName) {
        for(int i =0; i < myContacts.size(); i++) {
            // Creating another temporary object to hold the name and compare
            Contact contacts = this.myContacts.get(i);
            if(contacts.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    // query contact
    public String queryContact(Contact contact) {
        if(findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(int index) {
       // int position = findContact(name);
        if(index >=0) {
            return this.myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact list");
        for(int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i)   + ". <" + this.myContacts.get(i).getName() + ">"
                                     + " ( " + "mobile=" + this.myContacts.get(i).getPhoneNumber()+ ", "
                                     +        "work="   + this.myContacts.get(i).getWork()        + ", "
                                     +        "home="   + this.myContacts.get(i).getHome()        + ", "
                                     +        "city="   + this.myContacts.get(i).getCity()        +
                    " )");
        }
    }
}
