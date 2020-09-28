package com.example.demo.serviceImp;

import com.example.demo.dao.SuggestDao;
import com.example.demo.pojo.Suggest;
import com.example.demo.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestServiceImp implements SuggestService {
    @Autowired
    private SuggestDao suggestDao;

    @Override
    public boolean insertSuggest(Suggest suggest) {
        boolean flag = false;
        // 系统当前时间戳作为建议提交时间
        int timeNow = (int)(System.currentTimeMillis()/1000);

        suggest.setSuggestTime(timeNow);
        try {
            suggestDao.insertSuggest(suggest);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteSuggest(int id) {
        boolean flag = false;
        try {
            suggestDao.deleteSuggest(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Suggest> selectSuggests() {
        return suggestDao.selectSuggests();
    }
}
