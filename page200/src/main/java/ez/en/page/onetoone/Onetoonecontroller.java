package ez.en.page.onetoone;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Onetoonecontroller {

	@Autowired
	private OnetooneService service;

	@GetMapping("onetoone/list1")
	public ModelAndView list1() {
		ModelAndView mav = new ModelAndView();
		List<OnetooneDTO> list1 = service.listAll();
		mav.addObject("list1", list1);
		mav.setViewName("onetoone/list1");
		return mav;
	}

	@GetMapping("onetoone/selectOne1")
	public ModelAndView selectOne1(@RequestParam("o_code") String o_code) {
		ModelAndView mav = new ModelAndView();
		OnetooneDTO dto = service.selectOne(o_code);
		mav.addObject("onetoone", dto);
		mav.setViewName("onetoone/selectOne1");
		return mav;
	}

	@GetMapping("onetoone/insert1")
	public ModelAndView insert1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("onetoone/insert1");
		return mav;
	}

	@PostMapping("onetoone/insert1")
	public ModelAndView insert1(OnetooneDTO dto) {
		ModelAndView mav = new ModelAndView();
		service.insert(dto);
		List<OnetooneDTO> list1 = service.listAll();
		mav.addObject("list1", list1);
		mav.setViewName("onetoone/list1");
		return mav;
	}

	@GetMapping("onetoone/update1")
	public ModelAndView update1(@RequestParam("o_code") String o_code) {
		ModelAndView mav = new ModelAndView();
		OnetooneDTO dto = service.selectOne(o_code);
		mav.addObject("onetoone", dto);
		mav.setViewName("onetoone/update1");
		return mav;
	}

	@PostMapping("onetoone/update1")
	public ModelAndView update1(OnetooneDTO dto) {
		System.out.println(dto+"나는 오류종자다.");
		ModelAndView mav = new ModelAndView();
		List<OnetooneDTO> list1 = service.listAll();
		if (dto.getO_title().equals("") || dto.getO_content().equals("")) {
			mav.setViewName("update");
			OnetooneDTO dtoo = service.selectOne(dto.getO_code());
			mav.addObject("onetoone", dtoo);
		} else {
			mav.addObject("list1", list1);
			mav.setViewName("onetoone/list1");
			service.update(dto);

		}
		return mav;
	}
	@GetMapping("onetoone/delete1")
	public ModelAndView delete1(String o_code) {
		service.delete(o_code);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list1",service.listAll());
		mav.setViewName("onetoone/list1");
		return mav;
	}
}
