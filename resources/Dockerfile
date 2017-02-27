# To build and run the Dockerfile -
# docker build -t (image-name) --build-arg version=(version_number) serviceName=(microservice_name). 
# docker run -it --name container-name --rm -p "8080:8080" image-name


FROM anapsix/alpine-java:8_jdk_unlimited
ARG version
ARG serviceName
#Set the version as an environment variable
ENV version=$version
ENV serviceName=$serviceName
# Copy the jar to the container
COPY target/$serviceName-$version.jar /tmp/$serviceName-$version.jar
# Copy common configs to the container
COPY root/config/common/application.yml /root/config/common/application.yml
# Expose the service port
EXPOSE 8080
# Install curl
RUN apk --no-cache add curl
# Run the jar as an entrypoint command
CMD ["sh", "-c", "java -DAPP_ENV=dev -DCONFIG_FOLDER=/root/config/ -jar /tmp/$serviceName-$version.jar"]
 
RUN echo “Dockerfile from the Service Repository: vzt-nissan-rdlu-api”
