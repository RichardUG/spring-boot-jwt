package edu.eci.ieti.repository;

import edu.eci.ieti.data.User;
import edu.eci.ieti.dto.UserDto;
import edu.eci.ieti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        return userRepository.save(user);
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
        if (userdto.getPassword() != null) {
            user.setPasswordHash(BCrypt.hashpw(userdto.getPassword(), BCrypt.gensalt()));
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> findUsersWithNaeOrLastNameLike(String queryText) {
        List<User> users = new ArrayList<>();
        users.addAll(userRepository.findByName(queryText));
        users.addAll(userRepository.findByLastName(queryText));
        return users;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findBycreatedAtAfter(startDate) ;
    }

    @Override
    public User findByEmail(String queryText){
        return userRepository.findByEmail(queryText);
    }
}