package ez.en.page.onetoone;

import java.util.List;

public interface OnetooneService {

	public List<OnetooneDTO> listAll();

	public List<OnetooneDTO> SELECTONE(String id);

	public OnetooneDTO selectOne(int o_code);

	public int insert(OnetooneDTO dto);

	public int update(OnetooneDTO dto);

	public int delete(int o_code);
	
	public int reply(Onetoone_reply onetoone_reply);
	
	public List<Onetoone_reply> getDetail(int o_code);
	
	public Onetoone_reply detailReply(int o_code);
	
	public int replyupdate(Onetoone_reply onetoone_reply);
	
	public int replyDelete(int o_code);

	
	
}
