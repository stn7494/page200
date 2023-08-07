package ez.en.page.mypage;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ez.en.page.domain.Criteria;
import ez.en.page.domain.PageMaker;
import ez.en.page.user.UserDTO;

@Controller
public class MypageController {
	
	@Autowired
	private MypageService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	// sjs의 흔적
	//예약 취소
	@PostMapping(value = "revdelete")
	public ModelAndView revdelete(@RequestParam Map<String, Object> map,
			HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.addObject("revdetail2", service.revdelete(map));
		mav.setViewName("mypage/revlist");
		return mav;
	}
	// sjs의 흔적
	// 예약상세조회
	@GetMapping(value = "revdetail")
	public ModelAndView revdetail(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("revdetail2", service.revdetail2(map));
		mav.setViewName("mypage/revdetail");
		
		return mav;
	}
	// sjs의 흔적
	// 쿠폰 전체조회
	@GetMapping(value = "couponlist")
	public ModelAndView couponlist(HttpServletRequest request,
			HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		mav.addObject("couponlist", service.couponlist(session.getAttribute("user")));
		mav.setViewName("mypage/couponlist");
		
		return mav;
	}
	// sjs의 흔적
	// 회원정보수정form이동
	@GetMapping(value = "edit")
	public ModelAndView edit(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", service.info(session.getAttribute("user")));
		mav.setViewName("mypage/edit");
		
		return mav;
	}
	// sjs의 흔적
	// 회원정보수정 완료
	@PostMapping(value = "edit")
	public ModelAndView edit(HttpServletRequest request,
		UserDTO dto, HttpSession session) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", service.edit(dto));
		mav.addObject("list", service.info(session.getAttribute("user")));
		mav.setViewName("index");
		
		return mav;
	}
	//sjs의 흔적
	// 비밀번호수정form 이동
	@PostMapping(value = "editpasswordform")
	public ModelAndView editpasswordform(@RequestParam("id")String id,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserDTO dto = (UserDTO)session.getAttribute("user");
		dto.setId(id);
		mav.addObject("user", service.info(dto));
		mav.setViewName("mypage/editpassword");
		return mav;
	}
	// sjs의 흔적
	// 비밀번호수정 완료
	@PostMapping(value = "editpassword")
	public ModelAndView editpassword(HttpSession session,HttpServletRequest request,@RequestParam("pw")String pw) throws Exception{
		request.setCharacterEncoding("utf-8");
		UserDTO dto = (UserDTO)session.getAttribute("user");
		dto.setPw(pw);
		ModelAndView mav = new ModelAndView();
		service.editpassword(dto);
		mav.setViewName("index");
		return mav;
	}
	// 리뷰목록 페이징
	@GetMapping(value = "reviewlistPage")
	public ModelAndView revlistCri(Criteria cri,HttpSession session)throws Exception {
		ModelAndView mav = new ModelAndView();
		UserDTO dto =  (UserDTO)session.getAttribute("user");
		cri.setId(dto.getId());
		logger.info(cri.toString());
		mav.addObject("reviewlist", service.reviewlistCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.reviewcountPaging(cri));
		mav.addObject("pageMaker", pageMaker);
		mav.setViewName("mypage/reviewlistPage");
		return mav;
	}
	// 예약목록 페이징
	@GetMapping(value = "revlistPage")
	public ModelAndView revlistPage(Criteria cri,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		UserDTO dto = (UserDTO)session.getAttribute("user");
		logger.info(cri.toString());
		cri.setId(dto.getId());
		mav.addObject("revlist", service.revlistCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countPaging(cri));
		mav.addObject("pageMaker", pageMaker);
		mav.setViewName("mypage/revlistPage");
		return mav;
	}
	// 찜 전체조회
	@GetMapping(value = "jjimlistPage")
	public ModelAndView jjimlistPage(Criteria cri,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView();
		UserDTO dto = (UserDTO)session.getAttribute("user");
		logger.info(cri.toString());
		cri.setId(dto.getId());
		mav.addObject("jjimlist", service.jjimlistCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.jjimlistcountCriteria(cri));
		mav.addObject("pageMaker", pageMaker);
		mav.setViewName("mypage/jjimlistPage");
		return mav;
	}
	// 쿠폰 페이징
	@GetMapping(value = "couponlistPage")
	public ModelAndView couponlistPage(Criteria cri,HttpSession session)throws Exception {
		ModelAndView mav = new ModelAndView();
		UserDTO dto =  (UserDTO)session.getAttribute("user");
		cri.setId(dto.getId());
		logger.info(cri.toString());
		mav.addObject("couponlist", service.reviewlistCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.reviewcountPaging(cri));
		mav.addObject("pageMaker", pageMaker);
		mav.setViewName("mypage/reviewlistPage");
		return mav;
	}
}
