package ez.en.page.mypage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ez.en.page.coupon.CouponDTO;
import ez.en.page.domain.Criteria;
import ez.en.page.jjim.JjimDTO;
import ez.en.page.reservation.ReservationDTO;
import ez.en.page.review.ReviewDTO;
import ez.en.page.user.UserDTO;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	private MypageDAO dao;
	
	@Override
	public List<ReservationDTO> revlist(Object id) {
		// TODO Auto-generated method stub
		return dao.revlist(id);
	}

	@Override
	public int revdelete(Object revcode) {
		// TODO Auto-generated method stub
		return dao.revdelete(revcode);
	}

	@Override
	public Map<String, Object> revdetail2(Object sitecode) {
		// TODO Auto-generated method stub
		return dao.revdetail2(sitecode);
	}

	@Override
	public List<JjimDTO> jjimlist(Object id) {
		// TODO Auto-generated method stub
		return dao.jjimlist(id);
	}

	@Override
	public List<ReviewDTO> reviewlist(Object id) {
		// TODO Auto-generated method stub
		return dao.reviewlist(id);
	}

	@Override
	public List<CouponDTO> couponlist(Object id) {
		// TODO Auto-generated method stub
		return dao.couponlist(id);
	}

	@Override
	public int edit(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.edit(dto);
	}

	@Override
	public UserDTO info(Object id) {
		// TODO Auto-generated method stub
		return dao.info(id);
	}

	@Override
	public int editpassword(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.editpassword(dto);
	}

	@Override
	public List<ReservationDTO> revlistCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.revlistCriteria(cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}
	// 밑에 전부 ===================================
	@Override
	public List<JjimDTO> jjimlistCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.jjimlistCriteria(cri);
	}

	@Override
	public int jjimlistcountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.jjimcountPaging(cri);
	}

	@Override
	public List<ReviewDTO> reviewlistCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewlistCriteria(cri);
	}

	@Override
	public int reviewcountPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewcountPaging(cri);
	}

}
