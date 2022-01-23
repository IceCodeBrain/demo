#!/bin/bash
# @desc: mysql daily backup

# backup mysql
#/usr/local/bin/docker-compose -f /data/app/env/docker-compose.yaml exec mysql sh -c "/usr/bin/mysqldump -uroot -pxianlin@123 -h127.0.0.1 --databases wuyin xxl_job > /etc/mysql/conf.d/sql/wuyin.$(date +%F).sql"
/usr/bin/docker exec env_mysql_1 /usr/bin/mysqldump -uroot -p123456 -h127.0.0.1 --databases wuyin member_point xxl_job > /root/archives/mysql/wuyin.$(date +%F).sql
cd /root/archives/mysql/ || exit
#mv /data/app/env/mysql/conf/sql/wuyin.$(date +%F).sql .
ls . | sort -r | sed -n '16,$p' | xargs -n 1 -I {} rm {}

# backup redis
cd /root/archives/redis || exit
tar -C / -zcf redis.$(date +%F).tgz data/app/env/redis
ls . | sort -r | sed -n '16,$p' | xargs -n 1 -I {} rm {}

# backup zookeeper
cd /root/archives/zookeeper
tar -C / -zcf zookeeper.$(date +%F).tgz data/app/env/zookeeper
ls . | sort -r | sed -n '16,$p' | xargs -n 1 -I {} rm {}

# backup mongo
cd /root/archives/mongo || exit
tar -C / -zcf mongo.$(date +%F).tgz data/app/env/mongo
ls . | sort -r | sed -n '8,$p' | xargs -n 1 -I {} rm {}
#docker-compose -f /data/app/env/docker-compose.yaml exec mongo mongodump --username root --password xianlin@123 --authenticationDatabase admin --db wuyin --out wuyin.$(date +%F)
#docker-compose -f /data/app/env/docker-compose.yaml exec mongo mongodump --username root --password xianlin@123 --authenticationDatabase admin --db admin --out admin.$(date +%F)
#ls . | grep wuyin |  sort -r | sed -n '8,$p' | xargs -n 1 -I {} rm -rf {}
#ls . | grep admin |  sort -r | sed -n '8,$p' | xargs -n 1 -I {} rm -rf {}
