package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CyzNavigateCategory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Mapper接口
 *
 * @author 神的孩子都在歌唱
 * @date 2023-09-26
 */
@Repository
public interface CyzNavigateCategoryMapper
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
     * @param cyzNavigateCategory 神的孩子都在歌唱
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
     * 删除
     *
     * @param id 主键
     * @return 结果
     */
    public int deleteCyzNavigateCategoryById(Long id);

    /**
     * 批量删除
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCyzNavigateCategoryByIds(Long[] ids);
}
