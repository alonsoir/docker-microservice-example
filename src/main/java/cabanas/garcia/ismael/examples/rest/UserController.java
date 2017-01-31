package cabanas.garcia.ismael.examples.rest;

import cabanas.garcia.ismael.examples.domain.User;
import cabanas.garcia.ismael.examples.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by XI317311 on 31/01/2017.
 */
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody User user){
        LOGGER.debug("Creating user %s", user);

        userRepository.save(user);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody User user){
        LOGGER.debug("Updating user %s", user);

        userRepository.save(user);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        LOGGER.debug("Getting user by id %s", id);

        User user = userRepository.findOne(id);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@RequestBody User user){
        LOGGER.debug("Deleting user %s", user);

        userRepository.delete(user);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
