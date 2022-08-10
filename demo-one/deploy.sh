#打包完后的jar名称，替换成你自己项目的名称，该名称可以在maven项目的pom中配置
proc="demo"
#项目的目录地址
SOURCE_HOME="/opt/app/$proc"
#日志地址
APP_LOG="$SOURCE_HOME/logs/$proc.log"
#环境配置 用户配置开发(dev)，测试(test)，生产(prod)的配置文件，避免频繁改动
PROFILES_ACTIVE="spring.profiles.active=alpha"
#JVM启动参数，关于JVM调优这里不介绍，感兴趣的可以自行百度 JVM调优
JAVA_OPTS="-server -Xms512M -Xmx512M -Xss256k -Xmn256m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$SOURCE_HOME/logs/jvm/dump"
app_pid=0
#检查进程是否存在
checkPid() {
  #is_pid=$(pgrep -f "$proc")
  #is_pid=$(ps -ef | grep -n $proc | grep java | grep -v grep | awk '{print $2}')
  is_pid=$(ps -ef | grep -n $proc | grep java | grep -v grep | awk '{print $2}')
  echo "===========is_pid=$is_pid============"
  if [ -n "$is_pid" ]; then
    app_pid=$is_pid
  else
    app_pid=0
  fi
}

#编写启动方法
start() {
  checkPid
  if [ $app_pid -ne 0 ]; then
    echo "================================"
    echo "warn: $proc already started! (pid=$app_pid)"
    echo "================================"
  else
    echo "Starting $proc ..."
    #到项目目录
    cd $SOURCE_HOME || exit
    #输出，准备启动
    APP_CLASS="$proc.jar"
    #启动脚本，--spring.profiles.active=   用于设置环境所使用的配置文件
    JAVA_CMD="java $JAVA_OPTS -jar $APP_CLASS --$PROFILES_ACTIVE &"
    #后台运行
    $JAVA_CMD &
    sleep 1
    checkPid
    if [ $app_pid -ne 0 ]; then
      echo "======================================"
      echo "$proc Start Success! (pid=$app_pid)[OK]"
      echo "======================================"
    else
      echo "[Failed]"
    fi
  fi

}

#查看日志
showLog() {
  tail -50f $APP_LOG
}

#停用项目
stop() {
  checkPid

  if [ $app_pid -ne 0 ]; then
    echo -n "Stopping $proc ...(pid=$app_pid) "
    kill -9 $app_pid

    if [ $? -eq 0 ]; then
      echo "[OK]"
    else
      echo "[Failed]"
    fi

    checkPid
    if [ $app_pid -ne 0 ]; then
      stop
    fi
  else
    echo "================================"
    echo "warn: $proc is not running"
    echo "================================"
  fi
}

#项目状态
status() {
  checkPid
  if [ $app_pid -ne 0 ]; then
    echo "$proc is running! (pid=$app_pid)"
  else
    echo "$proc is not running"
  fi
}

#设置脚本参数，启动的时候可以采用./脚本名称.sh start/stop/restart/log/status等参数
#-bash: ./deploy.sh: Permission denied                    chmod 755 deploy.sh    chmod 777 deploy.sh
case "$1" in
start)
  start
  ;;
stop)
  stop
  ;;
log)
  showLog
  ;;
status)
  status
  ;;
restart)
  stop
  start
  ;;
esac
