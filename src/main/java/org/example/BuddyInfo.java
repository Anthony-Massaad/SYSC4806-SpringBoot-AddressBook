package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * BuddyInfo Class
 * @author Anthony Massaad (id: 101150282)
 */
@Entity
public class BuddyInfo {
    private int phoneNumber;
    private String name;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    /**
     * default constructor
     */
    public BuddyInfo() {
        this("", -1);
    }

    /**
     * Constructor for Buddy Info
     * @param name String, buddy's name
     * @param phoneNumber Integer, buddy's phone number
     */
    public BuddyInfo(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "BuddyInfo[id=%d, name='%s', number=%d]",
                this.id, this.name, this.phoneNumber);
    }

    /**
     * getter for buddy's phone number
     * @return Integer, the phone number
     */
    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * getter for buddy's name
     * @return String, buddy's name
     */
    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
