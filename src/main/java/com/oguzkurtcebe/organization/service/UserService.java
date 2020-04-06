package com.oguzkurtcebe.organization.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzkurtcebe.organization.dao.RoleAndUserRepository;
import com.oguzkurtcebe.organization.model.User;

@Service
@Transactional
public class UserService {
    @Autowired
	private RoleAndUserRepository roleAndUserRepository;
    @Autowired
    private MailService mailService;
    
    public Long createUser(User user) {
    	String uuid=UUID.randomUUID().toString();
    	user.setVerifyKey(uuid);
    	
    	if(roleAndUserRepository.create(user)) {
    		mailService.mailSenderFunction(user.getEmail(), user.getVerifyKey());
    	}
    	return 1l;
    }
	
    public void updateUser(User user) {
    	roleAndUserRepository.update(user);
    }
	
    public boolean findByKey(String key) {
    	User user = roleAndUserRepository.findByKey(key);
    	
    	if(user!=null) {
    		user.setActive(true);
    		roleAndUserRepository.update(user);
    		return true;
    	}else {
    		return false;
    	}
    }
}
