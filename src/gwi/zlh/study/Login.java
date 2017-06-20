package gwi.zlh.study;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gwi.zlh.mapper.UserMapper;
import gwi.zlh.model.User;

@Controller
public class Login {
	private static Logger logger=Logger.getLogger(Login.class);
	
    @RequestMapping("/loginIndex")
    public String loginIndex() {
	System.out.println("System.out.println-loginIndex");		
	logger.fatal("logger.fatal-loginIndex");
	logger.error("logger.error-loginIndex");
	logger.warn("logger.warn-loginIndex");
	logger.info("logger.info-loginIndex");
	logger.debug("logger.debug-loginIndex");
	logger.trace("logger.trace-loginIndex");
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
