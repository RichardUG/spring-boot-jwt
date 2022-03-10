package edu.eci.ieti.repository;

import edu.eci.ieti.data.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TasksRepository extends MongoRepository<Tasks,String> {
}
