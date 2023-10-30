package org.example;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addressbooks")
public class RestAddressBookController {

    @Autowired
    private AddressBookRepository repo;

    @GetMapping("/getAll")
    public List<AddressBook> getAllAddressBooks() {
        List<AddressBook> books = repo.findAll();
        System.out.println("Books found: " + books.size());
        return books;
    }

    @GetMapping("/{addressBookId}")
    public AddressBook getAddressBook(@PathVariable Long addressBookId) {
        Optional<AddressBook> book = repo.findById(addressBookId);
        if (book.isPresent()) {
            AddressBook addressBook = book.get();
            System.out.println("Book Found");
            return addressBook;
        } else {
            throw new Error("Address book not found with id: " + addressBookId);
        }
    }
    @PostMapping(value = "/create")
    public AddressBook createAddressBook() {
        AddressBook book = new AddressBook();
        System.out.println("AddressBook Created");
        repo.save(book);
        System.out.println("AddressBook Saved");
        return book;
    }


    @PostMapping(value = "/", produces = "application/json")
    public AddressBook createAddressBook(HttpServletResponse response) {
        AddressBook book = new AddressBook();
        System.out.println("AddressBook Created");
        repo.save(book);
        response.setContentType("text/plain");
        System.out.println("AddressBook Saved");
        return book;
    }
}
