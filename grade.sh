# Create your grading script here

set -e

rm -rf student-submission
git clone $1 student-submission

FILE=student-submission/ListExamples.java
if [ -f "$FILE" ]; then
    echo "$FILE exists."
else 
    echo "$FILE does notexists."
    exit
fi

rm -rf student-test
mkdir student-test
cp TestListExamples.java student-test
cp student-submission/ListExamples.java student-test
cp lib/hamcrest-core-1.3.jar student-test
cp lib/junit-4.13.2.jar student-test

cd student-test
javac -cp .:hamcrest-core-1.3.jar:junit-4.13.2.jar *.java
if [[ $? -eq 0 ]]; then 
    echo "Succefully Compliled"
else
    echo "Compile Error"
    javac -cp .:hamcrest-core-1.3.jar:junit-4.13.2.jar *.java > error.txt
    exit
fi

set +e
java -cp .:hamcrest-core-1.3.jar:junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > output.txt

tail -3 output.txt > report.txt
cat report.txt





