package ez.en.page.mypage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ez.en.page.coupon.CouponDTO;
import ez.en.page.domain.Criteria;
import ez.en.page.jjim.JjimDTO;
import ez.en.page.reservation.ReservationDTO;
import ez.en.page.review.ReviewDTO;
import ez.en.page.user.UserDTO;

@Repository
public class MypageDAOImpl implements MypageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "ez.en.page.mypageMapper.";
	
	@Override
	public List<ReservationDTO> revlist(Object id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"revlist",id);
	}

	@Override
	public int revdelete(Object revcode) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"revdelete", revcode);
	}

	@Override
	public Map<String, Object> revdetail2(Object sitecode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"revdetail2", sitecode);
	}

	@Override
	public List<JjimDTO> jjimlist(Object id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"jjimlist", id);
	}

	@Override
	public List<ReviewDTO> reviewlist(Object id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"reviewlist", id);
	}

	@Override
	public List<CouponDTO> couponlist(Object id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"couponlist", id);
	}

	@Override
	public int edit(UserDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"edit", dto);
	}

	@Override
	public UserDTO info(Object id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"info", id);
	}

	@Override
	public int editpassword(UserDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"editpassword", dto);
	}

	@Override
	public List<ReservationDTO> revlistPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		int page = (int)(map.get("page"));
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return sqlSession.selectList(namespace+"revlistPage", map);
	}

	@Override
	public List<ReservationDTO> revlistCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"revlistCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"countPaging", cri);
	}
	// 여기부터 밑에 전부다 =====================================
	@Override
	public List<JjimDTO> jjimlistPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"jjimlistPage", map);
	}

	@Override
	public List<JjimDTO> jjimlistCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"jjimlistCriteria", cri);
	}

	@Override
	public int jjimcountPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"jjimcountPaging", cri);
	}

	@Override
	public List<ReviewDTO> reviewlistPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"reviewlistPage", map);
	}

	@Override
	public List<ReviewDTO> reviewlistCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"reviewlistCriteria", cri);
	}

	@Override
	public int reviewcountPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"reviewcountPaging", cri);
	}

}
