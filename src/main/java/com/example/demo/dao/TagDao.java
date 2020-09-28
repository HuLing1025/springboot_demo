package com.example.demo.dao;

import com.example.demo.pojo.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagDao {
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "liveTag", column = "live_tag")
//    })
    @Insert("INSERT INTO zb_tag(live_tag) values(#{liveTag})")
    boolean insertTag(Tag tag);

    @Delete("DELETE FROM zb_tag WHERE id=#{id}")
    boolean deleteTag(int id);

    @Update("UPDATE zb_tag SET live_tag=#{liveTag} WHERE id=#{id}")
    boolean updateTag(Tag tag);

    @Select("SELECT * FROM zb_tag")
    List<Tag> selectTags();

    @Select("SELECT * FROM zb_tag WHERE id=#{id}")
    Tag selectTagById(int id);
}
