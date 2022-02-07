package edu.eci.ieti.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoDatabaseImpl;
import edu.eci.ieti.data.User;
import edu.eci.ieti.dto.UserDto;
import edu.eci.ieti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceMongoDB implements UserService{

    private final UserRepository userRepository;



    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;

    }

    @Override
    public User create(User user ){
        userRepository.save(user);
        return null;
    }

    @Override
    public User findById(String id )
    {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String id ){
        userRepository.deleteById(id);
    }

    @Override
    public User update(UserDto userdto, String id ){
        User user = userRepository.findById(id).get();
        user.setEmail(userdto.getEmail());
        user.setName(userdto.getName());
        user.setLastName(userdto.getLastName());
        userRepository.save(user);
        return null;
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        Criteria criteria= new Criteria();
        criteria.and("name").is(queryText);
        criteria.orOperator(new Criteria().and("name").is(queryText), new Criteria().and("lastName").is(queryText));
        Query query = new Query(criteria);

        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return null;
    }
}