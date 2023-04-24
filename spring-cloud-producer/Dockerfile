##基于 openjdk:8-jdk-alpine 镜像创建一个新的镜像
FROM openjdk:8-jdk-alpine
##在容器内部创建一个 /app 目录，并设置工作目录为/app
WORKDIR /app
##定义变量JAR_FILE,用于指定JAR文件的位置
ARG JAR_FILE=target/*.jar
##将JAR文件复制到 Docker 镜像中,并将其重命名为app.jar
COPY ${JAR_FILE} app.jar
##创建app用户组和用户,并将/app/app.jar文件的所有权分配给该用户
RUN addgroup -S app && adduser -S app -G app \
    && chown app:app /app/app.jar
##指定app用户运行容器
USER app:app
##定义APP_OPTS环境变量,并将其设置为空字符串,该环境变量将在容器启动时传递给应用程序
ENV APP_OPTS=""
##定义了容器启动时要运行的命令，-Djava.security.egd=file:/dev/./urandom用于解决在某些平台上启动应用程序时可能遇到的问题,$APP_OPTS 变量用于传递应用程序参数
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar $APP_OPTS"]