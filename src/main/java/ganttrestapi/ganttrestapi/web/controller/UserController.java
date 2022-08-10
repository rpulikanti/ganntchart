package ganttrestapi.ganttrestapi.web.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ganttrestapi.ganttrestapi.entity.User;
import ganttrestapi.ganttrestapi.pojo.GanntChart;
import ganttrestapi.ganttrestapi.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers() {
//        log.info("process=get-users");
        return userService.getAllUsers();
    }

    //An API that fetches project data from the Gannt chart
    
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/ganntDetails")
	public GanntChart greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GanntChart(counter.incrementAndGet(), String.format(template, name));
	}

    
    
    
    
    
    
    
	/*
	 * @GetMapping("/{id}") //TODO consider the user input text as ID public
	 * ResponseEntity<User> getUser(@PathVariable Long id) { //
	 * log.info("process=get-user, user_id={}", id); Optional<User> user =
	 * userService.getUserById(id); return user.map( u -> ResponseEntity.ok(u))
	 * .orElse(ResponseEntity.notFound().build()); }
	 */

	/*
	 * @PostMapping("")
	 * 
	 * @ResponseStatus(CREATED) public User createUser(@RequestBody User user) {
	 * log.info("process=create-user, user_email={}", user.getEmail()); return
	 * userService.createUser(user); }
	 * 
	 * @PutMapping("/{id}") public User updateUser(@PathVariable Long
	 * id, @RequestBody User user) { log.info("process=update-user, user_id={}",
	 * id); user.setId(id); return userService.updateUser(user); }
	 * 
	 * @DeleteMapping("/{id}") public void deleteUser(@PathVariable Long id) {
	 * log.info("process=delete-user, user_id={}", id); userService.deleteUser(id);
	 * }
	 */

}
