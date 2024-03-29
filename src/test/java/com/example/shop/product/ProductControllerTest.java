package com.example.shop.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void get_product_list_valid_test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/shop/product")
                .param("nameFilter", "Xi4qW2V2YV0uKiQ=")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();

        assertEquals(getTestStr(), mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void get_product_list_not_valid_data_test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/shop/product")
                .param("nameFilter", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals("Incorrect entered parameter length! You not entered any characters or only spaces!",
                mvcResult.getResponse().getErrorMessage());
    }

    @Test
    public void get_product_list_not_valid_data_spaces_test() throws Exception {
        mockMvc.perform(get("/shop/product")
                .param("nameFilter", "  ")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Incorrect entered parameter!"));
    }

    @Test
    public void get_product_list_not_valid_filter_test() throws Exception {
        mockMvc.perform(get("/shop/product")
                .param("nameFilter", "abcdefghijklmnopqrstuvwxyz")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Incorrect entered parameter!"));
    }

    //^.*[abcdefghijklmnopqrstuvwxyz].*$
    @Test
    public void get_product_list_not_valid_data_full_alphabet_test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/shop/product")
                .param("nameFilter", "Xi4qW2FiY2RlZmdoaWprbG1ub3BxcnN0dXZ3eHl6XS4qJA==")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals("Products with your filter not found!", mvcResult.getResponse().getErrorMessage());
    }

    private String getTestStr(){
        String expected = "[{\"id\":5,\"name\":\"Tom 5\",\"description\":\"description 5\"},{\"id\":6,\"name\":\"Tom 6\"," +
                "\"description\":\"description 6\"},{\"id\":7,\"name\":\"nic 7\",\"description\":\"description 7\"}," +
                "{\"id\":8,\"name\":\"nic 8\",\"description\":\"description 8\"}]";
        return expected;
    }
}
