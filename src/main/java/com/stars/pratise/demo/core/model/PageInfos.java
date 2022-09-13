package com.stars.pratise.demo.core.model;

import com.github.pagehelper.PageInfo;
import com.stars.pratise.demo.utils.CoreUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author stars
 * @ClassName: PageInfos
 * @Description: 分页信息的封装
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfos {

    private final static int PAGESIZE = 10; //默认显示的记录数
//    private static final long serialVersionUID = 9141819156724924942L;

    private Integer total;                      // 总记录
    private List<?> rows;                       //显示的记录
    private Integer from;                       // 开始的记录
    private Integer size;                       // 结束的记录
    private Integer nowpage;                    // 当前页
    private Integer pagesize;                   // 每页显示的记录数
    private Map<String, Object> condition;      //查询条件
    private String sort;                        // 排序字段
    private String order;                       // asc，desc
    /**
     * 排序字段，默认使用ID来排序
     */
    private String sortField = "id";

    /**
     * 排序方式，默认升序
     */
    private String sortOrder = "DESC";

    //构造方法
    public PageInfos(Integer nowpage, Integer pagesize) {
        //计算当前页
        if (nowpage == null || nowpage < 0) {
            this.nowpage = 1;
        } else {
            //当前页
            this.nowpage = nowpage;
        }
        //记录每页显示的记录数
        if (pagesize == null || pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else {
            this.pagesize = pagesize;
        }
        //计算开始的记录和结束的记录
        this.from = (this.nowpage - 1) * this.pagesize;
        this.size = this.pagesize;
    }

    // 构造方法
    public PageInfos(Integer nowpage, Integer pagesize, String sort, String order) {
        // 计算当前页
        if (nowpage == null || nowpage < 0) {
            this.nowpage = 1;
        } else {
            // 当前页
            this.nowpage = nowpage;
        }
        // 记录每页显示的记录数
        if (pagesize == null || pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else {
            this.pagesize = pagesize;
        }
        // 计算开始的记录和结束的记录
        this.from = (this.nowpage - 1) * this.pagesize;
        this.size = this.pagesize;
        // 排序字段，正序还是反序
        this.sort = sort;
        this.order = order;
    }

    public String getOrderBy() {
        return CoreUtils.getOrderBy(sortField, sortOrder);
    }
}

