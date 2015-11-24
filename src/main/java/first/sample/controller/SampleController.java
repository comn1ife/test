package first.sample.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller	//�����������ӿ�ũ�� ���� Ŭ������ ��Ʈ�ѷ���°��� ���
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());	// �α� ����
	
	@RequestMapping(value="/sample/openSampleList.do")	// DispatcherServlet�� � ��Ʈ�ѷ��� �޼��尡 ȣ��Ǿ���ϴ��� ����
	public ModelAndView openSampleList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");	// �����ںκп� ��Ʈ�ѷ� ������ ������ view ����������
		log.debug("���ͼ�Ʈ�׽�Ʈ");	//log4j ���� Ȯ�ο�
		
		return mv;
	}
}
