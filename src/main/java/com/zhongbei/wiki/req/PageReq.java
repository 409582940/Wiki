package com.zhongbei.wiki.req;

public class PageReq {
    private int size;
    private int page;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNum() {
        return page;
    }

    public void setNum(int num) {
        this.page = num;
    }

    @Override
    public String toString() {
        return "PageReq{" +
                "size=" + size +
                ", num=" + page +
                '}';
    }
}
