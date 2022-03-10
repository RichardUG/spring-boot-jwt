package edu.eci.ieti.service;

import edu.eci.ieti.data.Tasks;
import edu.eci.ieti.dto.TaskDto;

import java.util.List;

public interface TaskService
{
    Tasks create(Tasks task );
    Tasks findById( String id );
    List<Tasks> getAll();
    void deleteById( String id );
    Tasks update(TaskDto taskDto, String id );
}