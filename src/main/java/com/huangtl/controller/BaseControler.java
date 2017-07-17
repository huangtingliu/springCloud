package com.huangtl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by htl on 2017/7/14.
 */
@Controller
public class BaseControler {

    @RequestMapping(value = "/")
    public @ResponseBody String index(){

        return "Hello World,welcome to my home.";
    }
}
