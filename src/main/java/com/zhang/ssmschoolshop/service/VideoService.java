package com.zhang.ssmschoolshop.service;

import com.zhang.ssmschoolshop.entity.Video;
import com.zhang.ssmschoolshop.entity.VideoExample;

import java.util.List;

public interface VideoService {
    List<Video> selectByExample(VideoExample videoExample);
}
