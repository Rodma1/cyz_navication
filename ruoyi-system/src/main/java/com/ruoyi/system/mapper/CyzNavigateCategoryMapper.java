package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CyzNavigateCategory;

/**
 * 神的孩子都在歌唱Mapper接口
 * 
 * @author 神的孩子都在歌唱
 * @date 2023-09-26
 */
public interface CyzNavigateCategoryMapper 
{
    /**
     * 查询神的孩子都在歌唱
     * 
     * @param id 神的孩子都在歌唱主键
     * @return 神的孩子都在歌唱
     */
    public CyzNavigateCategory selectCyzNavigateCategoryById(Long id);

    /**
     * 查询神的孩子都在歌唱列表
     * 
     * @param cyzNavigateCategory 神的孩子都在歌唱
     * @return 神的孩子都在歌唱集合
     */
    public List<CyzNavigateCategory> selectCyzNavigateCategoryList(CyzNavigateCategory cyzNavigateCategory);

    /**
     * 新增神的孩子都在歌唱
     * 
     * @param cyzNavigateCategory 神的孩子都在歌唱
     * @return 结果
     */
    public int insertCyzNavigateCategory(CyzNavigateCategory cyzNavigateCategory);

    /**
     * 修改神的孩子都在歌唱
     * 
     * @param cyzNavigateCategory 神的孩子都在歌唱
     * @return 结果
     */
    public int updateCyzNavigateCategory(CyzNavigateCategory cyzNavigateCategory);

    /**
     * 删除神的孩子都在歌唱
     * 
     * @param id 神的孩子都在歌唱主键
     * @return 结果
     */
    public int deleteCyzNavigateCategoryById(Long id);

    /**
     * 批量删除神的孩子都在歌唱
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyzNavigateCategoryByIds(Long[] ids);
}
