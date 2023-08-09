package ez.en.page.admin;

import java.util.List;

import ez.en.page.user.UserDTO;

public interface AdminDAO {
	
	public UserDTO adminLogin(UserDTO dto);
	
	public List<UserDTO> userList();
	
	public int userStop(List<String> userList);
	
}
