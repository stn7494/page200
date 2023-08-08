package ez.en.page.coupon;

import java.util.List;

import ez.en.page.my_coupon.My_couponDTO;

public interface CouponDAO {

//	쿠폰 전체조회
	public List<CouponDTO> listAll();
//	쿠폰 선택조회
	public CouponDTO selectOne(String cp_code);
//	쿠폰 수정
	public int update(CouponDTO dto);
//	쿠폰 추가
	public int insert(CouponDTO dto);
//	쿠폰삭제
	public int delete(String cp_code);
//	차월 생일 회원 조회
	public int birthlist(String birth);
//	쿠폰수량 감소
	public int updatenum(String cp_code);
//	쿠폰발급
	public int couponissue(My_couponDTO mydto);
}
