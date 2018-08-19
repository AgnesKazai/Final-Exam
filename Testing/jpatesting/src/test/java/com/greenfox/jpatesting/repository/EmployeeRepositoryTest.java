package com.greenfox.jpatesting.repository;

import com.greenfox.jpatesting.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

// EmployeeRepository component that I am going to test
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    //to insert an Employee in the DB and reading it via the find by name API.
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee johnDoe = new Employee("John Doe");
        /*will force the data to be persist in the database immediately as EntityManager.persist() will not */
        entityManager.persist(johnDoe);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName(johnDoe.getName());

        // then
        assertEquals("Check name", found.getName(), johnDoe.getName());
    }
}
