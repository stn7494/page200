package ez.en.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ez.en.page.domain.Criteria;
import ez.en.page.jjim.JjimDTO;
import ez.en.page.mypage.MypageDAO;
import ez.en.page.reservation.ReservationDTO;
import ez.en.page.review.ReviewDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MypageDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MypageDAOTest.class);
	
	@Autowired
	private MypageDAO dao;
	
//	@Test
//	public void testreviewListPage() throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		int page = 3;
//		String id = "user01";
//		String r_code = "r000";
//		map.put("r_code", r_code);
//		map.put("id", id);
//		map.put("page", page);
//		List<ReviewDTO> list = dao.reviewlistPage(map);
//		for (ReviewDTO reviewDTO : list) {
//			logger.info(reviewDTO.getR_code() + ":" + reviewDTO.getRev_code());
//		}
//	}
//	@Test
//	public void testListCriteria() throws Exception {
//		Criteria cri = new Criteria();
//		cri.setId("user01");
//		cri.setPage(2);
//		cri.setPerPageNum(20);
//		
//		List<JjimDTO> list = dao.jjimlistCriteria(cri);
//		
//		for (JjimDTO jjimDTO : list) {
//			logger.info(jjimDTO.getJ_num() + ":" + jjimDTO.getCam_name());
//		}
//	}

}
