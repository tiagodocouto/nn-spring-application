# BUILD PHASE
FROM gradle:jdk17 as build-image

ARG BUILD_DATE
ARG VCS_REF
LABEL mainteiner="tiago.couto@nn.nl"\
      org.label-schema.build-date=$BUILD_DATE \
      org.label-schema.name="NN Spring App" \
      org.label-schema.description="NN Onboarding Exercise, made on Java + Spring" \
      org.label-schema.url="https://github.com/tihlok/nn-spring-application" \
      org.label-schema.vcs-ref=$VCS_REF \
      org.label-schema.vcs-url="https://github.com/tihlok/nn-spring-application" \
      org.label-schema.version="latest" \
      org.label-schema.schema-version="latest"

WORKDIR /tmp
COPY --chown=gradle:gradle . .

ENV SPRING_PROFILES_ACTIVE="docker"
RUN gradle --no-daemon bootJar

# ENTRY PHASE
FROM openjdk:17.0.1 

WORKDIR /app
COPY --from=build-image /tmp/build/libs/*-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-jar", "./app.jar"]
EXPOSE 9001
