package ez.en.page.user;

import java.util.Map;

public interface UserService {

	public UserDTO login(UserDTO dto);
	
	public UserDTO adminLogin(UserDTO dto);
	
	public int signup(UserDTO dto);
	
	public String idchk(String id);
	
	public String nickchk(String nick);
	
	public String idFind(UserDTO dto);
	
	public String pwFind(UserDTO dto);
	
	//sjs의 흔적
	//회원정보수정
	public int edit(Map<String, Object> map);
	
	//회원정보 하나 가져오기
	public UserDTO info(Object id);
	
}
