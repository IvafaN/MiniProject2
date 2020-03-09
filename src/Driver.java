import java.util.Scanner;

/**
 * Created by ifarfan
 */
public class Driver {

    private static Scanner scanner = new Scanner(System.in);
    private static ContactList list = new ContactList("000 443 876");

    public static void main(String[] args) {

        boolean quite = false;
        printAction();

        while (!quite) {
            System.out.print("Enter your option: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    list.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    removeContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    System.out.println("\n Have a good one. Bye!!!");
                    quite = true;
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter mobile: ");
        String phone = scanner.nextLine();
        System.out.print("Enter work: ");
        String work = scanner.nextLine();
        System.out.print("Enter home: ");
        String home = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        Contact newContact = Contact.createContact(name, phone, work, home, city);
        if(list.addNewContact(newContact)) {
            System.out.println("Successfully added a new contact" );
        }else {
            System.out.println("Can't add, " + name +" already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter the index of the contact to update: ");
        int index = scanner.nextInt();
        Contact extContact = list.queryContact(index);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        System.out.print("Enter new Name: ");
        String newName = scanner.next();
        System.out.print("Enter new Mobile: ");
        String newNumber = scanner.next();
        System.out.print("Enter new Work: ");
        String newWork = scanner.next();
        System.out.print("Enter new Home: ");
        String newHome = scanner.next();
        System.out.print("Enter new City: ");
        String newCity = scanner.next();

        Contact newContact = Contact.createContact(newName, newNumber, newWork, newHome, newCity);
        if(list.updateContact(extContact, newContact))
        {
            System.out.println("Successfully updated");
        }else {
            System.out.println("Error Updating Contact");
        }
    }

    private static void removeContact() {
        System.out.println("Enter the index of the contact to remove: ");
        int index = scanner.nextInt();
        Contact extContact = list.queryContact(index);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        if(list.removeContact(extContact)) {
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error Deleting Contact");
        }
    }

    private static void printAction() {
        System.out.println("+=== CONTACT APP ===+");
        System.out.println("1. List all contacts");
        System.out.println("2. Add new Contact");
        System.out.println("3. Remove Contact");
        System.out.println("4. Update Contact");
        System.out.println("5. Quit");
        System.out.println("+====================+");
    }
}
