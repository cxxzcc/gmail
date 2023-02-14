package com.atguigu.gmall.search.service;

import com.atguigu.gmall.search.vo.SearchParam;
import com.atguigu.gmall.search.vo.SearchResult;

public interface MallSearchService {
    SearchResult search(SearchParam param);
}
