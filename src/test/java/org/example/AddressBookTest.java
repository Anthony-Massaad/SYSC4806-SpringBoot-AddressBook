package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    AddressBook book;
    BuddyInfo b1;
    BuddyInfo b2;
    BuddyInfo b3;

    @BeforeEach
    void setUp() {
        book = new AddressBook();
        b1 = new BuddyInfo("Tony", 123456789);
        b2 = new BuddyInfo("Tony2.0", 123456788);
        b3 = new BuddyInfo("Tony3.0", 123456789);
    }

    @Test
    void getNumOfBuddies() {
        book.addBuddy(b1);
        book.addBuddy(b2);
        book.addBuddy(b3);
        assertEquals(2, book.getNumOfBuddies());
    }

    @Test
    void addBuddy() {
        assertTrue(book.addBuddy(b1));
        assertTrue(book.addBuddy(b2));
        assertFalse(book.addBuddy(b3));
    }

    @Test
    void addNullBuddy() {
        assertFalse(book.addBuddy(null));
    }

    @Test
    void getListOfBuddies() {
        String s = book.getListOfBuddies();
        assertNotEquals("", s);
    }
}