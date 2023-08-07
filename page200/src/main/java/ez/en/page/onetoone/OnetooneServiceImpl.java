package ez.en.page.onetoone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnetooneServiceImpl implements OnetooneService {
	
	@Autowired
	private OnetooneDAOImpl dao;

	@Override
	public List<OnetooneDTO> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public int insert(OnetooneDTO dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(OnetooneDTO dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public OnetooneDTO selectOne(String o_code) {
		// TODO Auto-generated method stub
		return dao.selectOne(o_code);
	}

	@Override
	public int delete(String o_code) {
		// TODO Auto-generated method stub
		return dao.delete(o_code);
	}

}
