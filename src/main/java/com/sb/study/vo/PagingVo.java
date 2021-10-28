package com.sb.study.vo;

public class PagingVo {
	
	//nowPage = 현재페이지, startPage = 시작페이지, endPage = 끝 페이지, total = 게시글 총 갯수
	//cntPerPage = 페이지당 글 갯수, lastPage = 마지막 페이지, start, end = 쿼리에서 쓸 start,end
	private int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
	private int cntPage = 5;	//현재를 포함한 5개의 페이지를 이동할수있게 함
	
	public PagingVo() {	//매개변수가 없을때 생성자
	}
	public PagingVo(int total, int nowPage, int cntPerPage) {	//매개변수로 값이 들어올때 객체 생성시
		setNowPage(nowPage);	//현재페이지 설정
		setCntPerPage(cntPerPage);	//페이지당 글 갯수
		setTotal(total);	//총 갯수
		calcLastPage(getTotal(), getCntPerPage());	//총 갯수와 페이지당 글 갯수로 마지막 페이지 계산
		calcStartEndPage(getNowPage(), cntPage);	//현재 페이지와 목록페이지의 갯수로 시작과 끝 페이지 계산
		calcStartEnd(getNowPage(), getCntPerPage());	//현재 페이지와 글의 갯수로 쿼리에서 사용할 시작, 끝 계산
	}
	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
		//총갯수를 페이지당 글 갯수로 나눈 실수값을 ceil()을 통하여 실수값보다 큰 수중 가장 작은 숫자를 정수로 표현함. 2.3 => 3이 되는셈
	}
	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		//현재 페이지를 5개로 나눈 수보다 1큰 정수에 5를 곱한다.
		//가령, 현재 페이지가 8일 경우는 8/5인 1.3이므로 2가 되며 5를 곱한 10이 된다.
		//이를 통하여 현재 페이지인 8페이지를 기준으로 -2~2의 페이지를 표시해주는것이며 6-7-8-9-10 페이지가 목록에 표시되는셈
		if (getLastPage() < getEndPage()) {	//마지막 페이지가 끝 페이지보다 작다면 표시되는 페이지는 마지막 페이지가 됨
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);	//끝 페이지 - 5 + 1 즉, 글의 갯수가 적어 끝 페이지가 3이라면 시작페이지는 -1이 된다.
		if (getStartPage() < 1) {	//실제로는 시작 페이지가 1보다 작을수는 없기에 if문으로 판단하여 작다면
			setStartPage(1);		//시작페이지를 1로 설정한다.
		}
	}
	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
		
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
