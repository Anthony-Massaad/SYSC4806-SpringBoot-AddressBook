package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BuddyInfoController {

    @Autowired
    BuddyInfoRepository repo;

    @Autowired
    AddressBookRepository repoBook;

    @GetMapping("/newBuddy")
    public String newBuddyInfo(@RequestParam("addressBookId") Long addressBookId,  Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("addressBookId", addressBookId);
        return "newBuddyInfo";
    }

    @PostMapping("/newBuddy")
    public String newBuddyInfo(@ModelAttribute BuddyInfo bi, @RequestParam("addressBookId") Long addressBookId, Model model, RedirectAttributes redirectAttributes) {
        BuddyInfo buddyInfo = new BuddyInfo(bi.getName(), bi.getPhoneNumber());
        Optional<AddressBook> book = repoBook.findById((addressBookId));

        if (book.isPresent()) {
            System.out.println("Address book found");
            AddressBook addressBook = book.get();
            addressBook.addBuddy(buddyInfo);
            repo.save(buddyInfo);
            redirectAttributes.addAttribute("addressBookId", addressBookId);
        } else {
            System.out.println("BuddyInfoController(), Post newBuddy, Addressbook not found");
            System.exit(1);
        }

        return "redirect:/displayAddressBook";
    }

    @GetMapping("/deleteBuddy")
    public String deleteBuddy(@RequestParam("buddyId") Long buddyID, @RequestParam("addressBookId") Long addressBookId, Model model, RedirectAttributes redirectAttributes) {
        Optional<AddressBook> book = repoBook.findById((addressBookId));
        Optional<BuddyInfo> buddy = repo.findById(buddyID);
        if (book.isPresent() && buddy.isPresent()) {
            System.out.println("Address book found");
            System.out.println("buddy found found");
            AddressBook addressBook = book.get();
            BuddyInfo b = buddy.get();
            addressBook.deleteBuddy(b);
            repo.delete(b);
            redirectAttributes.addAttribute("addressBookId", addressBookId);
        } else {
            System.out.println("BuddyInfoController(), buddy or book not found");
            System.exit(1);
        }

        return "redirect:/displayAddressBook"; // Redirect to the appropriate page after deletion
    }

}
