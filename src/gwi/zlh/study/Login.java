package gwi.zlh.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gwi.zlh.mapper.UserMapper;
import gwi.zlh.model.User;

@Controller
public class Login {
    @RequestMapping("/loginIndex")
    public String loginIndex() {
	System.out.println("loginIndex");
	return "loginIndex";
    }

    @Autowired
    UserMapper userDao;

    @RequestMapping("/login")

    public String login(String username, String password) {
	System.out.println("login");
	User user = userDao.selectByPrimaryKey(username);
	if (user == null)
	    return "loginFail";
	if (user.getUserid() == username && user.getPassword() == password) {
	    return "loginSeccess";
	} else {
	    return "loginFail";
	}

    }
}
