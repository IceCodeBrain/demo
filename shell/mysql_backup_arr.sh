#!/bin/bash
#保存备份个数
number=7
#日期
date_time=$(date +%Y-%m-%d-%H-%M-%S)
#备份工具
tool="mysqldump"
#用户名
username="root"
#密码
password="123456"
#将要备份的数据库数组
arr=("wuyin" "member_point" "xxl_job")
#备份保存根路径
source_dir="/data/app/env/mysql/backup"
#进入mysql容器命令
mysql_docker_bash="docker-compose -f /data/app/env/docker-compose.yaml exec mysql"
#将要备份的数据库
database_name="wuyin"
#备份保存路径
backup_dir="$source_dir/$database_name"

start() {
  $mysql_docker_bash $tool -h127.0.0.1 -u$username -p$password $database_name >"$backup_dir/$database_name-$date_time.sql"
}

makeLog() {
  #写创建备份日志
  echo "create $backup_dir/$database_name-$date_time.dupm" >>$source_dir/backup.log
  #找出需要删除的备份
  del_file=$(ls -l -crt $backup_dir/*.sql | awk '{print $9 }' | head -1)
  #判断现在的备份数量是否大于$number
  count=$(ls -l -crt $backup_dir/*.sql | awk '{print $9 }' | wc -l)
  if [[ $count -gt $number ]]; then
    #删除最早生成的备份，只保留number数量的备份
    rm "$del_file"
    #写删除文件日志
    echo "delete $del_file" >>$source_dir/backup.log
  fi
}
echo "------------------------Start backup date [$date_time]--------------------------" >>$source_dir/backup.log
for element in ${arr[*]}; do
  database_name=$element
  backup_dir="$source_dir/$database_name"
  #如果文件夹不存在则创建
  if [[ ! -d $backup_dir ]]; then
    mkdir -p "$backup_dir"
  fi
  start
  makeLog
done
echo "------------------------Finish backup date [$date_time]---------------------------" >>$source_dir/backup.log

#系统添加定时任务
#crontab -e
#编辑内容添加  每晚 3点33分执行 例如： 33 3 * * *  /data/app/env/mysql/mysql_backup_one.sh
#crontab -l
#service crond restart  or  systemctl restart crond.service