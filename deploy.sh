#!/usr/bin/env bash

mvn clean package

rm /home/dogmell/jetty/webapps/root.war

cp target/root.war /home/dogmell/jetty/webapps