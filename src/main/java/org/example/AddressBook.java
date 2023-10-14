package org.example;

import jakarta.persistence.*;

import java.util.*;

/**
 * AddressBook Class
 * @author Anthony Massaad (id: 101150282)
 */
@Entity
public class AddressBook {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = BuddyInfo.class)
    private List<BuddyInfo> book;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    /**
     * Default constructor for AddressBook
     */
    public AddressBook() {
        this.book = new ArrayList<BuddyInfo>();
    }

    /**
     * one-to-many relationship with many BuddyInfo
     * @return the book
     */
    public List<BuddyInfo> getBook() {
        return this.book;
    }

    public void setBook(List<BuddyInfo> b) {
        this.book = b;
    }

    /**
     * Sets the id of this Team to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "AddressBook[id=%d, book.size()='%d'] \n %s",
                this.id, this.book.size(), this.getListOfBuddies());
    }

    /**
     * Gets the id of this Team.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * retrieve the length of the address book
     * @return Integer, the length of address book
     */
    public int getNumOfBuddies() {
        return this.book.size();
    }

    /**
     * add a new buddy to the address book.
     * @param newBuddy BuddyInfo, a buddy to add to the address book
     * @return boolean, false if buddy is null or buddy's phone number is already in the address book. Otherwise true
     */
    public boolean addBuddy(BuddyInfo newBuddy) {
        if (newBuddy == null) return false;
        for (BuddyInfo buddy : this.book) {
            if (buddy.getPhoneNumber() == newBuddy.getPhoneNumber()) {
                System.out.println("Number " + newBuddy.getPhoneNumber() + " already exists!");
                return false;
            }
        }
        System.out.println("New Buddy " + newBuddy.getName() + " added!");
        this.book.add(newBuddy);
        return true;
    }

    public boolean deleteBuddy(BuddyInfo buddy) {
        if (buddy == null) return false;
        for (int i = 0; i < this.book.size(); i++) {
            BuddyInfo b = this.book.get(i);
            if (b.getId().equals(buddy.getId()) && b.getName().equals(buddy.getName()) && b.getPhoneNumber() == buddy.getPhoneNumber()) {
                this.book.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     * retrieve the contents in the address book
     * @return String, the contents in the address book
     */
    public String getListOfBuddies() {
        StringBuilder s =  new StringBuilder();
        s.append("Address book Buddies").append("\n").append("-----------------------").append("\n");
        for (BuddyInfo buddy : this.book) {
            s.append("name: ").append(buddy.getName()).append(" | ").append("number: ").append(buddy.getPhoneNumber()).append("\n");
        }
        return s.toString();
    }
}
