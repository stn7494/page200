package ez.en.page.admin.camping;

import java.util.List;
import java.util.Map;

import ez.en.page.domain.Criteria;
import ez.en.page.domain.SearchCriteria;

public interface AdminCampingService {
	
	//캠핑장 등록
	public void register(AdminCampingDTO campingDTO);
	//캠핑장 수정
	public void modify(AdminCampingDTO campingDTO);
	//캠핑장 삭제
	public void remove(String cam_code);
	//캠핑장 전체 조회
	public List<AdminCampingDTO> list();
	//캠핑장 상세페이지
	public AdminCampingDTO detail(String cam_code);
	
	public List<AdminCampingDTO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	//캠핑장 검색
	public List<AdminCampingDTO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
//	//캠핑장 상세페이지 정보 조회
//	public Map selectAll(Map<String, Object> map);

}
