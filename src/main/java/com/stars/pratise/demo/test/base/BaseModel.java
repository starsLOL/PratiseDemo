package com.stars.pratise.demo.test.base;


import java.io.Serializable;

public class BaseModel implements Serializable {
    private static final long serialVersionUID = 8453094770356343717L;
//    private static final long serialVersionUID = -1082999094137367538L;
//
//    public static final String ViewMode_SalesRepView = "SalesRepView";//我的
//    public static final String ViewMode_ManagerView = "ManagerView";//我的团队的
//    public static final String ViewMode_AllView = "AllView";//所有的
//
//    //固定视图模型值
//    public static final Map<String, Integer> viewModeMap = new ConcurrentHashMap<>();
//
//    public static final Map<String, Integer> getViewModeMap() {
//        if (viewModeMap.isEmpty()) {
//            viewModeMap.put(ViewMode_SalesRepView, 0);
//            viewModeMap.put(ViewMode_ManagerView, 1);
//            viewModeMap.put(ViewMode_AllView, 2);
//        }
//        return viewModeMap;
//    }
//
//    //视图类型---我团队的，所有的（get,set）
//    private String viewType = ViewMode_SalesRepView;
//
//    public String getViewType() {
//        return viewType;
//    }
//
//    public void setViewType(String viewType) {
//        this.viewType = viewType;
//    }
//
//    //获取视图模型值。
//    public int getViewMode() {
//        Map<String, Integer> map = getViewModeMap();
//        if (this.getViewType() == null || "".equals(this.getViewType())) {
//            return map.get(ViewMode_SalesRepView);
//        }
//        if (map.containsKey(this.getViewType())) {
//            return map.get(this.getViewType());
//        }
//        return map.get(ViewMode_SalesRepView);
//    }
//
//    //一些基础字段
//    private String rowId;
//    private String createrId;
//    private String createrName;
//    private String createTime;
//    private String updaterId;//修改人
//    private String updaterName;//
//    private String updateTime;
//    private String isActive;
//
//    private String loginId; //登陆人Id
//    private String loginName;//登陆账号
//    private String positionId;
//    private String relaId;
//    private String pq_sort;
//    private String searchText;
//    private String rowIds;//查询用，需要查询用的所有rowId
//    String systemSource;//区分数据来源
//
//    public static final int DEFAULT_PAGE_SIZE = 10;
//    public static final int DEFAULT_CUR_PAGE = 1;
//    /*最精简参数*/
//    private int pageSize = DEFAULT_PAGE_SIZE;
//    private int curPage = DEFAULT_CUR_PAGE;
//    private int totalRecords = 0;//总计数目,统计用的
//    boolean sum; //布尔类型默认为false
//
//    //**排序相关**
//    //某些属性特殊的 get  set  方法  --pq_sort=[{“dataIndx”:“chsDesc”,“dir”:“up”}]
//    public String getPq_sort() {
//        return pq_sort;
//    }
//
//    String sortDir = "down";
//    String sortCol;
//
//    public void setPq_sort(String pq_sort) {
//        this.pq_sort = pq_sort;
//        if (StringUtils.isBlank(getPq_sort())) {
//            return;
//        }
//        //把字符串转换成Json数组
//        JSONArray arr = JSONArray.fromObject(getPq_sort());
//        if (arr.size() > 0) {
//            //把数组转换成Json对象
//            JSONObject obj = arr.getJSONObject(0);
//            setSortDir(obj.getString("dir"));
//            setSortCol(obj.getString("dataIndx"));
//        }
//    }
//
//    //分页相关  规则要知道:默认页码第一页索引为1,记录数第一条索引为0.
//    public int getStartRowNum() {
//        return (getCurpage() - 1) * this.getPageSize() + 1;// 当前页起始记录数= (当前页码-1)*每页记录数
//        //这里加1是因为,.记录数要设置为我们的习惯.第一条就是1.而不是外国人默认的0.
//    }
//
//    public int getEndRowNum() {
//        return (getCurpage() - 1) * this.getPageSize() + this.getPageSize();// 当前页尾记录数=
//    }
//
//    public int getCurPage() {
//        return curPage <= 0 ? 1 : curPage;
//    }
//
//    //还有注意一下:下面的这个字段只有get,set方法;其实Pq_rpp 等同于pageSize.只是不同的人写的.意思是一样的,都是每页显示的记录数.
//    public void setPq_rpp(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    //toString 方法
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }
//
//    //获取rowIdList
//    public List<String> getRowIdList() {
//        List<String> retList = new LinkedList<>();
//        if (getRowIds() != null) {
//            String[] ids = getRowIds().split(",");
//            for (String id : ids) {
//                if (id.trim().length() > 0) {
//                    retlist.add(id.trim());
//                }
//            }
//        }
//        return retlist;
//    }
//
//    //当前时间
//    Date now = new Date();
//
//    public static DateFormat getDateFormat() {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    }
//
//    //当前时间 setget  要提供
//    private String curDateTime = getFateFormat().format(now);


}//类尾
