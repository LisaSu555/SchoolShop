package com.zhang.ssmschoolshop.service.impl;

import com.zhang.ssmschoolshop.dao.VideoMapper;
import com.zhang.ssmschoolshop.entity.User;
import com.zhang.ssmschoolshop.entity.VideoExample;
import com.zhang.ssmschoolshop.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Override
    public List<User> selectByExample(VideoExample videoExample) {
        return videoMapper.selectAllVideos();
    }
}
