package sencloud.sl.util;

public class PageUtil{
	//分页用到的基本两个参数：1.总的记录条数  2.每页的记录条数
	//public static final Integer DEFAULT_CURRENT=1; //默认显示第一页
	public static final Integer DEFAULT_PAGE_NUM=40;//默认显示40条记录
	
	protected Integer pageFirRecord=0;	//当前页第一条记录
	protected Integer currentPage=1;	//当前页数
	protected Integer totalPages;	//总页数
	protected Integer totalRecord;	//总记录数
	protected Integer showRecordNum=DEFAULT_PAGE_NUM;	//每页显示记录数
	protected Integer showPageNum;	//当前页显示的记录数量
	protected Integer prePage=1;
	protected Integer nexePage=1;
	public PageUtil(){
		
	}
	
	public PageUtil(Integer currentPage,Integer totalRecord){//两个参数，一个是当前页数，一个是总页数
		
		
		this.setTotalRecord(totalRecord);//调用set()方法来将参数赋值
		this.setTotalPages();
		this.setCurrentPage(currentPage);
		
		this.setShowPageNum();
		this.setPageFirRecord();
		this.setPrePage();
		this.setNexePage();
	}
	/**
	 * 重载
	 * @param currentPage
	 * @param totalRecord
	 * @param showRecordNum
	 */
	public PageUtil(Integer currentPage,Integer totalRecord,int showRecordNum){//多了一个显示当前页的记录条数
		
		this.setTotalRecord(totalRecord);
		this.setShowRecordNum(showRecordNum);
		this.setTotalPages();
		this.setCurrentPage(currentPage);
		
		this.setShowPageNum();
		this.setPageFirRecord();
		
		this.setPrePage();	//计算前一页页码
		this.setNexePage();	//计算下一页页码
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage() {//设置前一页的页码
		this.prePage = currentPage-1;//为当前页数减1
	}
	
	
	public Integer getNexePage() {
		return nexePage;
	}
	public void setNexePage() {
		
		if(currentPage==totalPages){  //如果当前页码为总页码，即最后一页
			this.nexePage = 0;		//返回0
		}else{
			this.nexePage = currentPage+1;//当前页加1
		}
		if(totalPages==0){		//如果总页数为0，怎么返回0；
			this.nexePage = 0;
		}
	}
	
	
	public Integer getShowPageNum() {//返回当前页显示的记录数量
		return showPageNum;
	}
	public void setShowPageNum() {				//当前页显示的记录数量
		if(currentPage*showRecordNum-totalRecord>0){//当前页数*每页显示的条数—总的记录条数>0 表示现在已经是最后一页了
			this.showPageNum = totalRecord-(currentPage-1)*showRecordNum;
		}else{
			this.showPageNum=showRecordNum;
		}
		
	}
	
	
	public Integer getShowRecordNum() {//返回每页的记录条数
		return showRecordNum;
	}
	public void setShowRecordNum(Integer showRecordNum) {
		this.showRecordNum = showRecordNum;
	}
	
	
	public Integer getTotalPages() {//返回总的页数
		return totalPages;
	}
	public void setTotalPages() {		//计算总页数
		if(totalRecord%showRecordNum==0){
			this.totalPages = totalRecord/showRecordNum;
		}else{
			this.totalPages = totalRecord/showRecordNum+1;
		}
		
	}
	
	
	public Integer getTotalRecord() {//返回总的记录条数
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	
	public Integer getCurrentPage() {//返回当前的页数
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		
		if(currentPage==0||currentPage<0){
			currentPage=1;
		}
		if(currentPage>totalPages&&totalPages!=0){				//2010年8月27日增加，
			this.currentPage=totalPages;		//当前页大于总页数时为总页数,并且保证不存在记录时不出错，即totalPages!=0
		}else if(totalPages==0){
			this.currentPage=1;
		}else{
			this.currentPage = currentPage;
		}
	}
	
	
	public void setPageFirRecord() {			//第一条记录所在集合的标号，比实际排数少一
		this.pageFirRecord = (getCurrentPage()-1)*showRecordNum;//第一条记录为当前页的前一页*每页显示的记录数
	}
	public Integer getPageFirRecord() {//返回第一条记录
		return pageFirRecord;
	}
	
	
}
