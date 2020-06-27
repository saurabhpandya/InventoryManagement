package com.inventorymanagement.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagement.model.UsersMaster;

@RestController
@RequestMapping("management/api/v1")
public class StudentManagementController {

	@RequestMapping(path = "{id}")
	public UsersMaster getUser(@PathVariable("id") int id) {
		return getStudents().stream().filter(student -> id == student.getId()).findFirst()
				.orElseThrow(() -> new IllegalStateException("Student " + id + " doesn't exist"));
	}

	@GetMapping("students")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	private List<UsersMaster> getStudents() {

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

	@PostMapping
	@PreAuthorize("hasAuthority('user:write')")
	public void registerNewStudent(@RequestBody UsersMaster usersMaster) {
		System.out.println("Register Student:" + usersMaster);
	}

	@DeleteMapping(path = "{studentId}")
	@PreAuthorize("hasAuthority('user:write')")
	public void deleteStudent(@PathVariable("studentId") int studentId) {
		System.out.println("Delete Student:" + studentId);
	}

	@PutMapping(path = "{studentId}")
	@PreAuthorize("hasAuthority('user:write')")
	public void updateStudent(@PathVariable int studentId, @RequestBody UsersMaster usersMaster) {
		System.out.println("Update Student:" + studentId);
	}

}
