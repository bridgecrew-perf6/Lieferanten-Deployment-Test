ARG LAUFZEITUMGEBUNG="build"
ARG API_BASEURL="http://db907f3a697198fae10dc93ba55e3d75.balena-devices.com:8080"
FROM node:latest as build-step

ENV APIBASEURL=${API_BASEURL}

RUN mkdir -p /app

WORKDIR /app

COPY package.json /app/

RUN npm install

COPY . /app

VOLUME /app
CMD ["ng", "${LAUFZEITUMGEBUNG}" , "--configuration=production"]


#final stage
FROM nginx:alpine
COPY --from=build-step /app/dist/Lieferanten/ /usr/share/nginx/html


#ADD default.conf /etc/nginx/conf.d/default.conf

EXPOSE 4200
EXPOSE 80
EXPOSE 443

VOLUME /var/www/html
