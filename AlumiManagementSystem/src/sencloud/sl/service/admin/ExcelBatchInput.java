package sencloud.sl.service.admin;

import java.io.File;

public interface ExcelBatchInput {
	/**
	 * excel导入的主要逻辑
	 * */
	public String uploadStu(File upload);
	/**
	 * 导入后的消息
	 * */
	public String getFinalMsg();
}
