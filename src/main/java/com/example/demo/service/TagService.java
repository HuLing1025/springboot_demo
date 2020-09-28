package com.example.demo.service;

import com.example.demo.pojo.Tag;

import java.util.List;

public interface TagService{
    /*
     * 新增标签
     * @param tag
     * @return
     * */
    boolean insertTag(Tag tag);

    /*
     * 删除标签
     * @param id
     * @return
     * */
    boolean deleteTag(int id);

    /*
     * 更新标签
     * @param tag
     * @return
     * */
    boolean updateTag(Tag tag);

    /*
     * 查询标签列表
     * @return
     * */
    List<Tag> selectTags();

    /*
     * 根据id查询标签
     * @param id
     * @return
     * */
    Tag selectTagById(int id);
}
