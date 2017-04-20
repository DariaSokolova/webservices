# Maven and Gradle Task

Useful commands for maven:
- checkstyle:check - checkstyle plugin run.
- -P development/ -P production - for different database configuration. Development works works with hsql db, production works with derby db. Development profile is activated by default.
- cobertura:check - cobertura plugin  run.
- mvn -Dmessage="<commit_log_here>" scm:checkin  for git commit. Some others commands can be found here https://maven.apache.org/components/scm/maven-scm-plugin/

Useful commands for gradle:
- -Pprofile=development/-Pprofile=production - for different database configuration. Development works works with hsql db, production works with derby db. Development profile is activated by default.

# Jenkins Task

- Installed Jenkins and SonarQube.
- Configured Jenkins to use local SonarQube installation.
- Configured custom SonarQube quality profile.
- Configured Jenkins to trigger a build on each local commit with the post-commit hook: 
curl -X POST http://{localJenkins}/job/webservices/build?token={tokenName} --user {userName}:{password}

- With each build Unit tests and SonarQube run. If they fails, build fails.
- Notification is sent to configured email address about build results with build log attached. 
- Configured Jenkins security with Role Strategy Plugin: removed anonymous access, created administrator user (all permissions) and developer user (build job, cancel builds).

# webservices

Implemented:

- basics for REST and SOAP
- a bit of Spring HATEOAS.
- swagger. Swaggers docs are accessible from {appAddress}/swagger-ui.html


Not Implemented:

- exception handling.
- transaction support.
- security solutions.
- tests.
