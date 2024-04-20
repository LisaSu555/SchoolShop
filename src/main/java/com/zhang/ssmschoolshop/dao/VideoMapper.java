package com.zhang.ssmschoolshop.dao;

import com.zhang.ssmschoolshop.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
    List<Video> selectAllVideos();
}
