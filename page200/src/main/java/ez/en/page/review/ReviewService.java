package ez.en.page.review;

import java.util.List;
import java.util.Map;

import ez.en.page.camping.CampingDTO;
import ez.en.page.user.UserDTO;

public interface ReviewService {

//	 ★★★ 리뷰전체목록
	public List<ReviewDTO> listAll();

//	 ★★★ 리뷰상세목록
	public ReviewDTO selectOne(String r_code);

//	 ★★★ 캠핑장 이름 조회
	public CampingDTO campingName(String rev_code);

//	 ★★★ 리뷰 작성
	public int insert(ReviewDTO dto);

//	 ★★★ 리뷰 작성
	public int update(ReviewDTO dto);

//	 ★★★ 리뷰 삭제
	public int delete(String r_code);
	
//  ★★★ 캠핑장 예약자 이름 조회
	public UserDTO userNick(String rev_code);

//  ★★★ 캠핑장 리뷰갯수 조회
	public int reviewCount(String cam_code);
}
