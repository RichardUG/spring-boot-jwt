package edu.eci.ieti.service;

import edu.eci.ieti.data.User;
import edu.eci.ieti.dto.UserDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user );
    User findById(String id );
    List<User> getAll();
    void deleteById( String id );
    User update(UserDto userdto, String userId );
    List<User> findUsersWithNaeOrLastNameLike(String queryText);
    List<User> findUsersCreatedAfter(Date startDate);
    User findByEmail(String queryText);
}