package com.zhang.ssmschoolshop.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.ssmschoolshop.entity.*;
import com.zhang.ssmschoolshop.service.VideoService;
import com.zhang.ssmschoolshop.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        List<Video> list = videoService.selectByExample(new VideoExample());
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

    @GetMapping("/add")
    public String videoAddPage(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "adminLogin";
        }
        return "videoAdd";
    }

    @PostMapping("save")
    public String saveVideo(Video video, HttpSession session, Model model) throws IOException {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            //return Msg.fail("请先登录");
            return "adminLogin";
        }
        String saveResult = videoService.saveUser(video);
        if("0000".equals(saveResult)){
            // 添加成功时返回这个
            model.addAttribute("msg","0000");
            return "redirect:/admin/video/show";
        }else{
            //return Msg.fail(saveResult);添加失败时返回这个
            model.addAttribute("msg",saveResult);
            return "videoAdd";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Msg updateVideo(VideoVi video, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return Msg.fail("请先登录");
        }
        String resultMsg = videoService.updateVideo(video);
        if("0000".equals(resultMsg)){
            return Msg.success("更新成功!");
        }else {
            return Msg.fail(resultMsg);
        }
    }

}
