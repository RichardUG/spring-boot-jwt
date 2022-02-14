package edu.eci.ieti.controller;

import edu.eci.ieti.data.User;
import edu.eci.ieti.dto.UserDto;
import edu.eci.ieti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));

    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto ) {

        List<User> users= userService.getAll();
        String id = "1";
        if(users.size()>0){
            id = String.valueOf((Integer.parseInt(users.get(users.size()-1).getId())+1));
        }
        User user = new User(userDto, LocalDate.now(), id);
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userDto,id));
    }

    @PostMapping( "/{id}" )
    @RolesAllowed("ADMIN")
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try{
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body((true));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()).body((false));
        }
    }

    @GetMapping( "/findUsersWithNameOrLastNameLike/{queryparam}" )
    public ResponseEntity<List<User>> findUsersWithNameOrLastNameLike( @PathVariable String queryparam ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersWithNaeOrLastNameLike(queryparam));

    }
    @GetMapping( "/FindByDate/{date}" )
    public ResponseEntity<List<User>> findUsersCreatedAfter(@PathVariable String date ) throws ParseException {
        Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return new ResponseEntity<List<User>>(userService.findUsersCreatedAfter(date1), HttpStatus.OK );
    }
}
