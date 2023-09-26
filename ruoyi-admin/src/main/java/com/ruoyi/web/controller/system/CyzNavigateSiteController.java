package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.CyzNavigateCategory;
import com.ruoyi.system.service.ICyzNavigateCategoryService;
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
import com.ruoyi.system.domain.CyzNavigateSite;
import com.ruoyi.system.service.ICyzNavigateSiteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 导航网站Controller
 *
 * @author ruoyi
 * @date 2023-09-26
 */
@RestController
@RequestMapping("/system/site")
public class CyzNavigateSiteController extends BaseController
{
    @Autowired
    private ICyzNavigateSiteService cyzNavigateSiteService;

    /**
     * 查询导航网站列表
     */
    @PreAuthorize("@ss.hasPermi('system:site:list')")
    @GetMapping("/list")
    public TableDataInfo list(CyzNavigateSite cyzNavigateSite)
    {
        startPage();
        List<CyzNavigateSite> list = cyzNavigateSiteService.selectCyzNavigateSiteList(cyzNavigateSite);
        return getDataTable(list);
    }

    /**
     * 导出导航网站列表
     */
    @PreAuthorize("@ss.hasPermi('system:site:export')")
    @Log(title = "导航网站", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CyzNavigateSite cyzNavigateSite)
    {
        List<CyzNavigateSite> list = cyzNavigateSiteService.selectCyzNavigateSiteList(cyzNavigateSite);
        ExcelUtil<CyzNavigateSite> util = new ExcelUtil<CyzNavigateSite>(CyzNavigateSite.class);
        util.exportExcel(response, list, "导航网站数据");
    }

    /**
     * 获取导航网站详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:site:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cyzNavigateSiteService.selectCyzNavigateSiteById(id));
    }

    /**
     * 新增导航网站
     */
    @PreAuthorize("@ss.hasPermi('system:site:add')")
    @Log(title = "导航网站", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CyzNavigateSite cyzNavigateSite)
    {
        return toAjax(cyzNavigateSiteService.insertCyzNavigateSite(cyzNavigateSite));
    }

    /**
     * 修改导航网站
     */
    @PreAuthorize("@ss.hasPermi('system:site:edit')")
    @Log(title = "导航网站", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CyzNavigateSite cyzNavigateSite)
    {
        return toAjax(cyzNavigateSiteService.updateCyzNavigateSite(cyzNavigateSite));
    }

    /**
     * 删除导航网站
     */
    @PreAuthorize("@ss.hasPermi('system:site:remove')")
    @Log(title = "导航网站", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cyzNavigateSiteService.deleteCyzNavigateSiteByIds(ids));
    }
}
