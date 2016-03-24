# MasterMind


cd mastermind/server
run the dynamic server : java -Djava.security.policy=server.policy -Djava.rmi.server.codebase=file:///.../www/ MasterMindServerMain
cd .../www 
run the client (we had problem with the dynamic client but the static one run well) 
java -Djava.security.policy=client.policy

insert the combinaison for example BYYR
