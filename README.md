# Jenkins Task

- Installed Jenkins and SonarQube.
- Configured Jenkins to use local SonarQube installation.
- Configured custom SonarQube quality profile.
- Configured Jenkins to trigger a build on each local commit with the post-commit hook: 
curl -X POST http://localhost:8084/job/webservices/build?token={tokenName} --user {userName}:{password}

- With each build Unit tests and SonarQube run. If they fails, build fails.
- Notification is sent to configured email address about build results with build log attached. 
- Configured Jenkins security with Role Strategy Plugin: rRemoved anonymous access, created administrator user (all permissions) and developer user (build job, cancel builds).

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
