package com.alt;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.alt.entity.EmployeeEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alt.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class Application {

    private final EmployeeRepository emplRepository;

    Application(EmployeeRepository emplRepository) {
        this.emplRepository = emplRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadDbRecords(EmployeeRepository repo) {
        return args->{

            for(int i=0;i<125;i++) {
                EmployeeEntity emplEntitry = new EmployeeEntity();
                emplEntitry.setId(0);
                emplEntitry.setName("Alexa"+i);
                emplEntitry.setAddress("Mexico");
                emplEntitry.setStream("IT"+i);
                emplEntitry.setContactNo(1231331223L+i);
                emplEntitry.setSalary(5001+i);
                emplEntitry.setRecordCreated(new Date());
                repo.save(emplEntitry);
            }

//            List<EmployeeEntity> emplEntities = repo.getAllEmployees();
//            emplEntities.forEach(System.out::println);

            int page = 1;
            int size = 10;
            for(int i=0;i<10;i++) {
                System.out.println("Page=>>>>>>>>>>>>>>>"+i);
                Pageable pageable = (Pageable) PageRequest.of(page, size, Sort.by("name").ascending());
                List<EmployeeEntity> all = repo.findAll(pageable).getContent();
                all.forEach(data -> {
                    System.out.println(data);
                });
                repo.findAll(pageable).forEach(System.out::println);
            }
//            EmployeeEntity allEmployee = repo.getAllEmployee(5001);
//            System.out.println(allEmployee);

//            EmployeeEntity empl = repo.getEmployeeUsing("IT2", 5003);
//            System.out.println(empl);
        };
    }

}
