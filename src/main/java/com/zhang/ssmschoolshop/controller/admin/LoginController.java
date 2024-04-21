package com.zhang.ssmschoolshop.controller.admin;
import com.zhang.ssmschoolshop.entity.Admin;
import com.zhang.ssmschoolshop.service.AdminService;
import com.zhang.ssmschoolshop.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String adminLogin() {
        return "adminLogin";
    }

    /**
     * 登录验证
     * @param admin
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/confirmLogin")
    public String confirmLogin(Admin admin, Model model, HttpServletRequest request) {
        // 密码转换
        admin.setPassword(Md5Util.MD5Encode(admin.getPassword(),"utf-8"));
        // 数据库只有一个管理员信息，代表管理员只能有一个，当然，后面可以添加更多的
        Admin selectAdmin = adminService.selectByName(admin);
        if (selectAdmin == null) {
            model.addAttribute("errorMsg", "用户名或密码错误");
            return "adminLogin";
        } else {
            HttpSession session = request.getSession();
            // 验证成功后将登录信息放入session，一个浏览器是一个会话，不同浏览器之间session不会相同，所以保证了不同用户各自保存登录信息
            session.setAttribute("admin", selectAdmin);
            return "redirect:/admin/user/show";
        }
    }

    @RequestMapping("/logout")
    public String adminLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "redirect:/admin/login";
    }

    /*@RequestMapping("/index")
    public String showAdminIndex() {
        return "user";
    }*/
}
