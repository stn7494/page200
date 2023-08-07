package ez.en.page.onetoone;

import java.util.List;

public interface OnetooneDAO {

	public List<OnetooneDTO> listAll();
	
	public int insert(OnetooneDTO dto);
	
	public int update(OnetooneDTO dto);
	
	public OnetooneDTO selectOne(String o_code);
	
	public int delete(String o_code);
	
	
}
