package ez.en.page.onetoone;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OnetooneDAOImpl implements OnetooneDAO {
	private static final String namespace = "ez.en.page.onetooneMapper.";
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public List<OnetooneDTO> listAll() {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + "list1");
	}

	@Override
	public int insert(OnetooneDTO dto) {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + "insert1",dto);
	}

	@Override
	public int update(OnetooneDTO dto) {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + "update1",dto);
	}

	@Override
	public OnetooneDTO selectOne(int o_code) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + "selectOne1",o_code);
	}

	@Override
	public int delete(int o_code) {
		// TODO Auto-generated method stub
		return sqlsession.delete(namespace + "delete1",o_code);
	}

}
