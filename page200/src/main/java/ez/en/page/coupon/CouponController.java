package ez.en.page.coupon;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CouponController {
	@Autowired
	private CouponService service;
	
	private static final Logger logger = LoggerFactory.getLogger(CouponController.class);
	
//	전체조회_관리자
	@GetMapping("coupon")
	public ModelAndView coupon(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView model = new ModelAndView();
		List<CouponDTO>listAll = service.listAll();
		logger.info("전체조회" + listAll);
		model.addObject("listAll", listAll);
		model.setViewName("couponlist");
		return model;
	}
	
//	전체조회_유저
	@GetMapping("coupon_user")
	public ModelAndView coupon_user(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView model = new ModelAndView();
		List<CouponDTO>listAll = service.listAll();
		logger.info("전체조회" + listAll);
		model.addObject("listAll", listAll);
		model.setViewName("couponlist_user");
		return model;
	}
	
//	선택조회
	@GetMapping("coudetail")
	public ModelAndView coudetail(@RequestParam("cp_code") String cp_code) {
		ModelAndView model = new ModelAndView();
		CouponDTO coupon = service.selectOne(cp_code);
		model.addObject("coupon", coupon);
		model.setViewName("coudetail");
		return model;
	}
	
//	수정
	@GetMapping("update")
	public ModelAndView update(@RequestParam("cp_code") String cp_code) {
		ModelAndView model = new ModelAndView();
		CouponDTO coupon = service.selectOne(cp_code);
		model.addObject("coupon", coupon);
		model.setViewName("couponupdate");
		return model;
	}

	@PostMapping("update")
	public ModelAndView update(CouponDTO dto) {
		ModelAndView model = new ModelAndView();
		int up = service.update(dto);
		if(up==0) { // 수정실패
			String cp_code = dto.getCp_code();
			CouponDTO coupon = service.selectOne(cp_code);
			model.addObject("coupon", coupon);
			model.setViewName("couponupdate");
		} else { // 수정 성공
			List<CouponDTO>listAll = service.listAll();
			model.addObject("listAll", listAll);
			model.setViewName("couponlist");
		}
		return model;
	}
	
//	추가
	@GetMapping("insert")
	public ModelAndView insert() {
		ModelAndView model = new ModelAndView();
		model.setViewName("couponinsert");
		return model;
	}
	
	@PostMapping("insert")
	public ModelAndView insert(CouponDTO dto) {
		ModelAndView model = new ModelAndView();
		logger.info("테스틎ㅇ");
		int up = service.insert(dto);
		if(up == 0) { // 추가 실패
			String cp_code = dto.getCp_code();
			CouponDTO coupon = service.selectOne(cp_code);
			model.addObject("coupon", coupon);
			model.setViewName("couponinsert");
		} else { // 추가 성공
			List<CouponDTO>listAll = service.listAll();
			model.addObject("listAll", listAll);
			model.setViewName("couponlist");
		}
		return model;
	}
	
//	삭제
	@GetMapping("delete")
	public ModelAndView delete(String cp_code) {
		ModelAndView model = new ModelAndView();
//		logger.info("테스틎ㅇ");
		service.delete(cp_code);
		List<CouponDTO>listAll = service.listAll();
		model.addObject("listAll", listAll);
		model.setViewName("couponlist");
		return model;
	}
	
//	쿠폰 수량 감소
	

	
}
