package com.example.swd.s05;

import org.springframework.data.repository.CrudRepository;

import com.example.swd.dao.Employee;

public interface EmployeeExtraRepo extends CrudRepository<Employee, Integer> {
    Iterable<Employee> findByFirstName(String name);

    Iterable<Employee> findByFirstNameStartingWith(String prefix);

    Iterable<Employee> findByFirstNameStartingWithOrLastNameContainingIgnoreCase(String prefixFirst, String inLast);
}
