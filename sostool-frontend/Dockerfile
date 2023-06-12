FROM node:alpine

WORKDIR /frontend

COPY *.json ./
COPY karma.conf.js ./

RUN npm i
RUN npm install -g @angular/cli
