cd $MyHome
if [ -d "$1" ]; then rm -Rf $1; fi

#if [ -f "$1" ] ; then
  #  rm -r "$1"


#mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=$1 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
echo 'Project generation complete'
echo 'Start compile...'

# Into the new app folder
#cd $1
#mvn install
#echo 'Task Completed'

#javac -d $1/classes/ $(find $1/src/main -name '*.java') && java -classpath $1/classes/ com.mycompany.app.App