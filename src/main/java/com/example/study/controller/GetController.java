package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    // localhost:8080/api/getMethod
    @RequestMapping(method= RequestMethod.GET, path= "/getMethod")
    public String getRequest(){
        return "Hi getMethod";
    }

    // localhost:8080/api/getParameter?id=1234&password=abcd
    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam String password) {
        System.out.println("id : "+id);
        System.out.println("password : "+password);

        return id+password; // 웹 페이지에 출력
    }

    // localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam; // 웹 페이지에 출력
    }

    @GetMapping("/header")
    public Header getHeader(){

        // {"resultCode: "OK" , "description: "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }


}
