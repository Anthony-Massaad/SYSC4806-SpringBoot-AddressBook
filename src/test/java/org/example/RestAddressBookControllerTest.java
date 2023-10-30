package org.example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestAddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllAddressBooks() throws Exception {
        mockMvc.perform(get("/api/addressbooks/getAll"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void testGetAddressBook() throws Exception {
        Long addressBookId = 1L;
        mockMvc.perform(post("/api/addressbooks/create"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE));

        mockMvc.perform(get("/api/addressbooks/{addressBookId}", addressBookId))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void testCreateAddressBook() throws Exception {
        mockMvc.perform(post("/api/addressbooks/create"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE));
    }
}
