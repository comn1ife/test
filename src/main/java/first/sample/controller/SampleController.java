package first.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import first.sample.service.SampleService;

@Controller	//스프링프레임워크에 현재 클래스가 컨트롤러라는것을 명시
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());	// 로그 선언
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/openSampleBoardList.do")
	public ModelAndView openSampleBoardList(Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardList");
		
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		mv.addObject("list", list);
		
		return mv;
	}
	/*
	@RequestMapping(value="/sample/openSampleList.do")	// DispatcherServlet이 어떤 컨트롤러의 메서드가 호출되어야하는지 결정
	public ModelAndView openSampleList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("");	// 생성자부분에 컨트롤러 실행후 보여줄 view 설정가능함
		log.debug("인터셉트테스트");	//log4j 동작 확인용
		
		return mv;
	}
	*/
}
