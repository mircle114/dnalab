cd $TargetDir

#<<'EXEMPT1' 
if [ -d "$2" ]; then rm -Rf $2; fi

echo 'Maven - Generating: '$2
mvn archetype:generate -DgroupId=$1 -DartifactId=$2 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
echo 'Project generation complete'
echo 'Start compile...'
#EXEMPT1

groupId="$1"
artifactId="$2"
forwardSlash="/"
convertedGroupId=$(echo "${groupId/./"$forwardSlash"}")

# Into the new app folder
echo 'Change dir to '$2
cd $2

#<<'EXEMPT2' 

# Copy code to replace generated code
cp $TemplatesDir/App.java $TargetDir/$2/src/main/java/$convertedGroupId/App.java
cp $TemplatesDir/StarterForm.java $TargetDir/$2/src/main/java/$convertedGroupId/StarterForm.java

echo 'Starting maven install goal...'
mvn install
echo 'Maven install completed'
#EXEMPT2

# Now remove the src path 
echo 'Removing src code...'
if [ -d "src" ]; then rm -Rf "src"; fi

echo 'Running jar file... cd in target' 
cd target
echo 'Loading new app...'
java -cp $2'-1.0-SNAPSHOT.jar' $convertedGroupId.App
echo 'Task Completed'

