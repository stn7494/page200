package ez.en.page.reservation;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ez.en.page.camping.CampingDTO;
import ez.en.page.camping_rev_info.CampingRevInfoDTO;


@Controller
//@RequestMapping("/reservation/*/")
public class ReservationController {
	
	@Inject
	private ReservationService reservationService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class); 
	
	
	//날짜 중복 조회

	
	//예약 추가(form)
	@GetMapping("/reservation")
	public void insertGET(@RequestParam("cri_area_code") String cri_area_code,CampingRevInfoDTO campingRevInfoDTO, @RequestParam("cam_code")String cam_code, Model model, ReservationDTO reservationDTO) {
		logger.info("reservation GET =========================>" + cri_area_code);
		logger.info("reservationDTO ===========>" + reservationDTO);
		
		model.addAttribute("cam_code", cam_code);
		model.addAttribute("reservation", reservationDTO);
		model.addAttribute("c_revinfo", campingRevInfoDTO);
	}
	
	//예약 추가(POST)
	
	@PostMapping("/reservation")
	public String reservationPOST(ReservationDTO reservationDTO, @RequestParam("cam_code") String cam_code, RedirectAttributes rttr) throws Exception{
		
		logger.info("reservation POST ======================>");
		logger.info(reservationDTO.toString());
		
		//현재 날짜/시간
		Date now = new Date();
		
		//현재 날짜/시간 출력
		logger.info("현재 날짜/시간 =========> " + now);
		// 포맷팅 정의
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
        
        // 포맷팅 적용
        String formatedNow = formatter.format(now);
 
        // 포맷팅 현재 날짜/시간 출력
        logger.info("현재 날짜/시간 =========> " + formatedNow);  // 202308221116
        
        String rcode = cam_code + "_" + formatedNow;
		reservationDTO.setRev_code(rcode);
		
		logger.info("예약 코드 생성 =============> " + rcode);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		logger.info("cam_code ========> "+cam_code);
		
		reservationService.insert(reservationDTO);
		
//		rttr.addFlashAttribute("msg", "FAIL");
		
		return "redirect:/revlistPage";
//		return null;
	}
	
	@ResponseBody
	@PostMapping("/dateCheck")
	public Map<String, Object> dateCheck(ReservationDTO reservationDTO) {
		logger.info("reservationDTO %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% =============>" + reservationDTO);
		
		Map<String, Object> dateCheck2 = new HashMap<>();
		int check = reservationService.selectDate(reservationDTO);
		
		if(check > 0) {
			dateCheck2.put("Result", false);	//key : 다른 msg에서 msg value:다른msg FAIL
			return dateCheck2;
		}
		dateCheck2.put("Result", true);
		
		return dateCheck2;
	}
	
	

		
	
	
	
	//예약 수정
	
	//예약 취소

}
