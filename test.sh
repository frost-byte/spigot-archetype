#!/bin/sh

rm -rf test
mkdir test
cd test
mvn archetype:generate -DarchetypeArtifactId=spigot-archetype    \
                       -DarchetypeGroupId=net.frost-byte.maven   \
                       -DarchetypeVersion=0.1.0-SNAPSHOT         \
                       -DartifactId=testplugin                   \
                       -DgroupId=net.frost-byte.test             \
                       -DjavaVersion=1.8                         \
                       -DmainClass=TestMain                      \
                       -DpluginAuthor=frost-byte                 \
                       -DpluginDescription='Little test plugin'  \
                       -DpluginName=MyTestPlugin                 \
                       -DpluginWebsite=https://www.spigotmc.org  \
                       -DspigotVersion=1.8.8-R0.1-SNAPSHOT       \
                       -Dversion=0.0.1-SNAPSHOT
cd ..
