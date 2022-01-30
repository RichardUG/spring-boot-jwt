package edu.eci.ieti.service;

import edu.eci.ieti.data.Tasks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService{
    private final HashMap<String, Tasks> tasksHashMap = new HashMap<>();

    @Override
    public Tasks create(Tasks tasks) {
        return tasksHashMap.put(tasks.getId(), tasks);
    }

    @Override
    public Tasks findById(String id) {
        return tasksHashMap.get(id);
    }

    @Override
    public List<Tasks> getAll() {
        return new ArrayList<Tasks>(tasksHashMap.values());
    }

    @Override
    public boolean deleteById(String id) {
        try{
            tasksHashMap.remove(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Tasks update(Tasks task, String id) {
        return tasksHashMap.put(id,task);
    }


}
