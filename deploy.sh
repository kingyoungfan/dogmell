#!/usr/bin/env bash

mvn clean package
scp target/root.war root@47.94.223.147:/home/dogmell/build