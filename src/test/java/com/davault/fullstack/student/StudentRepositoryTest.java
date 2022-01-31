package com.davault.fullstack.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();

    }

    @Test
    void shouldCheckIfStudentEmailExists() {

        //given (these setup value)
        String email = "janelle@gmail.com";
        Student student = new Student(
                "Janelle",
                email,
                Gender.FEMALE
        );

        underTest.save(student);

        //when (I call the system under test)
        boolean actual =  underTest.selectExistsEmail(email);

        //then (I expect this ...)
        assertThat(actual).isTrue();

    }

    @Test
    void shouldCheckIfStudentEmailDoesNotExist() {

        //given (these setup value)
        String email = "janelle@gmail.com";

        //when (I call the system under test)
        boolean actual =  underTest.selectExistsEmail(email);

        //then (I expect this ...)
        assertThat(actual).isFalse();

    }

}