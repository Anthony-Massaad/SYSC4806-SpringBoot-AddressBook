package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestBuddyInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateNewBuddyInfo() throws Exception {
        System.out.println("TESTING: testCreateNewBuddyInfo()");
        String buddyName = "John";
        int buddyNumber = 12345;
        Long addressBookId = 1L;
        System.out.println("Creating an address book");
        mockMvc.perform(post("/api/addressbooks/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk());

        System.out.println("Address book created");

        System.out.println("Creating a new buddy info into addressbook 1L");
        mockMvc.perform(post("/api/buddyinfos/create")
                .param("buddyName", buddyName)
                .param("buddyNumber", String.valueOf(buddyNumber))
                .param("addressBookId", String.valueOf(addressBookId))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk());

        System.out.println("Buddy info created");
    }

    @Test
    public void testDeleteBuddyInfo() throws Exception {
        System.out.println("TESTING: testDeleteBuddyInfo()");
        String buddyName = "John";
        int buddyNumber = 12345;
        Long addressBookId = 1L;
        System.out.println("Creating an address book");
        ResultActions resultAddressbook = mockMvc.perform(post("/api/addressbooks/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk());

        System.out.println("Address book created");

        System.out.println("Creating a new buddy info into addressbook 1L");
        ResultActions result = mockMvc.perform(post("/api/buddyinfos/create")
                .param("buddyName", buddyName)
                .param("buddyNumber", String.valueOf(buddyNumber))
                .param("addressBookId", String.valueOf(addressBookId))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk());

        System.out.println("Buddy info created");

        System.out.println("Delete buddy info");
        // Set up your request parameters
        int buddyId = 1;

        // Perform a DELETE request to the "/delete/{buddyId}" endpoint
        ResultActions resultDelete = mockMvc.perform(delete("/api/buddyinfos/delete/{buddyId}", buddyId)
                .param("addressBookId", String.valueOf(addressBookId))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk());

        System.out.println("Buddy info deleted");
    }

}
