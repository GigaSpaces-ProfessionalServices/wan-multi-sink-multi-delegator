#!/bin/bash
mkdir -pf /tmp/h2fs
docker pull oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -v /tmp/h2fs:/opt/h2-data --name=testh2instance  oscarfonts/h2
docker logs -f testh2instance

