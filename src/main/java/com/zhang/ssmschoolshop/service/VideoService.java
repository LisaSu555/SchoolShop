package com.zhang.ssmschoolshop.service;

import com.zhang.ssmschoolshop.entity.User;
import com.zhang.ssmschoolshop.entity.VideoExample;

import java.util.List;

public interface VideoService {
    List<User> selectByExample(VideoExample videoExample);
}
