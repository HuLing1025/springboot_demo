package com.example.demo.dao;

import com.example.demo.pojo.Platform;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PlatformDao {
    @Insert("INSERT INTO zb_platform(live_platform_img,live_platform) VALUES(#{livePlatformImg},#{livePlatform})")
    boolean insertPlatform(Platform platform);

    @Delete("DELETE FROM zb_platform WHERE id=#{id}")
    boolean deletePlatform(int id);

    @Update("UPDATE zb_platform SET live_platform_img=#{livePlatformImg},live_platform=#{livePlatform} WHERE id=#{id}")
    boolean updatePlatform(Platform platform);

    @Select("SELECT * FROM zb_platform")
    List<Platform> selectPlatforms();

    @Select("SELECT * FROM zb_platform WHERE id=#{id}")
    Platform selectPlatformById(int id);
}
