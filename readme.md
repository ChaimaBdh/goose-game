# TP8 Jeu de l'oie

## Membres du binômes

* Chaïma Boudehane
* Wissal Faty

## Objectifs

Le but de ce TP est d'implémenter le jeu de l'oie (goose game). Il s'agit de coder différentes classes qui permettront l'implémentation de ce jeu : la création du plateau de jeu, l'initialisation des joueurs sur la case départ ainsi que leur mouvement qui dépendront de la valeur obtenue lors du lancer de dés.

## Récupérer le projet

```bash
git clone git@gitlab-etu.fil.univ-lille1.fr:boudehane/boudehane-faty-poo.git
cd boudehane-faty-poo/tp8
```

## Génération et consultation de la documentation

*générer* :

```bash
.../tp8> javadoc -sourcepath src -d docs -subpackages goosegame
```

*consulter* :

Ouvrir le fichier **index.html** situé dans le dossier **/docs** dans le navigateur.


## Compilation des sources du projet

```bash
.../tp8> javac -sourcepath src -d classes src/goosegame/*.java
```

<!-- ## Compilation et exécution des tests

*compiler* :

```bash
.../tp8> javac -classpath test4poo.jar test/goosegame/*.java
```

*exécuter* :

```bash
.../tp8> java -jar test4poo.jar goosegame.BasicCellTest
``` -->

## Production du jar exécutable

```bash
.../tp8> jar cvfe goosegame.jar goosegame.GameMain -C classes goosegame
```

## Exécution du programme

*sans fichier .jar* :

```bash
.../tp8> java -classpath classes goosegame.GameMain 3
```

*avec le fichier .jar* :

```bash
.../tp8> java -jar goosegame.jar 3
```

**NB1 : le jeu est programmé pour 3 joueurs afin de rester fidèle à la trace de la partie du sujet**

**NB2 : il se peut qu'une exception soit lancée lorsqu'une cellule n'est pas reconnue. Cependant le jeu fonctionne correctement et annonce un gagnant si on relance le programme après cette exception.**
