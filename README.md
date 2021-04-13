#eMusic Store

##Spring 5

## database:
h2:
docker pull oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -v ~/prog/docker/data/H2:/opt/h2-data --name=MyH2Instance oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -v ~/prog/docker/data/H2:/opt/h2-data -e H2_OPTIONS='-ifNotExists' --name=MyH2Instance oscarfonts/h2

mysql:
docker run --name tw-mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -v ~/prog/docker/data/mysql-emusic:/var/lib/mysql -p 3306:3306 --cap-add sys_nice -d mysql

##active profile
-Dspring.profiles.active=dev
profiles: dev, prod

## logs - vm start params:
-Dlogs.dir="/home/twolak/prog/eclipse_workspaces/spring_01/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/logs" 
-Dlogs.fileName="EmusicStoreTraces.log"

## cache - vm start params:
-Dcache.dir="/home/twolak/prog/eclipse_workspaces/spring_01/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/cache" 