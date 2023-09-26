package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyzNavigateSiteMapper;
import com.ruoyi.system.domain.CyzNavigateSite;
import com.ruoyi.system.service.ICyzNavigateSiteService;

/**
 * 导航网站Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-26
 */
@Service
public class CyzNavigateSiteServiceImpl implements ICyzNavigateSiteService 
{
    @Autowired
    private CyzNavigateSiteMapper cyzNavigateSiteMapper;

    /**
     * 查询导航网站
     * 
     * @param id 导航网站主键
     * @return 导航网站
     */
    @Override
    public CyzNavigateSite selectCyzNavigateSiteById(Long id)
    {
        return cyzNavigateSiteMapper.selectCyzNavigateSiteById(id);
    }

    /**
     * 查询导航网站列表
     * 
     * @param cyzNavigateSite 导航网站
     * @return 导航网站
     */
    @Override
    public List<CyzNavigateSite> selectCyzNavigateSiteList(CyzNavigateSite cyzNavigateSite)
    {
        return cyzNavigateSiteMapper.selectCyzNavigateSiteList(cyzNavigateSite);
    }

    /**
     * 新增导航网站
     * 
     * @param cyzNavigateSite 导航网站
     * @return 结果
     */
    @Override
    public int insertCyzNavigateSite(CyzNavigateSite cyzNavigateSite)
    {
        cyzNavigateSite.setCreateTime(DateUtils.getNowDate());
        return cyzNavigateSiteMapper.insertCyzNavigateSite(cyzNavigateSite);
    }

    /**
     * 修改导航网站
     * 
     * @param cyzNavigateSite 导航网站
     * @return 结果
     */
    @Override
    public int updateCyzNavigateSite(CyzNavigateSite cyzNavigateSite)
    {
        cyzNavigateSite.setUpdateTime(DateUtils.getNowDate());
        return cyzNavigateSiteMapper.updateCyzNavigateSite(cyzNavigateSite);
    }

    /**
     * 批量删除导航网站
     * 
     * @param ids 需要删除的导航网站主键
     * @return 结果
     */
    @Override
    public int deleteCyzNavigateSiteByIds(Long[] ids)
    {
        return cyzNavigateSiteMapper.deleteCyzNavigateSiteByIds(ids);
    }

    /**
     * 删除导航网站信息
     * 
     * @param id 导航网站主键
     * @return 结果
     */
    @Override
    public int deleteCyzNavigateSiteById(Long id)
    {
        return cyzNavigateSiteMapper.deleteCyzNavigateSiteById(id);
    }
}
