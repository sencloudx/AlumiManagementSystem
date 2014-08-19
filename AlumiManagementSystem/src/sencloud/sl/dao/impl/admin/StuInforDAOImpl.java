package sencloud.sl.dao.impl.admin;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import sencloud.sl.dao.admin.StuInforDAO;
import sencloud.sl.entity.StuInfor;


@SuppressWarnings("unchecked")
public class StuInforDAOImpl extends GenericHibernateDAO<StuInfor> implements StuInforDAO {

	public StuInforDAOImpl() {
		super(StuInfor.class);
	}

	@Override
	public String makePersistence(StuInfor stuInfor) {
		this.getHibernateTemplate().save(stuInfor);
		return stuInfor.getStuName();
	}

	@Override
	public List<StuInfor> getStuInforListByHQL(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<StuInfor> getStuInforList(final Integer PageFirRecord, final Integer PageNum,String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId) {
		final String hql = getHQL(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
		List<StuInfor> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
		    throws HibernateException, SQLException 
		    {
				Query query = session.createQuery(hql);
				query.setFirstResult(PageFirRecord);
				query.setMaxResults(PageNum);
				List list = query.list();
				return list;
			}
			});
			return list.size()>0?list:null;	
	}

	@Override
	public int getSubNums(String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId) {
		System.out.println("得到的hql语句为 = "+ getHQL(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId));
		return this.getHibernateTemplate().find(getHQL(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId)).size();
	}
	
	public String getHQL(String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId){
		System.out.println("city = "+city + "  "+sourceCity);
		String hql = "from StuInfor as stu";
		if("0".equals(showType)){										//默认显示正常的学生
			if(hql.contains("where")){	
				hql = hql +" and stu.deleteType = '1'";
			}else{
				hql = hql +" where stu.deleteType = '1'";
			}
		}else if("回收站".equals(showType)){
			System.out.println(hql.contains("where"));
			if(hql.contains("where")){	
				hql = hql +" and stu.deleteType = '0'";
			}else{
				hql = hql +" where stu.deleteType = '0'";
			}
		}
		if(city!= null&& !"0".equals(city)){
			if(hql.contains("where")){									//hql中包含where
				hql = hql +" and stu.stuWorkAddress like '%"+city+"%'";
			}else{
				hql = hql +" where stu.stuWorkAddress like '%"+city+"%'";
			}
			
		}
		if(!"0".equals(major)&&major!= null){
			//这里要注意专业可能会有多个
			//首先看传过来的major中是否包含-，即是否是多个
			if(major.contains("-")){
				String[] majors = major.split("-");
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i< majors.length; i++){
					if(i>= 1&& i != (majors.length-1)){
						sb.append("or stu.major.majorName = '"+majors[i]+"'");
					}else if(i>= 1&& i == (majors.length-1)){
						sb.append("or stu.major.majorName = '"+majors[i]+"')").toString();
					}else{
						if(hql.contains("where")){
							sb.append(" and (stu.major.majorName = '"+majors[i]+"'");
						}else{
							sb.append(" where (stu.major.majorName = '"+majors[i]+"'");
						}
						
					}
				}
				hql = hql + sb.toString();
				//System.out.println("qqqqqqq====="+hql);
			}else{
				if(hql.contains("where")){	
					hql = hql +" and stu.major.majorName = '"+major+"'";
				}else{
					hql = hql +" where stu.major.majorName = '"+major+"'";
				}
			}
		}
		if(!"0".equals(address)){
			if(hql.contains("where")){	
				hql = hql +" and stu.stuWorkAddress like '%"+address+"%'";
			}else{
				hql = hql +" where stu.stuWorkAddress like '%"+address+"%'";
			}
		}
		if(classesId != 0){
			if(hql.contains("where")){	
				hql = hql +" and stu.classes.classesId = "+classesId+"";
			}else{
				hql = hql +" where stu.classes.classesId = "+classesId+"";
			}
		}
		if(docProtitleId != 0){
			if(hql.contains("where")){	
				hql = hql +" and stu.docProtitle.docProtitleId = "+docProtitleId+"";
			}else{
				hql = hql +" where stu.docProtitle.docProtitleId = "+docProtitleId+"";
			}
		}
		if(teaProtitleId != 0){
			if(hql.contains("where")){	
				hql = hql +" and stu.teaProtitle.teaProtitleId = "+teaProtitleId+"";
			}else{
				hql = hql +" where stu.teaProtitle.teaProtitleId = "+teaProtitleId+"";
			}
		}
		if(!"0".equals(sourceCity)&& sourceCity!=null){
			System.out.println("生源查找===============================================");
			if(hql.contains("where")){	
				hql = hql +" and stu.stuBirth like '%"+sourceCity+"%'";
			}else{
				hql = hql +" where stu.stuBirth like '%"+sourceCity+"%'";
			}
		}
		if(!"0".equals(searchContext) ){							//进行查询
			if(hql.contains("where")){	
				if(searchType == 0){								//按姓名进行查找
					//System.out.println("查找的内容 =  "+searchContext);
					hql = hql + " and stu.stuName like '%"+searchContext+"%'";
				}else if(searchType == 1){							//按学号进行查找
					hql = hql + " and stu.stuNum like '%"+searchContext+"%'";
				}else if(searchType == 2){							//按专业进行查找
					hql = hql + " and stu.major.majorName like '%"+searchContext+"%'";
				}else if(searchType == 4){							//按省市进行查找
					hql = hql + " and stu.stuWorkAddress like '%"+searchContext+"%'";
				}
			}else{
				if(searchType == 0){								//按姓名进行查找
					hql = hql + " where stu.stuName like '%"+searchContext+"%'";
				}else if(searchType == 1){							//按学号进行查找
					hql = hql + " where stu.stuNum like '%"+searchContext+"%'";
				}else if(searchType == 2){							//按专业进行查找
					hql = hql + " where stu.major.majorName like '%"+searchContext+"%'";
				}else if(searchType == 4){							//按省市进行查找
					hql = hql + " where stu.stuWorkAddress like '%"+searchContext+"%'";
				}
			}
		}
		return hql;
	}
	
	@Override
	public StuInfor getInforById(int id) {
		return (StuInfor) this.getHibernateTemplate().get(StuInfor.class, id);
	}

	@Override
	public void delete(int id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(StuInfor.class, id));
	}

	@Override
	public void update(StuInfor stuInfor) {
		this.getHibernateTemplate().update(stuInfor);
	}

	@Override
	public StuInfor getStuInforByNum(String stuNum) {
		String hql = "from StuInfor as stu where stu.stuNum = '"+stuNum+"'";
		List<StuInfor> stuInforList = findListByHQL(hql);
		System.out.println(stuInforList);
		if(stuInforList == null|| stuInforList.size() == 0){
			return null;
		}else{
			return stuInforList.get(0);
		}
	}

	@Override
	public int makePersistenceBackId(StuInfor stuInfor) {
		this.getHibernateTemplate().save(stuInfor);
		return stuInfor.getStuId();
	}

}
