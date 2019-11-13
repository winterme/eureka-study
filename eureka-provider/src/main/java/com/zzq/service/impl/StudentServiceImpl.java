package com.zzq.service.impl;

import com.zzq.service.StudentService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentServiceImpl implements StudentService {

    @RequestMapping("/getStudents")
    @Override
    public List<String> getStudents(String sid) {
        System.out.println("==============================>被执行==>" + sid );
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangzq");
        list.add("licm");
        list.add(sid);

        try {
            InetAddress address = InetAddress.getLocalHost();
            list.add(address.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return list;
    }
}
