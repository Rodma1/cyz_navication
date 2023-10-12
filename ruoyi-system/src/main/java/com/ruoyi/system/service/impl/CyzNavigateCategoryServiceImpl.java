package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CyzNavigateCategoryMapper;
import com.ruoyi.system.domain.CyzNavigateCategory;
import com.ruoyi.system.service.ICyzNavigateCategoryService;

/**
 * Service业务层处理
 *
 * @author 神的孩子都在歌唱
 * @date 2023-09-26
 */
@Service
public class CyzNavigateCategoryServiceImpl implements ICyzNavigateCategoryService
{
    @Autowired
    private CyzNavigateCategoryMapper cyzNavigateCategoryMapper;

    /**
     * 查询
     *
     * @param id 神的孩子都在歌唱主键
     * @return 神的孩子都在歌唱
     */
    @Override
    public CyzNavigateCategory selectCyzNavigateCategoryById(Long id)
    {
        return cyzNavigateCategoryMapper.selectCyzNavigateCategoryById(id);
    }

    /**
     * 查询列表
     *
     * @param cyzNavigateCategory
     * @return 神的孩子都在歌唱
     */
    @Override
    public List<CyzNavigateCategory> selectCyzNavigateCategoryList(CyzNavigateCategory cyzNavigateCategory)
    {
        return cyzNavigateCategoryMapper.selectCyzNavigateCategoryList(cyzNavigateCategory);
    }

    /**
     * 新增
     *
     * @param cyzNavigateCategory
     * @return 结果
     */
    @Override
    public int insertCyzNavigateCategory(CyzNavigateCategory cyzNavigateCategory)
    {
        cyzNavigateCategory.setCreateTime(DateUtils.getNowDate());
        cyzNavigateCategory.setDelFlag("0");
        return cyzNavigateCategoryMapper.insertCyzNavigateCategory(cyzNavigateCategory);
    }

    /**
     * 修改
     *
     * @param cyzNavigateCategory
     * @return 结果
     */
    @Override
    public int updateCyzNavigateCategory(CyzNavigateCategory cyzNavigateCategory)
    {
        cyzNavigateCategory.setUpdateTime(DateUtils.getNowDate());
        return cyzNavigateCategoryMapper.updateCyzNavigateCategory(cyzNavigateCategory);
    }

    /**
     * 批量删除神的孩子都在歌唱
     *
     * @param ids 需要删除的主键
     * @return 结果
     */
    @Override
    public int deleteCyzNavigateCategoryByIds(Long[] ids)
    {
        return cyzNavigateCategoryMapper.deleteCyzNavigateCategoryByIds(ids);
    }

    /**
     * 删除信息
     *
     * @param id 主键
     * @return 结果
     */
    @Override
    public int deleteCyzNavigateCategoryById(Long id)
    {
        return cyzNavigateCategoryMapper.deleteCyzNavigateCategoryById(id);
    }
}
