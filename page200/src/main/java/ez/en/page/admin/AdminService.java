package ez.en.page.admin;

import java.util.List;

import ez.en.page.user.UserDTO;

public interface AdminService {

	public List<UserDTO> userList();
	
	public int userStop(String id);
	
}
