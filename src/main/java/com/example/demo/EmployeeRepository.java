// package com.example.demo;

// public class EmployeeRepository {
    
// }

package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
