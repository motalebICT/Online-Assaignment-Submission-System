package com.springwebmvc.Repositories;

import com.springwebmvc.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by motaleb on 7/8/17.
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User,String>{
}
