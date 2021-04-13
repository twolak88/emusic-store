#eMusic Store

##Spring 5

## databse:
docker pull oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -v ~/prog/docker/data/H2:/opt/h2-data --name=MyH2Instance oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -v ~/prog/docker/data/H2:/opt/h2-data -e H2_OPTIONS='-ifNotExists' --name=MyH2Instance oscarfonts/h2

## logs - vm start params:
-Dlogs.dir="/home/twolak/prog/eclipse_workspaces/spring_01/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/logs" 
-Dlogs.fileName="EmusicStoreTraces.log"