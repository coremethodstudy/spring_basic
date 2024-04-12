package org.multimodule.spring_basic.web;

import lombok.RequiredArgsConstructor;
import org.multimodule.spring_basic.common.MyLogger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
