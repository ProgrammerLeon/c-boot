package com.pgleon.cboot.pojo;


import java.util.List;

public class PagingApiResponse {
    private int page = 0;
    private int pageSize = 0;
    private int total = -1;
    private boolean hasMore = false;
    private List data;

    public static class PagingApiResponseBuilder {
        private int page;
        private int pageSize;
        private int total;
        private boolean hasMore;
        private List data;

        private PagingApiResponseBuilder() {
        }

        public static PagingApiResponseBuilder pagingApiResponseBuilder() {
            return new PagingApiResponseBuilder();
        }

        public PagingApiResponseBuilder withPage(int page) {
            this.page = page;
            return this;
        }

        public PagingApiResponseBuilder withPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public PagingApiResponseBuilder withTotal(int total) {
            this.total = total;
            return this;
        }

        public PagingApiResponseBuilder withHasMore(boolean hasMore) {
            this.hasMore = hasMore;
            return this;
        }

        public PagingApiResponseBuilder withData(List data) {
            this.data = data;
            return this;
        }

        public PagingApiResponseBuilder withPageParam(PagingParam pageParam) {
            this.page = pageParam.getPage();
            this.pageSize = pageParam.getPageSize();
            return this;
        }

        public PagingApiResponse build() {
            PagingApiResponse pagingVO = new PagingApiResponse();
            pagingVO.setPage(page);
            pagingVO.setPageSize(pageSize);
            pagingVO.setTotal(total);
            pagingVO.setHasMore(hasMore);
            pagingVO.setData(data);
            return pagingVO;
        }
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }


}