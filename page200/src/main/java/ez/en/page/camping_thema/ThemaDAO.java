package ez.en.page.camping_thema;

import java.util.List;

public interface ThemaDAO {
	
	public ThemaDTO selectOne(String thema_code);
	public List<ThemaDTO> list();

}
