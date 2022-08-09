# 镜像基于java:8
FROM openjdk:8-jre-buster
# 作者
MAINTAINER pwb
ENV TIME_ZONE Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TIME_ZONE /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
#创建项目日志存放的文件夹
RUN mkdir -p /app
# 匿名挂载目录
VOLUME /app
# 项目暴露的端口号
EXPOSE 8080
# 添加环境变量
#ENV JAVA_OPTS="-Xms256m -Xmx512m"
# 将jar包添加到容器中 /app/目录并更名为xxx.jar
ADD ./target/demo-one.jar /app/bootstrap.jar
# 运行jar包命令 "nohup" "&" 可省略
# -Djava.security.egd=file:/dev/./urandom 加速tomcat启动
#ENTRYPOINT ["java","-Xms256m","-Xmx512m","-Djava.security.egd=file:/dev/./urandom","-jar","/app/bootstrap.jar", "--spring.profiles.active=dev", "--server.port=10000"]
ENTRYPOINT ["java","-Xms256m","-Xmx512m","-Djava.security.egd=file:/dev/./urandom","-jar","/app/bootstrap.jar", "--spring.profiles.active=alpha", "--server.port=8080"]
