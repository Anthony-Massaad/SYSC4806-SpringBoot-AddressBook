package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findById(long id);

    List<AddressBook> findAll();
}
