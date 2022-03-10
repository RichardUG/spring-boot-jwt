package edu.eci.ieti.controller;

import edu.eci.ieti.data.Tasks;
import edu.eci.ieti.dto.TaskDto;
import edu.eci.ieti.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping( "/v1/tasks" )
public class TasksController {
    @Autowired
    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAll());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Tasks> findById( @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));

    }

    @PostMapping
    public ResponseEntity<Tasks> create(@RequestBody TaskDto taskDto ) {
        System.out.println("sasdasdaz");
        List<Tasks> tasksList = taskService.getAll();
        String id="1";
        if (tasksList.size()>0){
            id = String.valueOf((Integer.parseInt(tasksList.get(tasksList.size()-1).getId())+1));
        }
        Tasks tasks = new Tasks(taskDto, LocalDate.now(),id);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.create(tasks));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Tasks> update( @RequestBody TaskDto taskDto, @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(taskDto,id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try{
            taskService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body((true));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body((false));
        }
    }
}
