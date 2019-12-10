package com.springwebmvc.Repositories;

import com.springwebmvc.Models.Folders;
import com.springwebmvc.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by motaleb on 7/18/17.
 */
@Transactional
public interface FolderRepository extends JpaRepository<Folders,String> {
    List<Folders> findAllByCreatedBy(User userName);
}
