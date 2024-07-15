package com.chen.controller.elasticsearch.domin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author chenyunzhi
 * @DATE 2024/7/2 18:02
 * @Description:
 */
@ApiModel("基本操作的请求参数")
@Data
public class OperationCommand {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("ip地址")
    private String hostName;

    @ApiModelProperty("端口")
    private Integer port;

    @ApiModelProperty("协议 http  https")
    private String scheme;


    @ApiModelProperty("操作类别 文档  索引")
    public String operationCategory;

    @ApiModelProperty("操作类型 添加 删除 修改等等")
    public String operationType;

    @ApiModelProperty("索引名")
    public String indexName;


    @ApiModelProperty("索引列表")
    public List<String> indices;

    @ApiModelProperty("文档")
    public String document;

    @ApiModelProperty("文档Id")
    public String documentId;

    @ApiModelProperty("索引别名")
    public String alias;

    @ApiModelProperty("索引别名的写入索引")
    public String aliasWriteIndex;
}
