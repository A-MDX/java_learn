package madx.entity;

import java.util.List;

/**
 * Created by A-mdx on 2016/11/26.
 */
public class PageQueryPO {
    
    private int pageNumber;
    private int pageSize;
    private int totalPageSize;
    private int totalSize;
    private List<?> content;

    public PageQueryPO(int size, int totalSize) {
        this.pageSize = size == 0 ? 20 : size;
        this.totalSize = totalSize;
        this.totalPageSize = totalSize % this.pageSize == 0 ? totalSize/this.pageSize :totalSize/this.pageSize+1; 
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(int totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }
}
