package com.ahextech.web.rest;

import com.ahextech.JhipsterappApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the RegistrationResource REST controller.
 *
 * @see RegistrationResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterappApp.class)
public class RegistrationResourceIntTest {

    private MockMvc restMockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        RegistrationResource registrationResource = new RegistrationResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(registrationResource)
            .build();
    }

    /**
    * Test post
    */
    @Test
    public void testPost() throws Exception {
        restMockMvc.perform(post("/api/registration/post"))
            .andExpect(status().isOk());
    }

}
