package com.springwebmvc.Repositories;


import com.springwebmvc.Models.SubmissionInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by motaleb on 7/8/17.
 */
@Transactional
@Repository
public interface SubmissionRepository extends CrudRepository<SubmissionInfo,Long>{

List<SubmissionInfo> findAllByFolderName( String folderName);
 void deleteAllByFolderName(String FolderName);
}
