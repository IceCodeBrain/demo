package com.example.demo.controller.admin;

import com.example.demo.boot.component.security.Authority;
import com.example.demo.boot.core.BaseController;
import com.example.demo.boot.restful.RestDTO;
import com.example.demo.boot.restful.RestResponse;
import com.example.demo.boot.restful.RestResult;
import com.example.demo.boot.uitls.ConvertUtils;
import com.example.demo.model.dto.AdminDTO;
import com.example.demo.model.vo.AdminVO;
import com.example.demo.service.AdminService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @description: AdminAuthController <br>
 * @date: 2021/4/1 11:08 <br>
 * @author: PWB <br>
 */

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "管理权限相关API")
@RestController
@RequestMapping("admin/auth")
public class AdminAuthController extends BaseController {

    /**
     * 服务对象
     */
    private final AdminService adminService;

    @Authority(required = false)
    @ApiOperation("后台管理登录")
    @PostMapping("doLogin")
    public RestResult<AdminVO> doLogin(@RequestParam String nickname, @RequestParam String password) {
        return RestResponse.ok(adminService.login(nickname, password));
    }

    @ApiOperation("后台管理退出登录")
    @PostMapping("doLogout")
    public RestResult<Boolean> doLogout() {
        return RestResponse.ok(adminService.logout());
    }

    @ApiOperation("获取管理员信息")
    @Authority(value = {1, 2})
    @GetMapping("doGetInfo")
    public RestResult<AdminVO> doGetInfo() {
        return RestResponse.ok(adminService.queryById(getUserId()));
    }

    @ApiOperation("添加/编辑管理员")
    @Authority(value = {1})
    @PostMapping("doEditAdmin")
    public RestResult<Boolean> doEditAdmin(@RequestBody AdminDTO dto) {
        if (StringUtils.hasText(dto.getPhone())) {
            if (!ConvertUtils.phoneJudge(dto.getPhone())) {
                return RestResponse.error("手机号格式不正确");
            }
        }
        if (StringUtils.hasText(dto.getPassword())) {
            if (dto.getPassword().length() < 6) {
                return RestResponse.error("密码不能少于六位");
            }
        }
        if (dto.getId() == null) {
            return RestResponse.ok(adminService.add(dto));
        }
        return RestResponse.ok(adminService.update(dto));
    }

    @ApiOperation("获取管理员列表")
    @Authority(value = {1, 2})
    @PostMapping("doGetAdmins")
    public RestResult<PageInfo<AdminVO>> doGetAdmins(@RequestBody RestDTO<Object> dto) {
        return RestResponse.ok(adminService.queryByPage(dto));
    }

    @ApiOperation("删除管理员")
    @Authority(value = {1})
    @DeleteMapping("doDeleteAdmin")
    public RestResult<Boolean> doDeleteAdmin(@RequestParam Integer id) {
        return RestResponse.ok(adminService.deleteById(id));
    }


}
