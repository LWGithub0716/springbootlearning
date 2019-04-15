package com.ligz.controller;

import com.ligz.model.Permission;
import com.ligz.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * author:ligz
 */
@Controller
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @RequestMapping("listPermission")
    public ModelAndView list() {
        return new ModelAndView("permission.jsp").addObject("permissions", permissionService.getAll());
    }

    @RequestMapping("addPermission")
    @ResponseBody
    public String add(Permission permission) {
        return permissionService.add(permission) > 0 ? "success" : "error";
    }
}
