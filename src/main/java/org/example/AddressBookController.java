package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AddressBookController {

    @Autowired
    AddressBookRepository repo;

    @GetMapping("/")
    public String getAllAddressBooks(Model model) {
        List<AddressBook> books = repo.findAll();
        System.out.println("Books found: " + books.size());
        model.addAttribute("books", books);
        return "allAddressBooks";
    }

    @GetMapping("/displayAddressBook")
    public String newAddressBook(@RequestParam(value = "addressBookId", required = false) Long addressBookId, Model model) {
        if (addressBookId != null) {
            Optional<AddressBook> book = repo.findById(addressBookId);
            if (book.isPresent()) {
                AddressBook addressBook = book.get();
                System.out.println("Book Found");
                model.addAttribute("addressBook", addressBook);
            } else {
                System.out.println("newAddressBook(), Address book id not null, but no book found. Exiting");
                System.exit(1);
            }
        } else {
            AddressBook book = new AddressBook();
            System.out.println("AddressBook Created");
            repo.save(book);
            System.out.println("AddressBook Saved");
            model.addAttribute("addressBook", book);
        }

        return "displayAddressBook";
    }

}
