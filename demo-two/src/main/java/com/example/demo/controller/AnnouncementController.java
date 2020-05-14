package com.example.demo.controller;

import com.example.demo.boot.restful.RestResponse;
import com.example.demo.boot.restful.RestResult;
import com.example.demo.example.entity.ScmAnnouncement;
import com.example.demo.service.AnnouncementService;
import com.example.demo.service.model.dto.AnnouncementDTO;
import com.example.demo.service.model.vo.AnnouncementVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: AnnouncementController <br>
 * @date: 2020/1/14 10:04 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Api(tags = " 公告api ")
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService scmAnnouncementService;


    /**
     * @param announcementDTO 翻译：公告DTO
     * @return com.yintu.supply.restful.ResResult<java.lang.Boolean> <br>
     * @Author pwb
     * @Date 15:53 2019/11/22 <br>
     * @Description addAnnouncement  添加公告<br>
     **/
    @PostMapping("/addAnnouncement")
    public RestResult<Boolean> addAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {

        announcementDTO.setId(null);
        if (StringUtils.isBlank(announcementDTO.getContent()))
            return RestResponse.error("content 不能为空");
        if (StringUtils.isBlank(announcementDTO.getTitle()))
            return RestResponse.error("title不能为空");
        if (announcementDTO.getType() == null)
            announcementDTO.setType((byte) 3);
        if (announcementDTO.getRollingTime() == null)
            announcementDTO.setRollingTime((byte) 5);
        if (announcementDTO.getWordIsRolling() == null) {
            announcementDTO.setWordIsRolling(false);
        }
        if (announcementDTO.getSort() == null) {
            announcementDTO.setSort(11);
        }
        return RestResponse.ok(scmAnnouncementService.addAnnouncement(announcementDTO));
    }


    /*
     * 修改公告通过公告id
     * */
    @PutMapping("/editAnnouncement")
    public RestResult<Boolean> editAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {
        if (announcementDTO.getId() == null)
            return RestResponse.error("id 不能为空");

        return RestResponse.ok(scmAnnouncementService.editAnnouncement(announcementDTO));
    }

    /**
     * @param pageNum  <br>
     * @param pageSize <br>
     * @return com.example.demo.boot.restful.ResResult<com.github.pagehelper.PageInfo < com.example.demo.service.model.vo.AnnouncementVO>> <br>
     * @description: getAnnouncementInfoByPage 分页获取公告列表 <br>
     * @since: 1.0 <br>
     * @date: 2020/3/7 13:56 <br>
     * @author: PWB <br>
     */
    @GetMapping("/getAnnouncementInfoByPage")
    public RestResult<PageInfo<AnnouncementVO>> getAnnouncementInfoByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return RestResponse.ok(scmAnnouncementService.getAnnouncementInfoByPage(pageNum, pageSize));
    }

    /*
     * 通过id获取相应公告信息
     * */
    @GetMapping("/getAnnouncementInfoById/{id}")
    public RestResult<AnnouncementVO> getAnnouncementInfoById(@PathVariable Long id) {
        return RestResponse.ok(scmAnnouncementService.getAnnouncementInfoById(id));
    }

    /**
     * @param id            id
     * @param wordIsRolling wordIsRolling
     * @return com.yintu.supply.restful.ResResult<java.lang.Boolean> <br>
     * @Author pwb
     * @Date 14:42 2019/11/21 <br>
     * @Description doSwitchWordRolling 改变公告文字轮播状态<br>
     **/
    @ApiOperation("改变公告文字轮播状态")
    @PutMapping("/doSwitchWordRolling")
    public RestResult<Boolean> doSwitchWordRolling(@RequestParam Long id, @RequestParam Boolean wordIsRolling) {
        return RestResponse.ok(scmAnnouncementService.doSwitchWordRolling(id, wordIsRolling));
    }


    /**
     * @param id 公告id
     * @return com.yintu.supply.restful.ResResult<java.lang.Boolean> <br>
     * @Author pwb
     * @Date 17:31 2019/12/2 <br>
     * @Description deleteAnnouncement 通过公告id 删除公告<br>
     **/

    @DeleteMapping("/deleteAnnouncement/{id}")
    public RestResult<Boolean> deleteAnnouncement(@PathVariable Long id) {
        return RestResponse.ok(scmAnnouncementService.deleteAnnouncement(id));
    }

    @GetMapping("doTestPageInfo")
    public RestResult<PageInfo<ScmAnnouncement>> doTestPageInfo(Integer pageNum, Integer pageSize) {
        return RestResponse.ok(scmAnnouncementService.doTestPageInfo(pageNum, pageSize));
    }

}
