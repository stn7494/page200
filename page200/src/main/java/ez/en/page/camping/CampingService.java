package ez.en.page.camping;

import java.util.List;
import java.util.Map;

import ez.en.page.domain.Criteria;
import ez.en.page.domain.SearchCriteria;

public interface CampingService {
	
	//캠핑장 등록
	public void register(CampingDTO campingDTO);
	//캠핑장 수정
	public void modify(CampingDTO campingDTO);
	//캠핑장 삭제
	public void remove(String cam_code);
	//캠핑장 전체 조회
	public List<CampingDTO> list();
	//캠핑장 상세페이지
	public CampingDTO detail(String cam_code);
	
	public List<CampingDTO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	//캠핑장 검색
	public List<CampingDTO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
//	//캠핑장 상세페이지 정보 조회
//	public Map selectAll(Map<String, Object> map);

}
