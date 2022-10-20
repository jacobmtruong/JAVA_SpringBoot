package com.example.mvc.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mvc.bookclub.models.Book;
import com.example.mvc.bookclub.models.LoginUser;
import com.example.mvc.bookclub.models.User;
import com.example.mvc.bookclub.services.BookService;
import com.example.mvc.bookclub.services.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService service;
	
	@Autowired
	BookService bookService;
	
	@GetMapping ("/welcome")
	public String welcomePage(HttpSession session, Model model) {
		
		Long userID = (Long) session.getAttribute("user_id");
		
		//take a list of book for JSP render
		List<Book> allTheBooks = bookService.allBooks();
		
		if (userID == null) {
			return "redirect:/";
		} else {
			User sessionUser = service.findOne(userID);
			model.addAttribute("name", sessionUser.getName());
			
			// add books from DB to JSP page
			model.addAttribute("allTheBooks", allTheBooks);
		}
		return "welcomePage.jsp";
	}
	
	
	@GetMapping ("/")
	public String homePage(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "homePage.jsp";
	}
	
	
	@PostMapping ("register_user")
	public String registerUserAction(@Valid @ModelAttribute("newUser") User user, 
										BindingResult result, 
										HttpSession session,
										Model model) {
		service.register(user, result);
		
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "homePage.jsp";	
		} else 
			session.setAttribute("user_id", user.getId());
			return "redirect:/welcome";
	}
	
	
	
	@PostMapping ("/login_user")
	public String loginUserAction(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
									BindingResult result,
									Model model,
									HttpSession session) {
		
		User user = service.login(loginUser, result);
		
		if(result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("newUser", new User());
			return "homePage.jsp";
		} else {
			session.setAttribute("user_id", user.getId());
			return "redirect:/welcome";
		}
	}
	
	@GetMapping("/logout")
	public String logoutAction(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
}
