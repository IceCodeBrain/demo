package com.example.demo.service.impl;

import com.example.demo.example.entity.ScmAnnouncement;
import com.example.demo.example.mapper.ScmAnnouncementMapper;
import com.example.demo.service.AnnouncementService;
import com.example.demo.service.model.dto.AnnouncementDTO;
import com.example.demo.service.model.vo.AnnouncementVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: AnnouncementServiceImpl <br>
 * @date: 2020/1/13 15:56 <br>
 * @author: PWB <br>
 * @version: 1.0 <br>
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "announcement_cache", keyGenerator = "defineKeyGenerator")
public class AnnouncementServiceImpl implements AnnouncementService {
    @Resource
    private ScmAnnouncementMapper scmAnnouncementMapper;

    @CacheEvict(allEntries = true, beforeInvocation = false)
    @Override
    public Boolean addAnnouncement(AnnouncementDTO announcementDTO) {
        ScmAnnouncement scmAnnouncement = new ScmAnnouncement();
        BeanUtils.copyProperties(announcementDTO, scmAnnouncement);
        scmAnnouncement.setUpdateTime(new Date());
        scmAnnouncement.setCreateTime(new Date());
        return scmAnnouncementMapper.insertSelective(scmAnnouncement) == 1;
    }

    @CacheEvict(allEntries = true, beforeInvocation = false)
    @Override
    public Boolean editAnnouncement(AnnouncementDTO announcementDTO) {
        ScmAnnouncement scmAnnouncement = new ScmAnnouncement();
        BeanUtils.copyProperties(announcementDTO, scmAnnouncement);
        scmAnnouncement.setUpdateTime(new Date());
        return scmAnnouncementMapper.updateByPrimaryKeySelective(scmAnnouncement) == 1;
    }

    @Cacheable
    @Override
    public PageInfo<AnnouncementVO> getAnnouncementInfoByPage(Integer pageNum, Integer pageSize) {
        ScmAnnouncement announcement = new ScmAnnouncement();
        announcement.setIsDelete(false);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ScmAnnouncement> pageInfo = new PageInfo<>(scmAnnouncementMapper.select(announcement));
        List<ScmAnnouncement> scmAnnouncementList = pageInfo.getList();
        List<AnnouncementVO> announcementVOS = new LinkedList<>();
        AnnouncementVO announcementVO;
        for (ScmAnnouncement scmAnnouncement : scmAnnouncementList) {
            announcementVO = new AnnouncementVO();
            BeanUtils.copyProperties(scmAnnouncement, announcementVO);
            announcementVOS.add(announcementVO);
        }
        PageInfo<AnnouncementVO> announcementVOPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, announcementVOPageInfo);
        announcementVOPageInfo.setList(announcementVOS);
        return announcementVOPageInfo;
    }

    @Cacheable
    @Override
    public AnnouncementVO getAnnouncementInfoById(Long id) {
        ScmAnnouncement scmAnnouncement = scmAnnouncementMapper.selectByPrimaryKey(id);
        AnnouncementVO announcementVO = new AnnouncementVO();
        BeanUtils.copyProperties(scmAnnouncement, announcementVO);
        return announcementVO;
    }

    @CacheEvict(allEntries = true)
    @Override
    public Boolean doSwitchWordRolling(Long id, Boolean wordIsRolling) {
        ScmAnnouncement scmAnnouncement = new ScmAnnouncement();
        scmAnnouncement.setId(id);
        scmAnnouncement.setWordIsRolling(wordIsRolling);
        scmAnnouncement.setUpdateTime(new Date());
        return scmAnnouncementMapper.updateByPrimaryKeySelective(scmAnnouncement) == 1;
    }

    @CacheEvict(allEntries = true)
    @Override
    public Boolean deleteAnnouncement(Long id) {
        ScmAnnouncement announcement = new ScmAnnouncement();
        announcement.setId(id);
        announcement.setIsDelete(true);
        announcement.setUpdateTime(new Date());
        return scmAnnouncementMapper.updateByPrimaryKeySelective(announcement) == 1;
    }


    public PageInfo<ScmAnnouncement> doTestPageInfo(Integer pageNum, Integer pageSize) {
        ScmAnnouncement announcement = new ScmAnnouncement();
        announcement.setIsDelete(false);
        PageHelper.startPage(pageNum, pageSize);
        /*PageInfo<ScmAnnouncement> pageInfo = new PageInfo<>(scmAnnouncementMapper.select(announcement));
        log.info("pageInfo1 =>>{}", pageInfo);
*/
        PageInfo<ScmAnnouncement> pageInfo2 = new PageInfo<>(scmAnnouncementMapper.select(announcement));

        pageInfo2.setTotal(pageInfo2.getTotal() + 5);
        log.info("pageInfo2 =>>{}", pageInfo2);
        return pageInfo2;
    }


}
