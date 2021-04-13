Compile: mvn clean compile install
Run: java -jar -Dspring.profiles.active=mysql target/spring-boot-rest-student-0.5.0.war

Student:
To add a student:

http://localhost:8090/example/v1/student
Content-Type: application/json

{"studentId":"1","firstName":"FN1","lastName":"LN1","className":"3 A", "nationality":"Singapore"}

To list all students:
http://localhost:8090/example/v1/student

List by id:
http://localhost:8090/example/v1/student/{id}


Semester:
To add a semester:

http://localhost:8090/example/v1/student/semester
Content-Type: application/json

{"semesterId":"111111","semesterName":"SemesterName1"}

To list all semesters:
http://localhost:8090/example/v1/student/semester

List by id:
http://localhost:8090/example/v1/student/semester/{id}