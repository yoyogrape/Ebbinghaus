package com.ebbinghaus.service;

import com.alibaba.fastjson.JSON;
import com.ebbinghaus.repository.dao.TaskDao;
import com.ebbinghaus.repository.entity.TaskEntity;
import com.ebbinghaus.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskService {
    @Autowired
    private TaskDao dao;

    public String acceptTask(String taskValue) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskValue(taskValue);
        taskEntity.setUpdateTime(DateUtils.getDate());
        TaskEntity save = dao.save(taskEntity);
        return JSON.toJSONString(save);
    }

    public String findTaskByDate(String byDate) {
        List<String> abhDateList = null;
        try {
            abhDateList = DateUtils.getABHDateList(byDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<TaskEntity> taskEntities = dao.findTaskEntitiesByUpdateTimeIn(abhDateList);
        taskEntities.sort(Comparator.comparing(TaskEntity::getUpdateTime).reversed());
        StringBuffer task = new StringBuffer();
        AtomicInteger num = new AtomicInteger(1);
        taskEntities.forEach(t -> task.append((num.getAndIncrement()) + "、").append(t.getTaskValue()).append("\n"));
        return task.toString();
    }

    public String insertTestData() {

        String date = DateUtils.getDate();

        for (int i = 0; i < 1000; i++) {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskValue("task=" + i);
            taskEntity.setUpdateTime(date);
            try {
                date = DateUtils.incrByDay(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dao.save(taskEntity);
        }
        return null;
    }
}
