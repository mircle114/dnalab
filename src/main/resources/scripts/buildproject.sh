cd $MyHome

if [ -d "$1" ]; then rm -Rf $1; fi

mvn archetype:generate -DgroupId=app -DartifactId=$1 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
echo 'Project generation complete'
echo 'Start compile...'

# Into the new app folder
cd $1

# Some clean up and config
if [ -d "src/test" ]; then rm -Rf "src/test"; fi

cp $DnaTemplatesDir/App.java src/main/java/app/App.java
cp $DnaTemplatesDir/StarterForm.java src/main/java/app/StarterForm.java
cp $DnaTemplatesDir/pom.dat pom.xml

mvn install

echo 'Running jar file...' 
cd target
#java -jar $1'-1.0-SNAPSHOT.jar'
java -cp $1'-1.0-SNAPSHOT.jar' App
echo 'Task Completed'

#javac -d $1/classes/ $(find $1/src/main -name '*.java') && java -classpath $1/classes/ com.mycompany.app.App