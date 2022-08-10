#!/bin/bash
# @desc: mysql daily backup

# backup mysql
/usr/bin/mysqldump -uroot -pHswy@DB.806 -h localhost --databases demo > /root/data_backup/mysql/demo.$(date +%F).sql
cd /root/data_backup/mysql/ || exit
#mv /data/app/env/mysql/conf/sql/wuyin.$(date +%F).sql .
ls . | sort -r | sed -n '16,$p' | xargs -n 1 -I {} rm {}


#系统添加定时任务
#crontab -e
#编辑内容添加  每晚 3点33分执行 例如： 33 3 * * *  /opt/shell_file/data-backup.sh
#crontab -l
# 开启服务
#sudo service cron start
# 查看服务状态
#sudo  service cron status
# 停止服务
#sudo service cron stop
# 重启服务
#sudo service cron restart
