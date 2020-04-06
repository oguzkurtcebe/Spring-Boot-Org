package com.oguzkurtcebe.organization.dao.jpa;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.oguzkurtcebe.organization.dao.RoleAndUserRepository;
import com.oguzkurtcebe.organization.model.Role;
import com.oguzkurtcebe.organization.model.User;

@Repository("roleAndUserRepository")
public class RoleAndUserRepositoryJpaImpl implements RoleAndUserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean create(User user) {
		Role role=new Role();
		role.setRoleName("USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Collection roles = Arrays.asList(role);
		user.getAuthorities().addAll(roles);	
		entityManager.persist(role);
		entityManager.persist(user);
	   return true;
		
	}

	@Override
	public User update(User user) {
	//	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return entityManager.merge(user);
	}

	@Override
	public User findByKey(String verifyKey) {
		return	 entityManager.createQuery("from User where verifyKey = :verifyKey",User.class).
				setParameter("verifyKey", verifyKey).getSingleResult();			
	}
	
//	
//	@Override
//	public void create(User user,Role role) {
//		user.setPassword(bCryptPasswordEncoder.encode("1234"));
//		
//		Collection roles = Arrays.asList(role);
//		user.getAuthorities().addAll(roles);
//        
//		entityManager.persist(user);
//		entityManager.persist(role);
//			
//	}
//
//
//	@Override
//	public User update(User user, Role role) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
