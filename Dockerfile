FROM openjdk 
RUN yum install -y \
    git \
    ant \
    && yum clean all
COPY buildenv /tmp/buildenv
RUN pushd /tmp/buildenv \
    && ant \
    && mkdir /opt/buildenv/ \
    && cp /tmp/buildenv/dist/lib/TaskFromPipe.jar /opt/buildenv/ \
    && rm -rf /tmp/buildenv
ENV CLASSPATH=/usr/share/ant/lib/ant.jar
ENTRYPOINT [ "java", "-jar", "/opt/buildenv/TaskFromPipe.jar" ]