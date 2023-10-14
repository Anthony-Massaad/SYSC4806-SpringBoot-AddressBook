package org.example;

public class Main {
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        BuddyInfo b1 = new BuddyInfo("Tony", 13672830);
        BuddyInfo b2 = new BuddyInfo("Rocco", 13672832);
        BuddyInfo b3 = new BuddyInfo("Myko", 13672833);
        BuddyInfo b4 = new BuddyInfo("Brook", 13672830);

        book.addBuddy(b1);
        book.addBuddy(b2);
        book.addBuddy(b3);
        book.addBuddy(b4);
        System.out.println();
        System.out.println(book.getListOfBuddies());
    }
}