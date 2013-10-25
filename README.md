Artist-manager-model
====================

Projet representant le modele de l'application web artist-manager. Il est présenté sous la
forme d'une archive jar qu'il est possible de deployer sur une conteneur lourd via ant.

Cependant, ce projet est lié à Artist-manager qui représente la WebApp. Ils sont liés et necessaire à l'élaboration
de l'archive ear (voir script déploiemen build.xml de artist-manager)

Logiciels necessaires
====================
<ul>
<li>Ant</li>

<li>JDK >= 1.6</li>

<li>Conteneur qui supporte l'interface EJB ( JONAS , JBoss ,  Glassfish )</li>
</ul>

Pré-requis d'installation
====================
Configurer dans le JNDI un lien vers une base de donnée HSQLDB (://DefaultDS - voir persistence.xml)

OU

Utilisation de <a href='http://www.jboss.org/jbossas/downloads/' >JBoss AS 6</a> qui implémente au démarrage une base de donnée HSQLDB par défaut.


Auteurs
===================
Deux étudiants ingénieurs de l'ESIEA pour le projet programmation web:
  <ul>
    <li>Nicolas Lebec</li>
    <li>Remy Ouadah</li>
  </ul>
  
