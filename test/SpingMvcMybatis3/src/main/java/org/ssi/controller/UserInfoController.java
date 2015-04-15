package org.ssi.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.ssi.api.service.UserInfoService;
import org.ssi.mybatis.bean.UserInfo;
  
@Controller  
@RequestMapping("userinfo")  
public class UserInfoController {  
      
    @Autowired  
    private UserInfoService userInfoService;  
  
    @RequestMapping(method=RequestMethod.GET,value="/test") 
    public String test(Model model){  
    	System.out.println("进Action test了");  
    	UserInfo l=this.userInfoService.findByName("xl");  
        
        System.out.println("id->"+l.getAge()+",name->"+l.getName());  
        model.addAttribute("aaa", l.getAge());
        return "test";  
    }  
    
    @RequestMapping(method=RequestMethod.GET,value="/add") 
    public String add(Model model){  
    	System.out.println("进Action gdadd 了");  
    	UserInfo l=new UserInfo();
    	Random random = new Random();
    	
    	int  age=random.nextInt(99);
    	l.setAge(age);
    	l.setName("f范德萨发生的 "+age);
    	userInfoService.addUserInfo(l);  
    	 model.addAttribute("aaa", l.getAge());
        return "test";  
   
    }
    @RequestMapping(method=RequestMethod.GET,value="/delete") 
    public String del(Model model,@RequestParam(value="id") int id){  
    	System.out.println("进Action del 了");
    	userInfoService.deleteUserInfo(id);
    	model.addAttribute("aaa", -1);
        return "test";  
    }  
}  