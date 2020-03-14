#!/bin/bash

sudo docker pull frmnjn/restapi
#sudo docker rm restapi --force
sudo docker run restapi --name restapi -p 8080:8080 -d frmnjn/restapi
