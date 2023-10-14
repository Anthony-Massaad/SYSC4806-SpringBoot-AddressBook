package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

// has @Configuration: Tags the class as a source of bean definitions for the application context.
// @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
// @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.
@SpringBootApplication
public class AccessingDataJPAApplication {


    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJPAApplication.class);
    }

//    // automatically runs code whe application launches
//    @Bean
//    public CommandLineRunner demo(BuddyInfoRepository repository, AddressBookRepository repository2) {
//        return (args) -> {
//            // save a few buddies
//            repository.save(new BuddyInfo("Jack", 123456789));
//            repository.save(new BuddyInfo("chloe", 1234589));
//            repository.save(new BuddyInfo("tony", 123456));
//            repository.save(new BuddyInfo("tony", 12346));
//            AddressBook book = new AddressBook();
//            book.addBuddy(new BuddyInfo("chloe", 1234589));
//            book.addBuddy(new BuddyInfo("tony", 123456));
//            repository2.save(book);
//            System.out.println();
//            // fetch addressbook by id
//            AddressBook bookGrabbed = repository2.findById(1L);
//            System.out.println("AddressBook found with findById(1L):");
//            System.out.println("--------------------------------");
//            System.out.println(bookGrabbed.toString());
//            System.out.println();
//
//            // fetch all buddies
//            System.out.println("BuddyInfo found with findAll():");
//            System.out.println("-------------------------------");
//            Iterable<BuddyInfo> buddies = repository.findAll();
//            int count = 0;
//            for (BuddyInfo b : buddies) {
//                System.out.println(b.toString());
//                count++;
//            }
//            System.out.println("Expected total buddies 6. Actual: " + count);
//            System.out.println();
//
//            // fetch an individual customer by ID
//            BuddyInfo buddy = repository.findById(1L);
//            System.out.println("buddy found with findById(1L):");
//            System.out.println("--------------------------------");
//            System.out.println(buddy.toString());
//            System.out.println();
//
//            // fetch buddies by name
//            System.out.println("BuddyInfo found with findByLastName('tony'):");
//            System.out.println("--------------------------------------------");
//            List<BuddyInfo> buddiesByName = repository.findByName("tony");
//            for (BuddyInfo b : buddiesByName) {
//                System.out.println(b.toString());
//            }
//            System.out.println("Expected total buddies 3. Actual: " + buddiesByName.size());
//            System.out.println();
//        };
//    }
}
