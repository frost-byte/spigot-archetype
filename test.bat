@echo off

if not exist test\NUL mkdir test
cd test
mvn -X archetype:generate -DarchetypeArtifactId=spigot-archetype ^
                       -DarchetypeGroupId=net.frost-byte.maven   ^
                       -DarchetypeVersion=0.1.0-SNAPSHOT         ^
                       -DartifactId=test-plugin                  ^
                       -DgroupId=net.frost-byte                  ^
                       -DjavaVersion=1.8                         ^
                       -DmainClass=TestMain                      ^
                       -DpluginAuthor=frost-byte                 ^
                       -DpluginDescription="Test Plugin"         ^
                       -DpluginName=TestPlugin                   ^
                       -DpluginWebsite=https://www.spigotmc.org  ^
                       -DspigotVersion=1.14.2-R0.1-SNAPSHOT      ^
                       -Dversion=0.0.1-SNAPSHOT
cd ..
