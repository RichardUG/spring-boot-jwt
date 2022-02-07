package edu.eci.ieti.repository;

import edu.eci.ieti.data.User;
import org.springframework.data.mongodb.repository.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {

}
