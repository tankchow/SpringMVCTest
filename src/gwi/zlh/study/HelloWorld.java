package gwi.zlh.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    /**
     * 1. ʹ��RequestMappingע����ӳ�������URL 2. ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ,
     * ����InternalResourceViewResolver��ͼ���������������½��� ͨ��prefix+returnVal+suffix
     * �����ķ�ʽ�õ�ʵ�ʵ�������ͼ��Ȼ���ת������ "/WEB-INF/views/success.jsp"
     * 
     * @return
     */
    @RequestMapping("/helloworld")
    public String helloworld() {
	System.out.println("hello world");
	return "helloWorldSuccess";
    }

    @RequestMapping("/hello")
    public String hello() {
	System.out.println("hello");
	return "helloSuccess";
    }
}