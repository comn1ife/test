package first.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import first.sample.service.SampleService;

@Controller	//�����������ӿ�ũ�� ���� Ŭ������ ��Ʈ�ѷ���°��� ���
/*�� Ŭ���̾�Ʈ���� ���� ��û�� �ش� �����Ͻ� ������ ȣ���ϰ�, �������� �Բ� ������ ���ִ� Dispatcher ����*/
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());	// �α� ����
	
	@Resource(name="sampleService") //���� ������ ������ ���� ����, �� ������̼��� ���� �ʿ��� ���� �������� ����ϴ� ���̸� �� �� �̸��� "sampleService"
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/openSampleBoardList.do") // ��û URL�� �ǹ�, ����ڰ� ��û�� �ּҰ� �� ������̼ǰ� ���εǾ� �ش� �޼ҵ� ����
	public ModelAndView openSampleBoardList(Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardList"); // ȭ�鿡 ������ jsp ������ �ǹ�
		
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		mv.addObject("list", list);	// ���񽺷����� ����� ModelAndView ��ü�� ��Ƽ� Ŭ���̾�Ʈ�� ����
		
		return mv;
	}
	/*
	@RequestMapping(value="/sample/openSampleList.do")	// DispatcherServlet�� � ��Ʈ�ѷ��� �޼��尡 ȣ��Ǿ���ϴ��� ����
	public ModelAndView openSampleList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");	// �����ںκп� ��Ʈ�ѷ� ������ ������ view ����������
		log.debug("���ͼ�Ʈ�׽�Ʈ");	//log4j ���� Ȯ�ο�
		
		return mv;
	}
	*/
}
