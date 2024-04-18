package com.zhang.ssmschoolshop.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.ssmschoolshop.entity.Admin;
import com.zhang.ssmschoolshop.entity.User;
import com.zhang.ssmschoolshop.entity.VideoExample;
import com.zhang.ssmschoolshop.service.VideoService;
import com.zhang.ssmschoolshop.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/video")
public class VideosController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/showjson")
    @ResponseBody
    public Msg getAllVideos(@RequestParam(value = "page",defaultValue = "1") Integer pn, HttpServletResponse response, Model model) {
        //一页显示几个数据
        PageHelper.startPage(pn, 10);
        List<User> list = videoService.selectByExample(new VideoExample());
        //显示几个页号
        PageInfo page = new PageInfo(list,5);

        return Msg.success("查询成功!").add("pageInfo", page);
    }

    @GetMapping("/show")
    public String videoManage(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "adminLogin";
        }
        return "videoManage";
    }

}
