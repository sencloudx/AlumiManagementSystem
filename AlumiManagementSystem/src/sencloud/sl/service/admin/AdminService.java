package sencloud.sl.service.admin;

import java.util.List;

import sencloud.sl.entity.Admin;


public interface AdminService {
	/**
	 * 获取普通管理员列表
	 * */
	public List<Admin> getList();
	/**
	 * 添加管理员
	 * */
	public void addAdmin(String adminNum, String adminPw, String idStr);
	/**
	 * 删除
	 * */
	public void delete(String idStr);
	/**
	 * 根据id获取
	 * */
	public Admin getAdminById(int id);
	/**
	 * 进行更新
	 * */
	public void update(int id, String adminNum, String adminPw);
}
