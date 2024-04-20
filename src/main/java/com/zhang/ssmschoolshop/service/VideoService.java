package com.zhang.ssmschoolshop.service;

import com.zhang.ssmschoolshop.entity.Video;
import com.zhang.ssmschoolshop.entity.VideoExample;
import com.zhang.ssmschoolshop.entity.VideoVi;

import java.util.List;

public interface VideoService {
    List<Video> selectByExample(VideoExample videoExample);

    String saveUser(Video video);

    String updateVideo(VideoVi video);
}
