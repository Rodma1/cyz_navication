package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CyzNavigateSite;

/**
 * 导航网站Service接口
 * 
 * @author ruoyi
 * @date 2023-09-26
 */
public interface ICyzNavigateSiteService 
{
    /**
     * 查询导航网站
     * 
     * @param id 导航网站主键
     * @return 导航网站
     */
    public CyzNavigateSite selectCyzNavigateSiteById(Long id);

    /**
     * 查询导航网站列表
     * 
     * @param cyzNavigateSite 导航网站
     * @return 导航网站集合
     */
    public List<CyzNavigateSite> selectCyzNavigateSiteList(CyzNavigateSite cyzNavigateSite);

    /**
     * 新增导航网站
     * 
     * @param cyzNavigateSite 导航网站
     * @return 结果
     */
    public int insertCyzNavigateSite(CyzNavigateSite cyzNavigateSite);

    /**
     * 修改导航网站
     * 
     * @param cyzNavigateSite 导航网站
     * @return 结果
     */
    public int updateCyzNavigateSite(CyzNavigateSite cyzNavigateSite);

    /**
     * 批量删除导航网站
     * 
     * @param ids 需要删除的导航网站主键集合
     * @return 结果
     */
    public int deleteCyzNavigateSiteByIds(Long[] ids);

    /**
     * 删除导航网站信息
     * 
     * @param id 导航网站主键
     * @return 结果
     */
    public int deleteCyzNavigateSiteById(Long id);
}
