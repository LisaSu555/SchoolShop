package com.zhang.ssmschoolshop.service.impl;

import com.zhang.ssmschoolshop.dao.VideoMapper;
import com.zhang.ssmschoolshop.entity.Video;
import com.zhang.ssmschoolshop.entity.VideoExample;
import com.zhang.ssmschoolshop.entity.VideoVi;
import com.zhang.ssmschoolshop.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Override
    public List<Video> selectByExample(VideoExample videoExample) {
        return videoMapper.selectAllVideos();
    }

    @Override
    public String saveUser(Video video) {
        if(video == null){
            return "数据错误，不能为空";
        }
        if(StringUtils.isEmpty(video.getFilename()) ||
            StringUtils.isEmpty(video.getTitle())||
            StringUtils.isEmpty(video.getFilepath())){
            return "都不能为空";
        }

        videoMapper.insertVideo(video);

        return "0000";
    }

    @Override
    public String updateVideo(VideoVi video) {
        if(video == null){
            return "数据错误，不能为空";
        }
        if(StringUtils.isEmpty(video.getFilename()) ||
                StringUtils.isEmpty(video.getTitle())||
                StringUtils.isEmpty(video.getFilepath())){
            return "都不能为空";
        }
        Video v = new Video();
        BeanUtils.copyProperties(video,v);
        videoMapper.updateVideo(v);
        return "0000";
    }
}
