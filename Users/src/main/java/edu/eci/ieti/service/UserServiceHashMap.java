package edu.eci.ieti.service;

import edu.eci.ieti.data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceHashMap implements UserService{
    private final HashMap<String, User> userHashMap = new HashMap<>();

    @Override
    public User create(User user) {
        return userHashMap.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return userHashMap.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>(userHashMap.values());
    }

    @Override
    public void deleteById(String id) {
        userHashMap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        return userHashMap.put(userId,user);
    }
}
