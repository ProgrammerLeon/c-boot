package com.pgleon.cboot.pojo;

/**
 * @Auther: leon
 * @Date: 2019-07-13 13:31
 * @Description:
 */
public class PagingParam {
    private int page = 1;
    private int pageSize = 10;

    public PagingApiResponse.PagingApiResponseBuilder pagingApiResponseBuilder() {
        return PagingApiResponse.PagingApiResponseBuilder.pagingApiResponseBuilder().withPageParam(this);
    }

    public static PagingParam aPagingParam(int page, int pageSize) {
        PagingParam pagingParam = new PagingParam();
        pagingParam.setPage(page);
        pagingParam.setPageSize(pageSize);
        return pagingParam;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
