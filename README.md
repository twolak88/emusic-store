#eMusic Store

##Spring 5

## databse:
docker pull oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -v ~/prog/docker/data/H2:/opt/h2-data --name=MyH2Instance oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -v ~/prog/docker/data/H2:/opt/h2-data -e H2_OPTIONS='-ifNotExists' --name=MyH2Instance oscarfonts/h2