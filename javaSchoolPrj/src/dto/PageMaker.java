package dto;

public class PageMaker {
	private int pageSize=10;
	private int startPage;
	private int endPage;
	private int currPage=1;
	private int start;
	private int totalCount;
	private boolean prev;
	private boolean next;
	
	public PageMaker(int currPage, int totalCount) {
		this.currPage=currPage;
		this.totalCount=totalCount;
		start=(currPage-1)*pageSize;// 페이지의 시작 레코드
		endPage=(int)(Math.ceil(currPage/(double)pageSize)*pageSize);
		startPage=(endPage-pageSize)+1;
		int totalPage=(int)(Math.ceil(totalCount/(double)pageSize));
		if(endPage>totalPage)endPage=totalPage;
		prev=startPage==1? false:true;
		next=endPage<totalPage?true:false;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public int getStart() {
		return start;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}
}
