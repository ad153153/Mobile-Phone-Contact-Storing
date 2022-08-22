import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addNewNumber(Contact contact) {
        if (findContact(contact.getName()) < 0) {
            myContact.add(contact);
            return true;

        }
        else {
            System.out.println("The Contact is Already Stored in the phone");
            return false;
        }
    }

    private int findContact(Contact contact) {
        return this.myContact.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContact.size(); i++) {
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    private void printContact(Contact contact) {
        System.out.println("Your Contact List is Defined of :-");
        for (int i = 0; i < this.myContact.size(); i++) {
            System.out.println((i + 1) + " -" + contact.getName() + " Number : " + contact.getPhoneNumber());
        }
    }

    public boolean updateContact(Contact oldContact, Contact contact) {
        int foundPostion = findContact(oldContact);
        if (foundPostion < 0) {
            System.out.println("The contact " + oldContact.getName() + " Not Found");
        }
        this.myContact.set(foundPostion, contact);
        System.out.println(oldContact.getName() + "is changed to " + contact.getName());
        return true;
    }

    public Contact queryContact(String name) {
        int foundPostion = findContact(name);
        if (foundPostion >= 0) {
            return this.myContact.get(foundPostion);
        }
        return null;
    }
    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public boolean deleteContact(Contact contact) {
        int foundPostion = findContact(contact);
        if (foundPostion < 0) {
            System.out.println("The contact " + contact.getName() + " Not Found");
            return false;
        }
        this.myContact.remove(foundPostion);
        System.out.println("The contact with the name " + contact.getName() + " Was Removed");
        return true;
    }

    public void getContacts() {
        for (int i = 0; i < this.myContact.size(); i++) {
            System.out.println("Your Contacts");
            System.out.println((i + 1) + "- " + this.myContact.get(i).getName() +
                    "==> Number is :- " + this.myContact.get(i).getPhoneNumber());
        }
    }
}