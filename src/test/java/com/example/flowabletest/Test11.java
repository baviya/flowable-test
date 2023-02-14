package com.example.flowabletest;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test11 {
    String staffId = "1000";
    @Autowired
    RuntimeService runtimeService;
    /**
     * 开启一个流程
     */
    @Test
     public void askForLeave() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("leaveTask", staffId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("ask_for_leave", map);
        runtimeService.setVariable(processInstance.getId(), "name", "javaboy");
        runtimeService.setVariable(processInstance.getId(), "reason", "休息一下");
        runtimeService.setVariable(processInstance.getId(), "days", 10);
        log.info("创建请假流程 processId：{}", processInstance.getId());
    }
}
