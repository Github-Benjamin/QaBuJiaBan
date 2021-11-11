# 《QA不加班 》   http://www.QAbujiaban.com  


Java 网站开发网站运营后台管理和用户留言板功能


后端：Spring Boot

前端：Bootstrap、Echart插件等

数据库：MySQL（MyBatis-Spring）

服务端：Centos、Nginx、Tomcat（SpringBoot集成）



# 管理后台功能说明

1、登陆：固定用户登陆，校验session拦截对管理接口鉴权

2、管理页：使用后台管理模板，集成常规管理功能如：留言管理、网站总数据查看，按时间段统计查看等

3、留言管理：展示所有留言、支持分页和上下页、编辑、删除、批量删除、审核总开关；获取请求ip，解析请求ip的城市信息

4、数据看板：网站总数据查看，按时间段统计查看

5、关于页面



# 用户前台功能说明

1、留言页面：提交留言、留言查看

2、提交留言：用户名、留言内容、验证码生成与校验

3、留言查看：排序、分页、筛选审核状态

4、页面头和底部信息



#  Service 服务后端  技术简要说明

1、运用SpringBoot中的@WebFilter注解，实现全局拦截指定Url；设置和校验Session中的值判断是否已登录

2、运用SpringBoot响应Resources中的静态信息文件（html、js等）

3、调用Mybatis对Mysql数据库中的数据进行：增、删、改、查（排序、分页）操作

4、SpringBoot对Mysql的事务管理，使用@Transactional注解实现，若程序异常则对增、删、改进行实现自动回滚功能

5、获取Request中的ip信息，此次引用多种方法兼容防止被代理后获取ip无效，这里主要是Nginx代理单个方法无法获取请求真实ip

6、解析请求ip的城市信息，这里使用高德API提供的方法实现

7、验证码根据请求Session判断不同用户，后生成随机数字验证码，校验提交的留言验证码是否正确



#  Browser 前端 技术简要说明

1、主要使用Bootstrap框架实现绝大部分页面UI效果图

2、使用Echart插件实现图表统计模块

3、使用laydate插件实现日历选择功能

4、使用Jquery插件实现ajax请求实现Service后端数据交互功能；如：设置分页、CheckBox批量选择等




# 项目部署调试篇

1.本地调试：idea + 运行环境配置；此处略

2.服务器部署篇：Centos、Nginx、Tomcat（SpringBoot集成）

解释：主要通过Nginx反向代理其他不同的内部服务端口，实现多个端口共同向外提供80端口服务


Nginx.conf：

    upstream mysvr {
	    server 127.0.0.1:8089;
	    # server 127.0.0.1:8088 backup;
    }

    limit_req_zone $binary_remote_addr zone=mylimit:1m rate=50r/s;
 
    server {
        listen       80;
        server_name  localhost;

        location / {
            #root   html;
            #index  index.html index.htm;
            #限流配置 每秒100个请求
            limit_req zone=mylimit burst=50 nodelay;
            proxy_pass http://mysvr/;
            proxy_set_header Host $http_host;
	        proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header REMOTE-HOST $remote_addr;
	        proxy_set_header X-Forw $proxy_add_x_forwarded_for;
        }

	    location ^~ /benjamin/ {
	        proxy_pass http://localhost:8088;
 	        proxy_set_header Host $http_host;
            proxy_set_header X-Real-IP $remote_addr;
	        proxy_set_header REMOTE_ADDR $remote_addr;
            proxy_set_header REMOTE-HOST $remote_addr;
            proxy_set_header X-Forw $proxy_add_x_forwarded_for;
        }

    }



3、sh脚本：获取进程pid、快速打包并启动服务运行


getSprintBootPid.sh

    netstat -anp|grep 8088


restartSprintBoot.sh

    #ps -ef|grep springboot-0.0.1-SNAPSHOT.jar|grep -v grep|xargs kill -9
    #netstat -anp|grep 8080
    #kill -9 pid
    cd Qabujiaban
    mvn -s "settings.xml" clean package
    nohup java -jar target/springboot-0.0.1-SNAPSHOT.jar &
    exit


