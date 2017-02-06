package cabanas.garcia.ismael.examples.rest;

import cabanas.garcia.ismael.examples.domain.User;
import cabanas.garcia.ismael.examples.repository.UserRepository;
import cabanas.garcia.ismael.examples.rest.response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<UserResponse> create(@RequestBody User user){
        LOGGER.info("Creating this user %s", user);

        userRepository.save(user);

        UserResponse userResponse = UserResponse.builder().id(String.valueOf(user.getId())).name(user.getName()).build();

        final URI location = ServletUriComponentsBuilder
                .fromCurrentServletMapping().path("/users/{id}").build()
                .expand(user.getId()).toUri();

        return ResponseEntity.created(location).body(userResponse);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<UserResponse> update(@RequestBody User user){
        LOGGER.debug("Updating user %s", user);

        userRepository.save(user);

        UserResponse userResponse = UserResponse.builder().id(String.valueOf(user.getId())).name(user.getName()).build();

        return ResponseEntity.ok(userResponse);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long id){
        LOGGER.debug("Getting user by identifier %s", id);

        User user = userRepository.findOne(id);

        UserResponse userResponse = UserResponse.builder().id(String.valueOf(user.getId())).name(user.getName()).build();

        return ResponseEntity.ok(userResponse);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        LOGGER.debug("Deleting user with identifier %s", id);

        userRepository.delete(id);

        return ResponseEntity.noContent().build();
    }
}
