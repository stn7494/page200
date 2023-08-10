package ez.en.page.onetoone;

import java.util.List;

public interface OnetooneService {

	public List<OnetooneDTO> listAll();

	public List<OnetooneDTO> SELECTONE(String id);

	public OnetooneDTO selectOne(int o_code);

	public int insert(OnetooneDTO dto);

	public int update(OnetooneDTO dto);

	public int delete(int o_code);
	
	
}
