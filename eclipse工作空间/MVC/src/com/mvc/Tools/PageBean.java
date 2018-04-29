package com.mvc.Tools;

import java.util.List;

/** 
 * @package:        com.mvc.Tools
 * @Description:  	PageBean 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017��11��2�� ����11:58:08 
 */
public class PageBean {
	//ҳ������
	private int pageCount;
	
	//��λҳ���¼��
	private int num;
	//��¼����
	private int numCount;
	//��ǰҳ��
	private int pageNow=1;
	//��ѯ��list����
	private List<?>list;
	
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	//Getter&&Setter
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount() {
		
		pageCount=numCount%num==0?numCount/num:numCount/num+1;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNumCount() {
		return numCount;
	}
	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	@Override
	public String toString() {
		return "PageBean [pageCount=" + pageCount + ", num=" + num + ", pumCount=" + numCount + ", pageNow=" + pageNow
				+ ", list=" + list + "]";
	}
	
	

}
