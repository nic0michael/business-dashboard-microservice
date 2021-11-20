#!/bin/bash

sudo docker run -d --hostname antenna-dashboard --name antenna-dashboard-microservice -p 8085:8085 antenna-dashboard-docker:v1
