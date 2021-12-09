package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;

@Controller
public class ValidUserController {

	@GetMapping(value = "/validUser")
    public String displayForm(Model model) {
    	User user = new User();
    	model.addAttribute(user);
    	return "validUser";
    }

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView processForm(@Valid @ModelAttribute User user, BindingResult bindingResult) {
	 	
	   //如果驗證通過則去向customerDone視圖(這裡未創建)
       ModelAndView model = new ModelAndView("customerDone");
       if (bindingResult.hasErrors()) {
    	 //如果驗證失敗則返回customerCreate視圖
         model = new ModelAndView("validUser");
         return model;
       }
       model.addObject(user);
       return model;
    }
}
