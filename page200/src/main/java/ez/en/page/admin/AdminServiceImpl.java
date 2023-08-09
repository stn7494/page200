package ez.en.page.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ez.en.page.user.UserDTO;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private AdminDAO dao;
	
	@Override
	public UserDTO adminLogin(UserDTO dto) {
		// TODO Auto-generated method stub
		return dao.adminLogin(dto);
	}
	
	@Override
	public List<UserDTO> userList() {
		// TODO Auto-generated method stub
		return dao.userList();
	}

	@Override
	public int userStop(List<String> userList) {
		// TODO Auto-generated method stub
		return dao.userStop(userList);
	}

}
