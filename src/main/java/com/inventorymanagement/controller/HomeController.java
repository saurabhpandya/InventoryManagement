package com.inventorymanagement.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagement.model.UsersMaster;

@RestController
@RequestMapping("api/v1/users")
public class HomeController {

	@RequestMapping(path = "{id}")
	public UsersMaster getUser(@PathVariable("id") int id) {
		return getStudents().stream().filter(student -> id == student.getId()).findFirst()
				.orElseThrow(() -> new IllegalStateException("Student " + id + " doesn't exist"));
	}

	@GetMapping
	public List<UsersMaster> getStudents() {

		UsersMaster usersMaster1 = new UsersMaster();
		usersMaster1.setId(1);
		usersMaster1.setFirstName("Saurabh");
		usersMaster1.setLastName("Pandya");

		UsersMaster usersMaster2 = new UsersMaster();
		usersMaster2.setId(2);
		usersMaster2.setFirstName("Gunjan");
		usersMaster2.setLastName("Pandya");

		UsersMaster usersMaster3 = new UsersMaster();
		usersMaster3.setId(3);
		usersMaster3.setFirstName("Anand");
		usersMaster3.setLastName("Trivedi");

		return Arrays.asList(usersMaster1, usersMaster2, usersMaster3);

	}

	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}

}
