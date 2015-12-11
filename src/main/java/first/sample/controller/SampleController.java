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
/*웹 클라이언트에서 들어온 요청을 해당 비지니스 로직을 호출하고, 수행결과와 함께 응답을 해주는 Dispatcher 역할*/
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());	// 로그 선언
	
	@Resource(name="sampleService") //서비스 영역의 접근을 위한 선언, 이 어노테이션을 통해 필요한 빈을 수동으로 등록하는 것이며 그 빈 이름이 "sampleService"
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/openSampleBoardList.do") // 요청 URL을 의미, 사용자가 요청한 주소가 이 어노테이션과 매핑되어 해당 메소드 실행
	public ModelAndView openSampleBoardList(Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/sample/boardList"); // 화면에 보여줄 jsp 파일을 의미
		
		List<Map<String, Object>> list = sampleService.selectBoardList(commandMap);
		mv.addObject("list", list);	// 서비스로직의 결과를 ModelAndView 객체에 담아서 클라이언트에 전송
		
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
