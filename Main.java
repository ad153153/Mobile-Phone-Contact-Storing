import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone("012229322793");

    public static void main(String[] args) {

        boolean quit = false;

        startPhone();
        printActions();
        int choice = 0;
        while (!quit) {
            System.out.println("Enter Your Choice!");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    mobilePhone.getContacts();
                    break;
                case 2:
                    addContacts();
                    break;
                case 3:
                    deleteContacts();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                     queryContact();
                    break;
                case 6:
                    quit = true;

            }

        }


    }

    private static void startPhone() {
        System.out.println("Starting Phone ..........");
    }

    private static void printActions() {
        System.out.println("0 - Shutdown");
        System.out.println("1 - Print Contact list");
        System.out.println("2 - add new contact to the list ");
        System.out.println("3 - remove contact from the list");
        System.out.println("4 -modify contact in the list");
        System.out.println("5 -search for an existing contact");
        System.out.println("6 - quit");
    }

    private static void addContacts() {
        System.out.println("enter name");
        String name = scanner.nextLine();
        System.out.println("Enter number");
        String number = scanner.nextLine();
        Contact contact = Contact.createContact(name, number);
        if (mobilePhone.addNewNumber(contact)) {
            System.out.println("the contacted have been added sucessfully Name ==>" + name + " number ==>" + number);
        } else {
            System.out.println("The contact name " + name + " you entered already exists");
        }
    }

    private static void deleteContacts() {
        System.out.println("Enter existing Contact ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("The contact is not in the list");
        }
        mobilePhone.deleteContact(existingContact);
    }

    private static void updateContact() {
        System.out.println("Enter existing Contact ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("The contact is not in the list");
        }
        System.out.println("Enter new name ");
        String newName = scanner.nextLine();
        System.out.println("Enter new number");
        String newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName, newNumber);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Successfully updated");
        }
        else {
            System.out.println("Error updating contact ");
        }
    }
    private static void queryContact() {
        System.out.println("Enter existing Contact ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("The contact is not in the list");
        }
        else {
            System.out.println("The name is :-" + existingContact.getName() + "The number is =" + existingContact.getPhoneNumber());
        }
        }
}
