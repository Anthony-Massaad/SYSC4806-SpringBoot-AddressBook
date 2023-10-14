package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/buddyinfos")
public class RestBuddyInfoController {
    @Autowired
    private BuddyInfoRepository repo;

    @Autowired
    private AddressBookRepository repoBook;

    @PostMapping("/create")
    public BuddyInfo createBuddyInfo(@RequestParam("buddyName") String buddyName, @RequestParam("buddyNumber") int buddyNumber , @RequestParam("addressBookId") Long addressBookId) {
        BuddyInfo buddyInfo = new BuddyInfo(buddyName, buddyNumber);
        Optional<AddressBook> book = repoBook.findById(addressBookId);

        if (book.isPresent()) {
            System.out.println("Address book found");
            AddressBook addressBook = book.get();
            addressBook.addBuddy(buddyInfo);
            repo.save(buddyInfo);
            return buddyInfo;
        } else {
            throw new Error("Address book not found with id: " + addressBookId);
        }
    }

    @DeleteMapping("/delete/{buddyId}")
    public void deleteBuddyInfo(@PathVariable Long buddyId, @RequestParam("addressBookId") Long addressBookId) {
        Optional<AddressBook> book = repoBook.findById(addressBookId);
        Optional<BuddyInfo> buddy = repo.findById(buddyId);

        if (book.isPresent() && buddy.isPresent()) {
            System.out.println("Address book found");
            System.out.println("Buddy found");
            AddressBook addressBook = book.get();
            BuddyInfo b = buddy.get();
            addressBook.deleteBuddy(b);
            repo.delete(b);
        } else {
            throw new Error("Buddy info not found with id: " + buddyId);
        }
    }
}
