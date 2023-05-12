# ProjetEISI
Projet du cours élasticité et interopérabilité des systèmes d'information

## Projet :
Pour ce projet, il nous a été demandé une application qui crée des _smart contract_. Les _smart contract_ représentent des _baux ruraux_, un bail rural est composé du nom du propriétaire du terrain, la surface en ares ainsi que les points Gps qui délimitent le terrain.

## Applicatif :
l'application se divise en un client python avec le framework Flask et la librairie folium pour l'affichage de la carte et le relevé des points Gps. Le back est une application SpringBoot qui se connecte au server Ganache pour générer un _smart contract_. La dernière partie est le _smart contract_ pour la blockchaîne Ethereum.

Pour réaliser cette application nous avons utilisé la librairie [_web3j_](https://github.com/web3j/web3j/releases/tag/v3.6.0) et son CLI (_web3j_cli_) ainsi que le compilateur [_sol_c_](https://github.com/ethereum/solidity/releases) que vous trouverez dans le dépôt GIT sous le dossier 
> web3j-3.6.0

 


## Installation :

1. Application python :<br/>
Vous aurez premièrement besoin du framework _Flask_ et des librairies suivantes : folium, pandas, requests.

    Installation du framwork Flask :<br/>

    > pip install Flask

    Installation de la librairie folium :<br/>

    > pip install folium

    Installation de la librairie pandas :<br/>

    > pip install pandas

    Installation de la librairie requests :<br/>

    >pip install request

2. Application Java :<br/>
    Tout d'abord il faut générer la classe java qui va correspondre au smart contract défini dans le fichier.sol. Pour réaliser cette opération il vous faudra ouvrir votre terminal à partir du dossier ou vous avez mis votre fichier solc-windows.exe et le fichier _BailRural.sol_ fourni avec ce TP (disponible aussi dans le répertoire _web3j-3.6.0_). 
    Puis exécutter cette ligne de commande en remplaçant _out_dir_ par le chemin complet du répertoire de destination  :<br/>

    > solc-windows.exe <a>BailRural.sol</a> --bin --abi --optimize -o <a>out_dir</a>
    
    Vous devriez alors avoir deux fichiers dans votre dossier de sortie _<a>out_dir</a>_. Un fichier _<a>file_name.bin</a>_ et un autre fichier _<a>file_name.abi</a>_.

    Enfin l'opération qui gérèrera la classe <a>file_name</a> grace au cli web3j. Ouvrir un terminal a partir du répertoire <a>/bin</a> de web3j, y déposer les fichiers _bin_ et _abi_ précédemment créés, et exécuter la commande suivante :<br/>

    > web3j generate solidity -a <a>./path/filename.abi</a> -b <a>./path/filename.bin</a> -o <a>/path/to/yourSrc/main/java</a> -p <a>package.name</a>

    Une fois toutes ces opérations réalisées, votre application est prête à intéragir avec Ganache.

Pour adapter le code a votre environnement vous aurez aussi besoin de faire les changements suivants au niveau de Java et Python.  
Java : _/nc/unc/smartContractBailRural/webservice/services/EtherumServices.java_  
![image](./image/code_java.png)  
Vous devrez saisir la clé privé de votre wallet que vous aurez au préalable copiée depuis Ganache.  
Pyhton : _/FlaskFolium/main.py_  
![image](./image/code_python.png)
Il faut indiquer ici le chemin complet de votre répertoire contenant le fichier data.geojson

## Amélioration :
Par manque de temps développer, il n'a pas été possible de mettre en place un formulaire permettant de renseignrer le nom du propriétaire et la surface du terrain.

## Fonctionnement :
L'application python permet d'afficher dans une page web la carte de la Nouvelle-Calédonie et plus spécifiquement la commune de Thio.  
![image](./image/page_folium.png)  

Nous avons choisi arbitrairement cette propiété :  
![image](./image/petit_image_satelite.png)  

Nous réalisons un tracer :  
![image](./image/tracer_1.png)  

Après avoir appuyer sur le bouton export la transaction est enregistrée :  
![image](./image/console_backend.png)  

Du côté de Ganache, nous retrouvons cette enregistrement :  
![image](./image/Ganache_1.png)  

Du côté de Ganache, nous retrouvons cette enregistrement :
![image](./image/ganache_1.png)

au niveau des Blocks :
![image](./image/ganache_2.png)

l'enregistrement au niveau des transactions :
![image](./image/ganache_3.png)

Et en dernier les logs sur la transaction :
![image](./image/ganache_log_1.png)
![image](./image/ganache_log_2.png)