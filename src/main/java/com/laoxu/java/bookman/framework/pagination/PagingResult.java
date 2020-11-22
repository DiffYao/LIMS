package com.laoxu.java.bookman.framework.pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果类
 * <p>查询方法在进行分页查询时直接返回该类型的数据，同时包括结果集合和数据总数，即提高了查询效率又方便表现层绑定数据。</p>
 *
 * @author laoxu
 * @create 2018-10-23
 **/
public class PagingResult<T> {
    private int page;//当前页索引
    private int totalPages;//总页数
    private int records;//总记录数
    private int pageSize;//当前页大小
    private List<T> rows = new ArrayList<T>();//分页结果集

    /**
     * 构造函数。
     *
     * @param rows        分页结果集
     * @param currentPage 当前页索引
     * @param pageSize    当前页大小
     * @param records     总记录数
     */
    public PagingResult(List<T> rows, int currentPage, int pageSize, int records) {
        this.page = currentPage;
        this.records = records;
        this.pageSize = pageSize;
        if (rows != null) {
            this.rows = rows;
        }
        // 计算总页数
        totalPages = records % pageSize == 0 ? records / pageSize : records / pageSize + 1;
    }

    /**
     * 获取当前页索引。
     *
     * @return 当前页索引
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置当前页索引。
     *
     * @param page 当前页索引
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 获取总页数。
     *
     * @return 总页数
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * 设置总页数。
     *
     * @param total 总页数
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 获取总记录数。
     *
     * @return 总记录数
     */
    public int getRecords() {
        return records;
    }

    /**
     * 设置总记录数。
     *
     * @param records 总记录数
     */
    public void setRecords(int records) {
        this.records = records;
    }

    /**
     * 获取当前页大小。
     *
     * @return 页大小
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置当前页大小。
     *
     * @param pageSize 当前页大小
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取分页结果集。
     *
     * @return 分页结果集
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 获取分页结果集。
     *
     * @param rows 分页结果集
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * 根据页索引和页大小对 List 进行内存分页。
     *
     * @param <T>          List类型
     * @param originalList 待分页的 List 实例
     * @param currentPage  页索引
     * @param pageSize     页大小
     * @return 分页集合
     */
    public static <T> PagingResult<T> paggingList(List<T> originalList, int currentPage, int pageSize) {
        if (originalList == null)
            return null;

        int originalSize = originalList.size();

        if ((originalSize == 0) || originalSize <= pageSize)
            return new PagingResult<T>(originalList, currentPage, pageSize, originalSize);

        int startRows = (currentPage - 1) * pageSize;
        int endRows = startRows + pageSize;

        if (endRows > originalSize)
            endRows = originalSize;

        return new PagingResult<T>(originalList.subList(startRows, endRows), currentPage, pageSize, originalSize);
    }
}
