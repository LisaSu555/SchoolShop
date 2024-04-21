package com.zhang.ssmschoolshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PictureController {
    /**
     * 从数据库查询图片路径，用于前端图片展示，可以使用nginx来代理
     * @return 路径
     */
    @RequestMapping("/picture")
    public String picturePath(Integer goodId, Model model){

        return "";
    }

}
