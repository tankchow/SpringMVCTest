package gwi.zlh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gwi.zlh.mapper.UserMapper;
import gwi.zlh.model.User;

@Controller
public class Login {
	// ����ʹ��log4j
	// private static Logger logger=Logger.getLogger(Login.class);

	// ʹ��slf4j
	// �����slf4j+log4j��ֻҪ��log4j�Ļ����ϣ����slf4j-log4j12-1.7.25.jar
	// �����slf4j+logback��ֻҪ��logback.xml����srcĿ¼�£�����Ӷ�Ӧ��logback��jar��
	private static Logger logger = LoggerFactory.getLogger(Login.class);

	@RequestMapping("/loginIndex")
	public String loginIndex() {
		System.out.println("System.out.println-loginIndex");
		// logger.fatal("logger.fatal-loginIndex");//--log4j ����
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
