前言： 

> 大家好，我是神的孩子都在歌唱，这是我[csdn的博客](chenyunzhi.blog.csdn.net) ,
> 这是我做的一个**神唱导航网站项目**，这是一个练习项目，所以还存在很多问题，目的是方便收集和查阅日常浏览的网站，代码完全开源[github](https://github.com/Rodma1/cyz_navication)，含有安装部署教程，欢迎有想法的小伙伴给我提意见



## 一. 目的

1. 有一个自己的导航网站是一件装逼的事情
2. 在完善自己的导航网站中不断学习

## 二. 项目标题和描述

我这个导航的标题叫做   **神唱导航网站**， **神唱**   是   **神的孩子都在歌唱**的简称，**神的孩子都在歌唱**  的名字来源于   **五月天**  的   **神的孩子都在唱歌**



本项目分为前台和后台，前台是展示  **导航网站**， 后台是对  **导航网站** 的增删改查（后台用的ruoyi框架），它们都是**前后端分离项目**

## 三. 使用技术

后端： springboot + mybatis-plus  + postgresql + redis 



## 四. 安装部署

### 4.1 环境



| 环境            | 版本           |
| --------------- | -------------- |
| 一台linux服务器 | centos7        |
| postgres        | 14.6           |
| redis           | 6.2.6          |
| java            | 1.8            |
| python          | 3.7            |
| vue             | @vue/cli 5.0.8 |
| node            | v16.14.0       |
| npm             | 8.3.1          |



### 4.2 前台


![请添加图片描述](https://i-blog.csdnimg.cn/direct/425784cbc6f04355a4a4ea87dc01979c.png)




[后端代码](https://github.com/Rodma1/cyz_navication/tree/navication_v1.0.0)

[前端代码](https://github.com/Rodma1/cyz_navication/tree/navication_ui_v1.0.0)

拉取前后端代码

#### 4.2.1 后端代码打包

使用idea打开项目，在配置文件里面修改你的数据库密码

![请添加图片描述](https://i-blog.csdnimg.cn/direct/1a01c4150bb6461fb7e55fbc2ce455e2.png)




打成jar，可以使用命令   **java -jar 文件名.jar**  测试运行

#### 4.2.2 前端代码打包

进入到下载好的前端目录下运行

安装依赖
`npm install`

打包  `npm run build`

### 4.3 后台
[后台代码](https://github.com/Rodma1/cyz_navication/tree/navication_admin_v1.0.0)
后台用的ruoyi框架 ,[部署打包可以参考若依](http://doc.ruoyi.vip)，方便对**导航网站**的增删改查

![请添加图片描述](https://i-blog.csdnimg.cn/direct/02f6b9229c2f454dae237c8ad9f81b6c.png)




#### 4.3.1 后端代码打包linux中查看nginx版

修改profile和websiteInfo的路径

![请添加图片描述](https://i-blog.csdnimg.cn/direct/1eb2575e007647be956a3f2e3d2a928f.png)


修改redis和数据库的用户和密码

打成jar，可以使用命令   **java -jar 文件名.jar**  测试运行



#### 4.3.2 前端代码打包

进入到下载好的前端目录下运行

安装依赖
`npm install`

打包  `npm run build:prod`

### 4.4 项目部署linux服务器

以下是我部署的方法，大家可以当做参考

#### 4.4.1 后端



在 `/etc/systemd/system`目录下建立一个 `navicate_admin.service` 在里面配置如下信息,修改以下你的jar包路径就可以

```shell
[Unit]
Description=navication
After=network.target

[Service]
User=root
ExecStart=/usr/bin/java -jar /project/navicate/navicate_admin/ruoyi-admin.jar
SuccessExitStatus=143
Restart=always

[Install]
WantedBy=multi-user.target
```

配置好了后就可以通过以下方式启动和关闭服务了

```shell
systemctl start navicate_admin.service
systemctl restart navicate_admin.service
systemctl status navicate_admin.service
```



#### 4.4.2 前端

需要下载nginx，然后参考我的如下配置

```shell
server {
        listen        80;
        server_name localhost;

        location / {
            #root html;
            root   /chenyunzhi/project/navicate/navicate_web/dist;
            index  index.html index.htm;
            #proxy_pass http://localhost:8089/;
        }
        location /api/ {
           proxy_pass http://localhost:8089/;
        }
        location /profile/ {
           alias   /chenyunzhi/project/navicate/navicate_admin/uploadPath/;
        }

    }

```



在重启nginx就能生效了  **./nginx -s reload**



> /usr/nginx/conf

访问： http://localhost/#/menu



> 以上前台的部署配置，后台前端的同理

## 五. 感谢



后台使用了[ruoyi](https://gitee.com/y_project/RuoYi)的开源管理框架，非常感谢



## 六  需要实现的功能

1. 后台新增导航网站只需要输入网站url就可以自动获取网站图标和标题的脚本（已完成,有些网站没法获取图标）
2. 自动添加默认图标  

> 作者：神的孩子都在歌唱
>
> 本人博客：https://blog.csdn.net/weixin_46654114
>
> 转载说明：务必注明来源，附带本人博客连接。
