package edu.eci.ieti.service;

import edu.eci.ieti.data.Tasks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskServiceHashMap{
    private final HashMap<String, Tasks> tasksHashMap = new HashMap<>();

    public Tasks create(Tasks tasks) {
        return tasksHashMap.put(tasks.getId(), tasks);
    }

    public Tasks findById(String id) {
        return tasksHashMap.get(id);
    }

    public List<Tasks> getAll() {
        return new ArrayList<Tasks>(tasksHashMap.values());
    }

    public boolean deleteById(String id) {
        try{
            tasksHashMap.remove(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Tasks update(Tasks task, String id) {
        return tasksHashMap.put(id,task);
    }


}
