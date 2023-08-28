package ez.en.page.admin.camping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ez.en.page.domain.PageMaker;
import ez.en.page.domain.SearchCriteria;
import ez.en.page.file.FileDTO;
import ez.en.page.file.FileService;
import ez.en.page.review.ReviewDTO;
import ez.en.page.review.ReviewService;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("/admin/scamping/*")
public class AdminSearchCampingController {
	

	private static final Logger logger = LoggerFactory.getLogger(AdminSearchCampingController.class);
	@Inject
	private AdminCampingService adminCampingService;
	@Inject
	private ReviewService rservice;
	@Inject
	private FileService fileService;
	
//	검색기능 추가 후 조회 
	@GetMapping("/list")
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		logger.info(cri.toString());
		
		model.addAttribute("list", adminCampingService.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(adminCampingService.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
//	상세 조회
	@GetMapping("/detail")
	public void detail(@RequestParam("cam_code") String cam_code, @ModelAttribute("cri") SearchCriteria cri, Model model, 
			HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int count = rservice.reviewCount(cam_code);
		List<ReviewDTO> rdto = rservice.camReviewAll(cam_code);
		
		 model.addAttribute("count",count);
	      model.addAttribute("rrdto", rdto);
		
		model.addAttribute("acamping", adminCampingService.detail(cam_code));
	}
	
	
	
//	삭제
	@PostMapping("/removePage")
	public String remove(@RequestParam("cam_code") String cam_code, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		adminCampingService.remove(cam_code);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/admin/scamping/list";
	}
	
//	수정
	@GetMapping("/modifyPage")
	public void modifyPagingGET(String cam_code, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		model.addAttribute("acamping", adminCampingService.detail(cam_code));
	}
	
	@PostMapping("/modifyPage")
	public String modifyPagingPOST(AdminCampingDTO adminCampingDTO, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		logger.info(cri.toString());
		adminCampingService.modify(adminCampingDTO);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		logger.info(rttr.toString());
		
		return "redirect:/admin/scamping/list";
	}
	
//	등록
	@GetMapping("/register")
	public void registGET() throws Exception{
		
		logger.info("regist get .........................");
	}
	
	@PostMapping("/register")
	public String registPOST(AdminCampingDTO adminCampingDTO, RedirectAttributes rttr) throws Exception{
		logger.info("regist post ..................");
		logger.info(adminCampingDTO.toString());
		
		adminCampingService.register(adminCampingDTO);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/admin/scamping/list";
	}
	
//	파일 업로드
	@ResponseBody
	@PostMapping("/campingImg1Upload")
	public FileDTO campingImg1(MultipartFile uploadFile, HttpServletRequest request, String cam_code) {
		
		FileDTO fileDTO = new FileDTO();
		logger.info(uploadFile.getOriginalFilename()+"===================");
		String fileName = uploadFile.getOriginalFilename();
			if(cam_code != null) {
				fileName = cam_code+"_"+uploadFile.getOriginalFilename();
			}
			String uploadFolder = request.getServletContext().getRealPath("resources/images");
			
			fileDTO.setF_name(fileName);
			logger.info("파일이름 : " + fileName);
			logger.info("업로드 경로 : " + uploadFolder);
			
			File saveFile = new File(uploadFolder, fileName);
			try {
				uploadFile.transferTo(saveFile);
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder, "s_"+fileName));
				Thumbnailator.createThumbnail(uploadFile.getInputStream(), thumbnail, 500, 500);
				
				thumbnail.close();
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return fileDTO;
		
	}
	
//	미리보기
	@ResponseBody
	@GetMapping("showCampingImg1")
	public ResponseEntity<byte[]> showcampingImg1(@RequestParam("fileName") String fileName, HttpServletRequest request){
		String folderPath = request.getServletContext().getRealPath("/")+"resources/images";
		
		logger.info("파일이름 : " + fileName);
		
		ResponseEntity<byte[]> result = null;
		
		File file = new File(folderPath + fileName);
		HttpHeaders header = new HttpHeaders();
		
		logger.info("경로가 지정된 파일명" + file);
		
		try {
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
