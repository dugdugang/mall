package com.dg.mall.service.impl;

import com.dg.mall.mapper.AdminMapper;
import com.dg.mall.pojo.Admin;
import com.dg.mall.pojo.AdminExample;
import com.dg.mall.pojo.Result;
import com.dg.mall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Result getLoginResult(Admin admin) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(admin.getUsername());
        criteria.andPasswordEqualTo(admin.getPassword());
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if (adminList.size() > 0) {
            return Result.ok("登陆成功", adminList.get(0));
        } else {
            return Result.err("用户名不正确或密码错误");
        }
    }


    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }
}
