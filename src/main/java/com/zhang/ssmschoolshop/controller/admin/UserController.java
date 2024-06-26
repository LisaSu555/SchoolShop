package com.zhang.ssmschoolshop.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zhang.ssmschoolshop.entity.*;
import com.zhang.ssmschoolshop.service.UserService;
import com.zhang.ssmschoolshop.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/showjson")
    @ResponseBody
    public Msg getAllGoods(@RequestParam(value = "page",defaultValue = "1") Integer pn, HttpServletResponse response, Model model) {
        //一页显示几个数据
        PageHelper.startPage(pn, 10);
        List<User> userList = userService.selectByExample(new UserExample());
        //显示几个页号
        PageInfo page = new PageInfo(userList,5);

       /* model.addAttribute("pageInfo", page);*/

        return Msg.success("查询成功!").add("pageInfo", page);
    }

    @GetMapping("/show")
    public String userManage(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "adminLogin";
        }
        return "userManage";
    }

    @RequestMapping(value = "/delete/{userid}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteUser(@PathVariable("userid")Integer userid,HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return Msg.fail("请先登录!");
        }
        userService.deleteUserById(userid);
        return Msg.success("删除成功!");
    }

    @GetMapping("/add")
    public String userAddPage(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "adminLogin";
        }
        return "userAdd";
    }

    @GetMapping("/update_psw")
    public String userUpdatePsw(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return "adminLogin";
        }
        return "userPswEdit";
    }

    @PostMapping("save")
    public String saveUser(User user, HttpSession session, Model model) throws IOException {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            //return Msg.fail("请先登录");
            return "adminLogin";
        }
        String saveResult = userService.saveUser(user);
        if("0000".equals(saveResult)){
            model.addAttribute("msg","0000");
            return "userManage";
            //return Msg.success(saveResult);
        }else{
            //return Msg.fail(saveResult);
            model.addAttribute("msg","4000");
            return "userAdd";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Msg updateUser(UserVi user, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            return Msg.fail("请先登录");
        }
        String resultMsg = userService.updateUser(user);
        if("0000".equals(resultMsg)){
            return Msg.success("更新成功!");
        }else {
            return Msg.fail(resultMsg);
        }
    }
}
