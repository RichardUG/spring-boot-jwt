package edu.eci.ieti.repository;

import edu.eci.ieti.data.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Repository
public interface UserRepository extends MongoRepository<User,String> {
    List<User> findByName(String queryText);
    List<User> findByLastName(String queryText);
    List<User> findBycreatedAtAfter(Date startDate);
}
