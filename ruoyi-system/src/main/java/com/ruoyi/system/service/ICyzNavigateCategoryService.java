package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CyzNavigateCategory;

/**
 * Service接口
 *
 * @author 神的孩子都在歌唱
 * @date 2023-09-26
 */
public interface ICyzNavigateCategoryService
{
    /**
     * 查询
     *
     * @param id 主键
     * @return 神的孩子都在歌唱
     */
    public CyzNavigateCategory selectCyzNavigateCategoryById(Long id);

    /**
     * 查询列表
     *
     * @param cyzNavigateCategory
     * @return 集合
     */
    public List<CyzNavigateCategory> selectCyzNavigateCategoryList(CyzNavigateCategory cyzNavigateCategory);

    /**
     * 新增
     *
     * @param cyzNavigateCategory
     * @return 结果
     */
    public int insertCyzNavigateCategory(CyzNavigateCategory cyzNavigateCategory);

    /**
     * 修改
     *
     * @param cyzNavigateCategory
     * @return 结果
     */
    public int updateCyzNavigateCategory(CyzNavigateCategory cyzNavigateCategory);

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键集合
     * @return 结果
     */
    public int deleteCyzNavigateCategoryByIds(Long[] ids);

    /**
     * 删除信息
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteCyzNavigateCategoryById(Long id);
}
