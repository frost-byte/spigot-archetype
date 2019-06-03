@echo off

set %1
set %2
set %3
set %4
set %5
set %6
REM Usage: test.bat "NAME=MyPlugin" "GROUPID=com.my.domain" "ARTIFACTID=myplugin" "AUTHOR=myname" "DESC=My Plugin's Description" "COMMAND=myplugin"
echo name: %NAME%
echo groupId: %GROUPID%
echo artifactId: %ARTIFACTID%
echo author: %AUTHOR%
echo description: %DESC%
echo command: %COMMAND%

if not exist %pluginName%\NUL mkdir %pluginName%
cd %pluginName%
CALL mvn -X archetype:generate ^
  "-DarchetypeArtifactId=spigot-archetype"    ^
  "-DarchetypeGroupId=net.frost-byte.maven"   ^
  "-DarchetypeVersion=0.1.0-SNAPSHOT"         ^
  "-DartifactId=%ARTIFACTID%"                 ^
  "-DgroupId=%GROUPID%"                       ^
  "-DjavaVersion=1.8"                         ^
  "-DmainClass=%NAME%"                        ^
  "-DpluginAuthor=%AUTHOR%"                   ^
  "-DpluginDescription=%DESC%"                ^
  "-DpluginName=%NAME%"                       ^
  "-DcommandAlias=%COMMAND%"                  ^
  "-DpluginWebsite=https://www.spigotmc.org"  ^
  "-DspigotVersion=1.14.2-R0.1-SNAPSHOT"      ^
  "-Dversion=0.0.1-SNAPSHOT"
cd ..
