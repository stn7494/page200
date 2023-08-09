package ez.en.page.camping;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ez.en.page.domain.Criteria;

@Service
public class CampingServiceImpl implements CampingService {

	@Inject
	private CampingDAO campingDAO;
	
	//캠핑장 등록
	@Override
	public void register(CampingDTO campingDTO) {
		campingDAO.register(campingDTO);
	}
	
	//캠핑장 수정
	@Override
	public void modify(CampingDTO campingDTO) {
		campingDAO.modify(campingDTO);
	}

	//캠핑장 삭제
	@Override
	public void remove(String cam_code) {
		campingDAO.remove(cam_code);
	}

	//캠핑장 전체 목록
	@Override
	public List<CampingDTO> list() {
		return campingDAO.list();
	}

	//캠핑장 상세페이지
	@Override
	public CampingDTO detail(String cam_code) {
		return campingDAO.detail(cam_code);
	}

	@Override
	public List<CampingDTO> listCriteria(Criteria cri) throws Exception {
		return campingDAO.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return campingDAO.countPaging(cri);
	}

//	//캠핑장 예약 정보
//	@Override
//	public Map selectAll(Map<String, Object> map) {
//		return campingDAO.selectAll(map);
//	}

}
