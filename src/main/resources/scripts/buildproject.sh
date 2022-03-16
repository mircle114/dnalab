cd $MyHome

mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app-test -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

tree

#javac -d src/main/classes/ $(find src/main/java -name '*.java') && java -classpath src/main/classes/ com.dnavault.DnaExecCommand