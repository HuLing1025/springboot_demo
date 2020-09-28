package com.example.demo.service;

import com.example.demo.pojo.Suggest;

import java.util.List;

public interface SuggestService {
    /*
    * 新增建议
    * @param suggest
    * @return
    * */
    boolean insertSuggest(Suggest suggest);

    /*
     * 删除建议
     * @param id
     * @return
     * */
    boolean deleteSuggest(int id);

    /*
     * 查询建议列表
     * @return
     * */
    List<Suggest> selectSuggests();
}
