package com.newp.tliasproject;

import com.newp.tliasproject.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class GetPhto {
@PostMapping("/upload")
    public Result getPhto(String username , Integer age, MultipartFile file) {

System.out.println("前端传来的数据时"+username+" "+age+" "+file);

    return Result.suceess();
    }



}
