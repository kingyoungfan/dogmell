#!/usr/bin/env bash
echo '******git pull start******'
git pull
echo '******git pull end********'
sh /home/dogmell/jetty/bin/jetty.sh stop

mvn clean package -Dmaven.test.skip=true

rm /home/dogmell/jetty/webapps/root.war

cp target/root.war /home/dogmell/jetty/webapps

sh /home/dogmell/jetty/bin/jetty.sh start
