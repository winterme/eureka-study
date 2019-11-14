package com.zzq.service.impl;

import com.zzq.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentServiceImpl implements StudentService {

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/getStudents")
    @ResponseBody
    @Override
    public List<String> getStudents(String sid) {
        System.out.println("==============================>被执行==>" + sid );
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangzq");
        list.add("licm");
        list.add(sid);
        list.add(appName);

        try {
            InetAddress address = InetAddress.getLocalHost();
            list.add(address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return list;
    }
}
