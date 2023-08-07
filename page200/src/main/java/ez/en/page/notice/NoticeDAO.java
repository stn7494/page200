package ez.en.page.notice;

import java.util.List;

public interface NoticeDAO {
	
	public List<NoticeDTO> listAll();

	public int insert(NoticeDTO dto);

	public int update(NoticeDTO dto);

	public NoticeDTO selectOne(String n_code);

	public int delete(String n_code);

}
