package first.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import first.common.dao.AbstractDAO;

@Repository("sampleDAO")	// ��Ŭ������ DAO���� �����ϰ� �̸��� "sampleDAO"�� ���
public class SampleDAO extends AbstractDAO{
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
	}
	
}
