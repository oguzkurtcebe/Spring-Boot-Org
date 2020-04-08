package com.oguzkurtcebe.organization.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oguzkurtcebe.organization.dao.RoleAndUserRepository;
import com.oguzkurtcebe.organization.model.User;
import com.oguzkurtcebe.organization.service.MailService;
import com.oguzkurtcebe.organization.service.UserService;

@RestController
@RequestMapping("/register")
public class RegisterUserAndRoleRestController {
	private RoleAndUserRepository rAu;
	@Autowired
	private UserService userService;
	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/verify/reg/{key}", method = RequestMethod.GET)
	public String regOk(@PathVariable("key") String key) {
		if (userService.findByKey(key)) {
			return "redirect:/register/loginOk";
		}
		return "redirect:/register/loginFalse";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody User user) {
		try {
			userService.createUser(user);
			return ResponseEntity.ok(200);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> register(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			user.setId(id);
			userService.updateUser(user);
			return ResponseEntity.ok(200);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
    
	@GetMapping("/loginOk")
	public ResponseEntity<?> loginOk() {
      return ResponseEntity.ok("BASARILI");
	}

	@GetMapping("/loginFalse")
	public ResponseEntity<?> loginFalse() {
      return ResponseEntity.ok("HATALI");
	}
}
