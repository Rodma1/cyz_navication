package com.ruoyi.system.service.impl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.common.utils.uuid.Seq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
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

    @Autowired
    @Qualifier("asyncExecutor")
    private TaskExecutor taskExecutor;
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
        cyzNavigateSite.setDelFlag("0");
        asyncInsertNavigateSite(cyzNavigateSite);
        return 1;
    }

    @Async
    public void asyncInsertNavigateSite(CyzNavigateSite cyzNavigateSite) {
        taskExecutor.execute(() -> {
            String url = cyzNavigateSite.getUrl();

            // 如果没有输入图片logo和标题就自动获取
            if (StringUtils.isNotBlank(cyzNavigateSite.getUrl())) {
                HashMap<String, String> map = websiteLogoTitle(url);
                String title = map.get("title");
                String logoUrl = map.get("logo");
                if (StringUtils.isBlank(cyzNavigateSite.getName()) && StringUtils.isNotBlank(title)) {
                    cyzNavigateSite.setName(title);
                }
                if (StringUtils.isBlank(cyzNavigateSite.getImage()) && StringUtils.isNotBlank(logoUrl)) {
                    logoUrl = imageDownloader(logoUrl);
                    //                保存的时候只保存 /profile/upload/ + logourl
                    if (StringUtils.isNotBlank(logoUrl)) {
                        cyzNavigateSite.setImage("/profile/upload/" + logoUrl);
                    }

                }

            }
            cyzNavigateSiteMapper.insertCyzNavigateSite(cyzNavigateSite);
        });
    }

    /**
     * 获取网站的logo和标题
     * @return
     */
    public HashMap<String,String> websiteLogoTitle(String url) {
        HashMap<String, String> map = new HashMap<>();

        try {
            // 指定你的 Python 脚本路径
            String pythonScriptPath = RuoYiConfig.getWebsiteInfo();
            String command = "python3 " + pythonScriptPath +" " + url;

            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String title = null;
            String logoUrl = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("网站标题:")) {
                    title = line.replace("网站标题:", "").trim();
                } else if (line.startsWith("网站Logo链接:")) {
                    logoUrl = line.replace("网站Logo链接:", "").trim();
                }
            }
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Python 脚本执行成功");
                map.put("title",title);
                map.put("logo",logoUrl);
            } else {
                System.err.println("Python 脚本执行失败");
            }
        } catch (IOException | InterruptedException e) {
            return map;
        }
        return map;
    }


    /**
     * 下载图片
     * @param imageUrl
     * @return
     * @throws IOException
     */

    public String imageDownloader(String imageUrl){


        // 要上传的路径，为了迎合ruoyi的代码这里加上 upload
        String destinationPath = RuoYiConfig.getProfile() + "upload/";
        String fileExtension = getFileExtension(imageUrl);
        boolean allowedExtension = FileUploadUtils.isAllowedExtension(getFileExtension(imageUrl), MimeTypeUtils.IMAGE_EXTENSION);
        if (!allowedExtension) {
            return null;
        }
        String fileName = StringUtils.format("{}/{}_{}.{}", DateUtils.datePath(),
                "favicon", Seq.getId(Seq.uploadSeqType), fileExtension);

        // 绝对路径
        String absPath = FileUploadUtils.getAbsoluteFile(destinationPath, fileName).getAbsolutePath();

        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置连接超时时间
            connection.setConnectTimeout(5000);

            // 打开输入流以读取图片数据
            InputStream inputStream = connection.getInputStream();

            // 创建输出流以将图片写入本地文件
            OutputStream outputStream = Files.newOutputStream(Paths.get(absPath));
            // 从输入流读取数据并写入输出流
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // 关闭输入流和输出流
            inputStream.close();
            outputStream.close();

            System.out.println("图片下载完成");
        } catch (IOException e) {
            return null;
        }
        return fileName;
    }

    public static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
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
