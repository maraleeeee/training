package com.example.training;

import com.example.training.Data.Student;
import com.example.training.Data.StudentDTO_A;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiTest extends AbstractMockMvn {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }


    public void getStudentsListUnit(){

    }
    @Test
    public void getStudentsList() throws Exception {
        String uri = "/student/search";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        StudentDTO_A[] studentList = super.mapFromJson(content, StudentDTO_A[].class);
        assertTrue(studentList.length > 0);
        System.out.println(Arrays.toString(studentList));
    }

    @Test
    public void getStudentByName() throws Exception {
        String uri = "/student/search?name=maral";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        StudentDTO_A[] studentList = super.mapFromJson(content, StudentDTO_A[].class);
        assertTrue(studentList.length > 0);
        System.out.println(Arrays.toString(studentList));
    }    @Test
    public void getStudentByFamily() throws Exception {
        String uri = "/student/search?family=sh";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        StudentDTO_A[] studentList = super.mapFromJson(content, StudentDTO_A[].class);
        assertTrue(studentList.length > 0);
        System.out.println(Arrays.toString(studentList));
    }


}
