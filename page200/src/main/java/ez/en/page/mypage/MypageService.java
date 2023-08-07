package ez.en.page.mypage;

import java.util.List;
import java.util.Map;

import ez.en.page.coupon.CouponDTO;
import ez.en.page.domain.Criteria;
import ez.en.page.jjim.JjimDTO;
import ez.en.page.reservation.ReservationDTO;
import ez.en.page.review.ReviewDTO;
import ez.en.page.user.UserDTO;

public interface MypageService {
	
//	예약 전체조회
	public List<ReservationDTO> revlist(Object id);
//	예약 페이징
	public List<ReservationDTO> revlistCriteria(Criteria cri)throws Exception;
//	예약 페이징 페이지번호
	public int countPaging(Criteria cri)throws Exception;
//	예약 취소
	public int revdelete(Object revcode);
//	예약 상세조회2
	public Map<String, Object> revdetail2(Object sitecode);
//	내 찜목록
	public List<JjimDTO> jjimlist(Object id);
//	내 찜목록 페이징 ==============================
	public List<JjimDTO> jjimlistCriteria(Criteria cri)throws Exception;
//	내 찜목록 페이지번호 ========================
	public int jjimlistcountCriteria(Criteria cri)throws Exception;
//	내 리뷰목록 ============================
	public List<ReviewDTO> reviewlist(Object id);
//	내 쿠폰함
	public List<CouponDTO> couponlist(Object id);
//	회원정보수정
	public int edit(UserDTO dto);
//	회원정보 하나 가져오기
	public UserDTO info(Object id);
//	비밀번호 수정
	public int editpassword(UserDTO dto);
}
