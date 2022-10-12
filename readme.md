# TP8 Jeu de l'oie

* Chaïma Boudehane

## Objectifs

Le but de ce TP est d'implémenter le jeu de l'oie (goose game). Il s'agit de coder différentes classes qui permettront l'implémentation de ce jeu : la création du plateau de jeu, l'initialisation des joueurs sur la case départ ainsi que leur mouvement qui dépendront de la valeur obtenue lors du lancer de dés.

## Récupérer le projet

```bash
git@github.com:ChaimaBdh/goose-game.git
```

## Génération et consultation de la documentation

*générer* :

```bash
javadoc -sourcepath src -d docs -subpackages goosegame
```

*consulter* :

Ouvrir le fichier **index.html** situé dans le dossier **/docs** dans le navigateur.


## Compilation des sources du projet

```bash
javac -sourcepath src -d classes src/goosegame/*.java
```

<!-- ## Compilation et exécution des tests

*compiler* :

```bash
javac -classpath test4poo.jar test/goosegame/*.java
```

*exécuter* :

```bash
java -jar test4poo.jar goosegame.BasicCellTest
``` -->

## Production du jar exécutable

```bash
jar cvfe goosegame.jar goosegame.GameMain -C classes goosegame
```

## Exécution du programme

*sans fichier .jar* :

```bash
java -classpath classes goosegame.GameMain 3
```

*avec le fichier .jar* :

```bash
java -jar goosegame.jar 3
```

**NB : le jeu est programmé pour 3 joueurs afin de rester fidèle à la trace de la partie du sujet**
