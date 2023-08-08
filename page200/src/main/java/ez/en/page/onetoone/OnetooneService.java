package ez.en.page.onetoone;

import java.util.List;

public interface OnetooneService {
	
	public List<OnetooneDTO> listAll();
	
	public int insert(OnetooneDTO dto);
	
	public int update(OnetooneDTO dto);
	
	public OnetooneDTO selectOne(int o_code);
	
	public int delete(int o_code);

}
