package com.zhang.ssmschoolshop.dao;

import com.zhang.ssmschoolshop.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
    List<User> selectAllVideos();
}
