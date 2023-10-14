package org.example;

import javax.persistence.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest {

    @org.junit.jupiter.api.Test
    void getPhoneNumber() {
        System.out.println("Testing getPhoneNumber()");
        BuddyInfo buddy = new BuddyInfo("Tony", 123456789);
        assertEquals(123456789, buddy.getPhoneNumber());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        System.out.println("Testing getName()");
        BuddyInfo buddy = new BuddyInfo("Tony", 123456789);
        assertEquals("Tony", buddy.getName());
    }
}