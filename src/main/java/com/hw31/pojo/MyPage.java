package com.hw31.pojo;

import lombok.ToString;

import java.util.List;

@ToString
public class MyPage<T> {
    private int current;//当前页码
    private int size;//每页记录数
    private int total;//总记录数
    private int pages;//总页数
    private int nextpage;//下一页页码
    private int prepage;//上一页页码
    private List<T> list; //每页记录

    public MyPage(){}

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
        this.setInfo();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        this.setInfo();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.setInfo();
    }

    public int getPages() {
        return pages;
    }
    //总页数计算
    private void setPages() {
        if(this.size == 0){
            return;
        }
        if(this.total % this.size == 0){
            this.pages = this.total / this.size;
        }else{
            this.pages = this.total / this.size + 1;
        }
        this.setNextpage();
    }

    public int getNextpage() {
        return nextpage;
    }

    private void setNextpage() {
        this.nextpage = this.current + 1;
        if(this.nextpage > this.pages){
            this.nextpage = 0;
        }

    }

    public int getPrepage() {
        return prepage;
    }

    private void setPrepage() {
        this.prepage = this.current -1;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    private void setInfo(){
        this.setNextpage();
        this.setPrepage();
        this.setPages();
    }
}
