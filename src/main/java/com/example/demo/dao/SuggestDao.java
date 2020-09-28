package com.example.demo.dao;

import com.example.demo.pojo.Suggest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SuggestDao {
    @Insert("INSERT INTO zb_suggest(suggest_contact,suggest_view,suggest_time) VALUES(#{suggestContact},#{suggestView},#{suggestTime})")
    boolean insertSuggest(Suggest suggest);

    @Delete("DELETE FROM zb_suggest WHERE suggest_id=#{id}")
    boolean deleteSuggest(int id);

    @Select("SELECT * FROM zb_suggest")
    List<Suggest> selectSuggests();
}
