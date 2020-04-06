package com.oguzkurtcebe.organization.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oguzkurtcebe.organization.model.User;

@Service
@Primary
@Transactional
public class JpaUserDetailsService implements UserDetailsService {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> resultList = entityManager
				.createQuery("select distinct u from User u left join fetch u.roles where u.username = :username",
						User.class)
				.setParameter("username", username).getResultList();	
		
		if (resultList.isEmpty())
			throw new UsernameNotFoundException("User not found :" + username);
		System.out.println("Roller2!!!!:"+resultList.get(0).getAuthorities().toString());
		return resultList.get(0);
	
	}

	
    }

