package ez.en.page.camping;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CampingDAOImpl implements CampingDAO {
	
	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "ez.en.page.campingMapper.";
	
	//캠핑장 등록
	@Override
	public void register(CampingDTO campingDTO) {
		sqlSession.insert(namespace+"register", campingDTO);
	}

	//캠핑장 수정
	@Override
	public void modify(CampingDTO campingDTO) {
		sqlSession.update(namespace+"modify", campingDTO);
	}

	//캠핑장 삭제
	@Override
	public void remove(String cam_code) {
		sqlSession.delete(namespace+"remove", cam_code);
	}

	//캠핑장 전체 조회
	@Override
	public List<CampingDTO> list() {
		return sqlSession.selectList(namespace+"list");
	}

	//캠핑장 상세페이지
	@Override
	public CampingDTO detail(String cam_code) {
		return sqlSession.selectOne(namespace+"detail", cam_code);
	}

//	//캠핑장 예약정보
//	@Override
//	public Map selectAll(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
