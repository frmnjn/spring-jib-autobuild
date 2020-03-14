#!/bin/bash

sudo docker pull frmnjn/restapi
sudo docker rm restapi --force
sudo docker run -p 8080:8080 --name restapi -d frmnjn/restapi:latest
