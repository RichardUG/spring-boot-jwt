package edu.eci.ieti.service;

import edu.eci.ieti.data.Tasks;

import java.util.List;

public interface TaskService
{
    Tasks create(Tasks task );
    Tasks findById( String id );
    List<Tasks> getAll();
    boolean deleteById( String id );
    Tasks update( Tasks task, String id );
}