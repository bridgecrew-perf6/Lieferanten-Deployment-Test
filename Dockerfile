#ARG LAUFZEITUMGEBUNG="build"
#ARG API_BASEURL="http://db907f3a697198fae10dc93ba55e3d75.balena-devices.com:8080"
#ARG API_BASEURL="http://localhost:8080"

FROM node:16.13 as build-step

#balenalib/genericx86-64-ext-fedora-node


WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

VOLUME /usr/src/app

#final stage
FROM nginx:alpine
#COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=build-step /usr/src/app/dist/Lieferanten/ /usr/share/nginx/html

EXPOSE 4200
EXPOSE 80
EXPOSE 443

VOLUME /var/www/html


