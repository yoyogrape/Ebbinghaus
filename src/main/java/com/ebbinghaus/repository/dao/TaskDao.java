package com.ebbinghaus.repository.dao;

import com.ebbinghaus.repository.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDao extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findTaskEntitiesByUpdateTimeIn(List<String> dates);
}
