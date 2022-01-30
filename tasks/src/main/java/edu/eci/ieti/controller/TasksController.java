package edu.eci.ieti.controller;

import edu.eci.ieti.data.Tasks;
import edu.eci.ieti.dto.TaskDto;
import edu.eci.ieti.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping( "/v1/tasks" )
public class TasksController {

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
        List<Tasks> tasksList = taskService.getAll();
        String id = tasksList.get(tasksList.size()).getId()+1;
        Tasks tasks = new Tasks(taskDto, LocalDate.now(), id);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.create(tasks));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Tasks> update( @RequestBody TaskDto userDto, @PathVariable String id ) {
        Tasks tasks = new Tasks(userDto,taskService.findById(id).getCreated(), id);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(tasks,id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        if (taskService.deleteById(id)){
            return ResponseEntity.status(HttpStatus.OK).body((true));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body((false));
        }
    }
}
