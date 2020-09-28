package com.example.demo.serviceImp;

import com.example.demo.pojo.Tag;
import com.example.demo.dao.TagDao;
import com.example.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImp implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public boolean insertTag(Tag tag) {
        boolean flag = false;
        try{
            tagDao.insertTag(tag);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteTag(int id) {
        boolean flag = false;
        try{
            tagDao.deleteTag(id);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateTag(Tag tag) {
        boolean flag = false;
        try{
            tagDao.updateTag(tag);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Tag> selectTags() {
        return tagDao.selectTags();
    }

    @Override
    public Tag selectTagById(int id) {
        return tagDao.selectTagById(id);
    }
}
