package first.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import first.common.dao.AbstractDAO;

@Repository("sampleDAO")	// 이클래스가 DAO임을 선언하고 이름은 "sampleDAO"로 사용
public class SampleDAO extends AbstractDAO{
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
	}
	
}
