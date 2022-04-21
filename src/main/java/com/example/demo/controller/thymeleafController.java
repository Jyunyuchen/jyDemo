package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.User;
import com.example.demo.exception.StudentNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class thymeleafController {
	
	
	@GetMapping("/get-session")
	@ResponseBody
	public String getSession(HttpSession httpSession) {
		return httpSession.getAttribute("sessionTOKEN") != null ?
			   (String) httpSession.getAttribute("sessionTOKEN") : "Cookies錯誤";
	}
	
	/**
	 * 在銀行開了一個帳戶(Session)存放鍵值對「"sessionTOKEN"/"session測試是否會在瀏覽器產生一個Token"」
	 * 並把提款卡給了用戶(將JSESSIONID寫到Cookies)
	 * 在「getSession」方法，請求訪問這個getSession方法時，會攜帶JSESSIONID，
	 * servlet驗證此JSESSIONID是否能查到鍵值對，可以的話返回值回去
	 * @param httpSession
	 */
	@GetMapping("/save-session")
	@ResponseBody
	public void saveSession(HttpSession httpSession) {
		httpSession.setAttribute("sessionTOKEN","session測試是否會在瀏覽器產生一個Token");
	}
	
	@GetMapping("/status_code")
	@ResponseBody
	public String getStatusCode(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		return String.valueOf(statusCode);
	}
	

	@GetMapping("/ex/{id}/{name}")
    public void exception(
    		@PathVariable(name = "id") int id, 
    		@PathVariable(name = "name") String name) {
		throw new StudentNotFoundException("測試自定義例外異常");
	}
	
	
	//多個相同名稱的參數封裝成陣列
	@GetMapping("/hello5")
	@ResponseBody
    public List<String> hello5(String[] strs) {
		List<String> list = Arrays.asList(strs);
		System.out.println(list);
		return list;
	}
	
	//Spring Boot自帶JacksonHttpMessageConvertersConfiguration,
	//可將物件以json形式返回
	/*@GetMapping("/hello3")
	@ResponseBody
    public User hello3() {
		ObjectMapper objectMapper = new ObjectMapper();
		User user1 = new User("小明", 18);
		return user1;
	}*/
	
	//加入@ResponseBody告訴spring要回傳字串不是重定向視圖(頁面跳轉)
	//使用ObjectMapper將物件轉成json字串
	/*@GetMapping("/hello2")
	@ResponseBody
    public String hello2() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		User user1 = new User("小明", 18);
		String json = objectMapper.writeValueAsString(user1);
		return json;
	}*/
	
	//加入@ResponseBody告訴spring要回傳字串不是重定向視圖(頁面跳轉)
	/*@GetMapping("/hello1")
	@ResponseBody
    public String hello1() {
		return "Hello!!";
	}
	
	@GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name); // set request attribute with key "name"
        return "hello"; // forward to hello.html
    }*/
}
