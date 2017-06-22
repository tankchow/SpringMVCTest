package gwi.zlh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gwi.zlh.mapper.UserMapper;
import gwi.zlh.model.User;

@Controller
public class Regist {
    @RequestMapping("/registIndex")
    public String registIndex(String username, String password) {
	System.out.println("registIndex" + "--" + username + "--" + password);
	return "registIndex";
    }

    @Autowired
    UserMapper userDao;

    @RequestMapping("/regist")
    public String regist(String username, String password) {
	System.out.println("Regist" + "--" + username + "--" + password);
	if (username == null || password == "") {
	    System.out.println("�û����������벻��Ϊ��");
	    return "registFail";
	}
	User user = userDao.selectByPrimaryKey(username);
	if (user != null) {
	    System.out.println("�û�����ռ��");
	    return "registFail";
	} else {
	    User regUser = new User();
	    regUser.setUserid(username);
	    regUser.setPassword(password);
	    // user.
	    int result = userDao.insert(regUser);
	    System.out.println(result);
	    return "registSeccess";
	}
    }
}
