package ez.en.page.camping_region;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RegionDAOImpl implements RegionDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "ez.en.page.regionMapper.";
	
	@Override
	public RegionDTO selectOne(String region_code) {
		return sqlSession.selectOne(namespace+"selectOne", region_code);
	}

	@Override
	public List<RegionDTO> list() {
		return sqlSession.selectList(namespace+"list");
	}

}
