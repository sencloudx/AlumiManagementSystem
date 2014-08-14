package sencloud.sl.service.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.CommonDAO;
import sencloud.sl.service.admin.CommonService;


public class CommonServiceImpl implements CommonService{
	private CommonDAO commonDAO;
	
	public CommonDAO getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	public <T> List<T> findAll(Class<T> entityclass) {
		return (List<T>) commonDAO.findAll(entityclass);
	}

	@Override
	public <T> T findById(Class<T> entityclass, Integer id) {
		if(id == null){
			return null;
		}else{
			return (T) commonDAO.findById(entityclass, id);
		}
	}

	@Override
	public <T> void remove(T entity) {
		commonDAO.remove(entity);
	}

	@Override
	public <T> void sava(T entity) {
		commonDAO.sava(entity);
	}

	@Override
	public <T> void update(T entity) {
		commonDAO.update(entity);
	}	
}
