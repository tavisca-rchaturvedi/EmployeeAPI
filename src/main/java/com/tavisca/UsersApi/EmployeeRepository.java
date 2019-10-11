package com.tavisca.UsersApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from employees where firstName=?1", nativeQuery = true)
    public List<Employee> findByFirstName(String value);

    @Query(value = "select * from employees where lastName=?1", nativeQuery = true)
    public List<Employee> findByLastName(String value);

    @Query(value = "select * from employees where role=?1", nativeQuery = true)
    public List<Employee> findByRole(String value);

    @Query(value = "select * from employees where createdBy=?1", nativeQuery = true)
    public List<Employee> findByCreatedy(String value);

}
