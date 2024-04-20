package com.zhang.ssmschoolshop.dao;

import com.zhang.ssmschoolshop.entity.Video;
import com.zhang.ssmschoolshop.entity.VideoVi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
    List<Video> selectAllVideos();

    void insertVideo(@Value("video") Video video);

    void updateVideo(Video video);

    void deleteVideo(@Value("id") int id);
}
