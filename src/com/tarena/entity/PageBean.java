package com.tarena.entity;

public class PageBean {
    
    private int currPage;
    private int rows;
    private int start;
    /**
     * @return the currPage
     */
    public int getCurrPage() {
        return currPage;
    }
    /**
     * @param currPage the currPage to set
     */
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }
    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }
    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }
    /**
     * @return the start
     */
    public int getStart() {  
        return rows*(currPage-1);
    }
    
    public PageBean(int currPage, int rows) {
        super();
        this.currPage = currPage;
        this.rows = rows;
    }
    
    public PageBean(int rows) {
        super();
        this.rows = rows;
    }

    
    
    
    
    
}
