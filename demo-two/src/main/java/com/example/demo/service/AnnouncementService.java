package com.example.demo.service;

import com.example.demo.service.model.dto.AnnouncementDTO;
import com.example.demo.service.model.vo.AnnouncementVO;
import com.github.pagehelper.PageInfo;

/**
 * @description: AnnouncementService <br>
 * @date: 2020/1/13 15:56 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
public interface AnnouncementService {


    /**
     * @param announcementDTO 公告DTO
     * @return java.lang.Boolean <br>
     * @Author pwb  boot
     * @Date 13:49 2019/11/25 <br>
     * @Description addAnnouncement  添加公告 <br>
     **/
    Boolean addAnnouncement(AnnouncementDTO announcementDTO);

    /**
     * @param announcementDTO 翻译：公告DTO
     * @return java.lang.Boolean <br>
     * @author pwb
     * @date 13:50 2019/11/25 <br>
     * @Description editAnnouncement 修改公告通过公告id <br>
     **/
    Boolean editAnnouncement(AnnouncementDTO announcementDTO);

    /**
     * @param pageNum  第几页
     * @param pageSize 页大小
     * @return com.github.pagehelper.PageInfo<com.yintu.supply.vo.cms.AnnouncementVO> <br>
     * @Author pwb
     * @Date 13:50 2019/11/25 <br>
     * @Description getAnnouncementInfoByPage 分页获取公告列表 <br>
     **/
    PageInfo<AnnouncementVO> getAnnouncementInfoByPage(Integer pageNum, Integer pageSize);

    /**
     * @param id 公告id
     * @return com.yintu.supply.vo.cms.AnnouncementVO <br>
     * @Author pwb
     * @Date 13:50 2019/11/25 <br>
     * @Description getAnnouncementInfoById 通过id获取相应公告信息 <br>
     **/
    AnnouncementVO getAnnouncementInfoById(Long id);

    /**
     * @param id            公告id
     * @param wordIsRolling 文字状态
     * @return java.lang.Boolean <br>
     * @Author pwb
     * @Date 13:50 2019/11/25 <br>
     * @Description doSwitchWordRolling 改变文字轮播状态 <br>
     **/
    Boolean doSwitchWordRolling(Long id, Boolean wordIsRolling);

    /**
     * @param id 公告id
     * @return java.lang.Boolean <br>
     * @Author pwb
     * @Date 13:51 2019/11/25 <br>
     * @Description deleteAnnouncement 通过公告id 删除公告 <br>
     **/
    Boolean deleteAnnouncement(Long id);


}
