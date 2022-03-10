package edu.eci.ieti.repository;

import edu.eci.ieti.data.Tasks;
import edu.eci.ieti.dto.TaskDto;
import edu.eci.ieti.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksServiceMongoDB implements TaskService {

    private final TasksRepository tasksRepository;

    public TasksServiceMongoDB(@Autowired TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public Tasks create(Tasks task) {
        return tasksRepository.save(task);
    }

    @Override
    public Tasks findById(String id) {
        return tasksRepository.findById(id).get();
    }

    @Override
    public List<Tasks> getAll() {
        return tasksRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        tasksRepository.deleteById(id);
    }

    @Override
    public Tasks update(TaskDto taskDto, String id) {
        Tasks tasks = tasksRepository.findById(id).get();
        tasks.setAssignedTo(taskDto.getAssignedTo());
        tasks.setDescription(taskDto.getDescription());
        tasks.setStatus(taskDto.getStatus());
        tasks.setName(taskDto.getName());
        return tasksRepository.save(tasks);
    }
}
