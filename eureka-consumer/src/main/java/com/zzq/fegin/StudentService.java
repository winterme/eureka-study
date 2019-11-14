package com.zzq.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "eureka-provider")
public interface StudentService extends com.zzq.service.StudentService {

    @RequestMapping("/getStudents")
    @Override
    public List<String> getStudents(@RequestParam("sid") String sid);

}
