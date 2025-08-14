package com.alt.repository;

import java.util.List;

import com.alt.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {


    //JQL
//    @Query("select e from EmployeeEntity e")
//    List<EmployeeEntity> getAllEmployees();
//
//
//    @Query("select e from EmployeeEntity e where e.salary = :salary")
//    EmployeeEntity getAllEmployee(@Param("salary")int salary);
//
//    @Query("select e from EmployeeEntity e where e.stream = :stream and e.salary = :salary")
//    EmployeeEntity getEmployeeUsing(@Param("stream")String stream,@Param("salary")int salary);

    //NativeQuery
    @Query(value="select * from employee", nativeQuery = true)
    List<EmployeeEntity> getAllEmployees();


}
