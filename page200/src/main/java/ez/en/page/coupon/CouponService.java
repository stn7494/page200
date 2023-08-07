package ez.en.page.coupon;

import java.util.List;

public interface CouponService {

	/**
	 * 쿠폰 전체조회
	 * @return
	 */
	public List<CouponDTO> listAll();

	/**
	 * 쿠폰 선택조회
	 * @param cp_code
	 * @return
	 */
	public CouponDTO selectOne(String cp_code);
	
	/**
	 * 쿠폰 수정
	 * @param cp_code
	 * @return
	 */
	public int update(CouponDTO dto);

	/**
	 * 쿠폰 추가
	 * @param dto
	 * @return
	 */
	public int insert(CouponDTO dto);
	
	/**
	 * 쿠폰 삭제
	 * @param cp_code
	 * @return
	 */
	public int delete(String cp_code);
	/**
	 * 차월 생일 회원 조회
	 * @param birth
	 * @return
	 */
	public int birthlist(String birth);
	/**
	 * 쿠폰수량 감소
	 * @param cp_code
	 * @return
	 */
	public int updatenum(String cp_code);
}
