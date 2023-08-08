package ez.en.page.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping(value = "userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.userList());
		mav.setViewName("userList");
		return mav;
	}
	
}
