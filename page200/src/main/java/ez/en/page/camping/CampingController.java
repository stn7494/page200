package ez.en.page.camping;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ez.en.page.camping_thema.ThemaService;
import ez.en.page.domain.Criteria;
import ez.en.page.domain.PageMaker;
import ez.en.page.review.ReviewService;



@Controller
@RequestMapping("/camping/*")
public class CampingController {
	
	@Inject
	private CampingService campingService;
	private ThemaService themaService;
	private static final Logger logger = LoggerFactory.getLogger(CampingController.class);
	
	// kdj 추가함
	@Autowired
	private ReviewService rservice;
	
	//1.캠핑장 등록 (캠핑장 등록 버튼은 admin의 캠핑장 전체목록(list)view -> register) -> 등록 후 list목록으로 (registerPost)
	//캠핑장 등록 폼 (registerGET)
	@GetMapping("/register")
	public void registerGET(CampingDTO campingDTO, Model model) throws Exception {
		logger.info("register GET ====================> ");
		
	}
	
//	//캠핑장 등록 후 데이터 처리 -> list목록으로 (registerPOST)
//	@PostMapping("/register")
//	public String registerPOST(CampingDTO campingDTO, Model model) throws Exception {
//		
//		logger.info("register POST ===================>");
//		logger.info(campingDTO.toString());
//		
//		campingService.register(campingDTO);
//		
//		model.addAttribute("result", "success");	//캠핑장 등록
//		
////		글쓰기 완료후 게시판 목록이 다시 보이게
////		List<CampingDTO> list = campingService.list();
////		model.addAttribute("list", list);
//		
//		return "redirect:/camping/list";
//	}
	
	//캠핑장 등록 후 데이터 처리 -> list목록으로 (registerPOST)
	@PostMapping("/register")
	public String registerPOST(CampingDTO campingDTO, RedirectAttributes rttr) throws Exception {
		
		logger.info("register POST ===================>");
		logger.info(campingDTO.toString());
		
		campingService.register(campingDTO);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/camping/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) throws Exception{
		logger.info("show all list =====================>");
		model.addAttribute("list", campingService.list());
	}
	
//	@GetMapping("/detail")
//	public void read(@RequestParam("cam_code") String cam_code, Model model) throws Exception{
//		CampingDTO campingDTO = new CampingDTO();
//		model.addAttribute("camping", campingDTO);
//		model.addAttribute("camping", campingService.detail(cam_code));
//		model.addAttribute(campingService.detail(cam_code));
//	}

	
//	//캠핑장 상세조회에 thema_name들어갈수 있게 추가
//	@GetMapping("/detail")
//	public void read(@RequestParam("cam_code") String cam_code, Model model, @RequestParam("thema_code") String thema_code) throws Exception{
//		model.addAttribute(campingService.detail(cam_code));
//		
////		cam_code로 찾은 상세페이지의 themaCode
////		ThemaDTO themaDTO= themaService.selectOne(thema_code);	//thema_code로 themaDTO선택 ----> thema_name가져오기
////		model.addAttribute("tmName", themaDTO);	//view에서 사용할 이름 tmName
//	}
	
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("cam_code") String cam_code,
			RedirectAttributes rttr) throws Exception{
		
		campingService.remove(cam_code);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/camping/list";
	}
	
	@GetMapping("/modify")
	public void modifyGET(String cam_code, Model model) throws Exception{
		
		model.addAttribute("camping", campingService.detail(cam_code));
	}
	
	@PostMapping("/modify")
	public String modifyPOST(CampingDTO campingDTO, RedirectAttributes rttr) throws Exception{
		logger.info("modify post ================>");
		
		campingService.modify(campingDTO);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/camping/list";
	}
	
//	@PostMapping("/modify/{cam_code}")
//	public String modifyPOST(CampingDTO campingDTO, RedirectAttributes rttr, @PathVariable("cam_code") String cam_code) throws Exception{
//		logger.info("modify post ================>");
//		
//		CampingDTO campingTemp = campingService.detail("cam_code");
//		
////		campingTemp.setCam_code(campingDTO.getCam_code());
////		campingTemp.setRegion_code(campingDTO.getRegion_code());
////		campingTemp.setF_code(campingDTO.getF_code());
//		campingTemp.setCam_name(campingDTO.getCam_name());
////		campingTemp.setCam_address(campingDTO.getCam_address());
////		campingTemp.setCam_tel(campingDTO.getCam_tel());
////		campingTemp.setCam_start_time(campingDTO.getCam_start_time());
////		campingTemp.setCam_finish_time(campingDTO.getCam_finish_time());
////		campingTemp.setThema_code(campingDTO.getThema_code());
////		campingTemp.setOption_code(campingDTO.getOption_code());
////		campingTemp.setCam_hide(campingDTO.getCam_hide());
////		campingTemp.setCam_regdate(campingDTO.getCam_regdate());
//		
//		campingService.modify(campingTemp);
//		
//		rttr.addFlashAttribute("msg", "SUCCESS");
//		
//		return "redirect:/camping/list";
//	}

	//페이징
	@GetMapping("/listCri")
	public void list(Criteria cri, Model model) throws Exception{
		
		logger.info("show list page with Criteria......................");
		
		model.addAttribute("list", campingService.listCriteria(cri));
	}
	
//	@GetMapping("/listPage")
//	public void listPage(Criteria cri, Model model) throws Exception{
//		
//		logger.info(cri.toString());
//		
//		model.addAttribute("list", campingService.listCriteria(cri));
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(131);	//임의의 값 넣고 테스트
//		
//		model.addAttribute("pageMaker", pageMaker);
//		
//	}
	
	@GetMapping("/listPage")
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		
		logger.info(cri.toString());
		
		model.addAttribute("list", campingService.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMager.setTotalCount(131);
		
		pageMaker.setTotalCount(campingService.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	

	
	//2.캠핑장 수정 (캠핑장 수정 버튼은 admin의 캠핑장 상세페이지(detail)view -> modify) -> 수정 후 detail페이지 or list 목록으로 (modifyPOST)
	//캠핑장 수정 폼(modifyGET)
	
	//캠핑장 수정 후 데이터 처리 -> detail / list로 (modifyPOST)
	
	//3.캠핑장 삭제 (캠핑장 삭제 버튼은 admin의 캠핑장 상세페이지(detail)view)
	
	//4.캠핑장 전체 목록
//	@GetMapping("camping/list")
//	public String list(Model model, HttpServletRequest request) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		List<CampingDTO> list = campingService.list();
//		model.addAttribute("camList", list);
//		
//		return "camping/list";
//	}
//	
	
	//5.캠핑장 상세 페이지 (캠핑장 전체 목록에서 캠핑장 이름(cam_name)을 클릭 했을 경우 -> 상세페이지(detail)로 이동
	@GetMapping("camping/detail")
	public String detail(@RequestParam ("cam_code") String cam_code, Model model, HttpServletRequest request) throws Exception {
		int count = rservice.reviewCount(cam_code);
		model.addAttribute("count",count);
		
		return "camping/detail";
	}
	
	//6.캠핑장 예약 정보(캠핑장 상세페이지에서 보여줄 각 캠핑장별 예약 정보)
}
