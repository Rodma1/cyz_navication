package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CyzNavigateCategory;
import com.ruoyi.system.service.ICyzNavigateCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 神的孩子都在歌唱Controller
 *
 * @author 神的孩子都在歌唱
 * @date 2023-09-26
 */
@RestController
@RequestMapping("/system/category")
public class CyzNavigateCategoryController extends BaseController
{
    @Autowired
    private ICyzNavigateCategoryService cyzNavigateCategoryService;

    /**
     * 查询神的孩子都在歌唱列表
     */
    @PreAuthorize("@ss.hasPermi('system:category:list')")
    @GetMapping("/list")
    public AjaxResult list(CyzNavigateCategory cyzNavigateCategory)
    {
        List<CyzNavigateCategory> list = cyzNavigateCategoryService.selectCyzNavigateCategoryList(cyzNavigateCategory);
        return success(list);
    }

    /**
     * 导出神的孩子都在歌唱列表
     */
    @PreAuthorize("@ss.hasPermi('system:category:export')")
    @Log(title = "神的孩子都在歌唱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyzNavigateCategory cyzNavigateCategory)
    {
        List<CyzNavigateCategory> list = cyzNavigateCategoryService.selectCyzNavigateCategoryList(cyzNavigateCategory);
        ExcelUtil<CyzNavigateCategory> util = new ExcelUtil<CyzNavigateCategory>(CyzNavigateCategory.class);
        util.exportExcel(response, list, "神的孩子都在歌唱数据");
    }

    /**
     * 获取神的孩子都在歌唱详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cyzNavigateCategoryService.selectCyzNavigateCategoryById(id));
    }

    /**
     * 新增神的孩子都在歌唱
     */
    @PreAuthorize("@ss.hasPermi('system:category:add')")
    @Log(title = "神的孩子都在歌唱", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CyzNavigateCategory cyzNavigateCategory)
    {
        return toAjax(cyzNavigateCategoryService.insertCyzNavigateCategory(cyzNavigateCategory));
    }

    /**
     * 修改神的孩子都在歌唱
     */
    @PreAuthorize("@ss.hasPermi('system:category:edit')")
    @Log(title = "神的孩子都在歌唱", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyzNavigateCategory cyzNavigateCategory)
    {
        return toAjax(cyzNavigateCategoryService.updateCyzNavigateCategory(cyzNavigateCategory));
    }

    /**
     * 删除神的孩子都在歌唱
     */
    @PreAuthorize("@ss.hasPermi('system:category:remove')")
    @Log(title = "神的孩子都在歌唱", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cyzNavigateCategoryService.deleteCyzNavigateCategoryByIds(ids));
    }
}
