# Spigot Archetype
Maven archetype for creating Spigot plugins.

## Usage
To use the archetype locally, clone it and install it to your local repository using the following commands in an empty directory. After that, you may add it to your local catalog.

````
git clone https://github.com/frost-byte/spigot-archetype.git .
mvn install
````

After doing that once, you can generate a new project using:

````
mvn archetype:generate -DarchetypeArtifactId=spigot-archetype -DarchetypeGroupId=net.frost-byte.maven -DarchetypeVersion=0.1.0-SNAPSHOT
````

You can **test** the archetype by running `test.sh` on Linux or
`test.bat` on Windows. A sample project will be set up in
`test/testplugin`.

## Contents

### Files
| File | Description |
| ---- | ----------- |
| `pom.xml` | Your fully configured [Project Object Model](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html). The version number you set here will be inserted into your `plugin.yml` every time you make a build. |
| `src/main/java/[...].java` | Contains your plugin's main class. |
| `src/main/javadoc/overview.html` | Contains general information about your project which will be merged into the overview page of the generated site. Read more:<br>[Maven Javadoc Plugin: "Using Javadoc Resources"](https://maven.apache.org/plugins/maven-javadoc-plugin/examples/javadoc-resources.html)<br>[Oracle's Javadoc Documentation: "Overview Comment Files"](http://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html#CHDGDJAH) |
| `src/main/javadoc/.../package-info.java` | Contains information about this package to be included in the docs. Read more:<br>[Oracle's Javadoc Documentation: "Package Comment Files"](http://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html#packagecomment) |
| `src/main/resources/plugin.yml` | Your plugin description file. Read more: [BukkitWiki: "Plugin YAML"](http://bukkit.gamepedia.com/Plugin_YAML) |

### Maven Build Plugins
**Maven Dependency Plugin**: Moves the final artifact to `test-server/plugins` every time you make a build so that you set up a local test server over there. If you add `maven-assembly-plugin` to create `-jar-with-dependencies.jar` artifacts, add `<classifier>jar-with-dependencies</classifier>` to `<artifactItem>` in this plugin's configuration.

**Maven Javadoc Plugin**: Generates Javadoc.

**Lombok Maven Plugin**: Includes methods and constructors generated by Lombok into the docs. If you remove Lombok from your maven dependencies or the `maven-javadoc-plugin`, you should remove this plugin as well. If you keep `maven-javadoc-plugin` but wish to remove Lombok, make sure to remove `<sourcepath>` from the Javadoc plugin's configuration.
