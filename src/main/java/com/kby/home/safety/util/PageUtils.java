package com.kby.home.safety.util;

import com.github.pagehelper.PageInfo;
import com.kby.home.safety.api.web.Pagination;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpeng12 on 2016/12/7.
 */
public class PageUtils {
    public  static Pagination getPagination(PageInfo pageinfo){
        return  new Pagination(pageinfo.getPageNum(), pageinfo.getPageSize(),(int)pageinfo.getTotal());
    }

}
