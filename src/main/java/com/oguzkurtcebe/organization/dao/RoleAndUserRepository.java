package com.oguzkurtcebe.organization.dao;

import com.oguzkurtcebe.organization.model.User;

public interface RoleAndUserRepository {
boolean create(User user);
User update(User user);
User findByKey(String key);


}
