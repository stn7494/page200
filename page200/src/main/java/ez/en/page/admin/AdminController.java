package ez.en.page.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ez.en.page.user.UserController;
import ez.en.page.user.UserDTO;

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService service;
	
	@GetMapping(value = "admin")
	public ModelAndView adminLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adminLogin");
		return mav;
	}
	
	@PostMapping(value = "admin")
	public ModelAndView adminLogin(UserDTO dto, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(service.adminLogin(dto) == null) {
			mav.addObject("msg", "아이디와 비밀번호를 다시 입력해주세요");
			mav.setViewName("adminLogin");
		}else {
			session.setAttribute("admin", service.adminLogin(dto));
			mav.setViewName("index");
		}
		return mav;
	}
	
	
	
	@GetMapping(value = "userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.userList());
		mav.setViewName("admin/userList");
		return mav;
	}
	
	@ResponseBody
	@PostMapping(value = "userStop")
	public Map<String, Object> userStop(@RequestParam("userList[]")List<String> list){
		Map<String, Object> map = new HashMap<String, Object>();
		int result = service.userStop(list);
		if(result != 0) {
			map.put("result", result+"명 회원이 정지되었습니다.");
		}
		
		return map;
	}
	
}
