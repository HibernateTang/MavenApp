package com.spring.oa.util;

import java.util.List;

/**
 * Created by burning-.- on 2015/6/27.
 */
public class PageBean {
    private int rowCount;
    private int currentPage;
    private int pageSize;
    private int pageCount;
    private int offset;
    private int startPage;
    private int endPage;
    private List<?> contents;

    public PageBean(int rowCount, int currentPage, int pageSize, int pageCount, int offset, int startPage, int endPage, List<?> contents) {
        this.rowCount = rowCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.offset = offset;
        this.startPage = startPage;
        this.endPage = endPage;
        this.contents = contents;
    }

    public PageBean(int rowCount,int page,int pageSize,int pageButtonSize){
        this.rowCount=rowCount;
        this.pageSize=pageSize;
        if(rowCount==0){
            this.pageCount=1;
        }else if(rowCount%pageSize==0){
            this.pageCount=rowCount/pageSize;
        }else {
            this.pageCount=rowCount/pageSize+1;
        }
        if(page<=0){
            this.currentPage=1;
        }else if(page>pageCount){
            this.currentPage=page;
        }else {
            this.currentPage=page;
        }
        this.offset=pageSize*(this.currentPage-1);
        if(this.currentPage%pageButtonSize==0){
            this.startPage=(this.currentPage/pageButtonSize-1)*10+2;
            this.endPage=this.currentPage/10*10+1;
        }else {
            this.startPage=(this.currentPage/pageButtonSize-1)*10+1;
            this.endPage=(this.currentPage/10+1)*10;
        }
        if(startPage<1){
            startPage=1;
        }
        if(pageCount==0){
            endPage=1;
        }else if(endPage>pageCount){
            endPage=pageCount;
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
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

    public List<?> getContents() {
        return contents;
    }

    public void setContents(List<?> contents) {
        this.contents = contents;
    }
}
