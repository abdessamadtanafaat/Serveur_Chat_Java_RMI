# Serveur de Chat Java RMI

## Description

Ce projet implémente un serveur de chat basé sur Java RMI (Remote Method Invocation) qui permet la communication en temps réel entre plusieurs clients distants. Le serveur gère l'enregistrement des clients, l'envoi de messages à tous les clients connectés, et la gestion des connexions et déconnexions.

Les fonctionnalités incluent :
- Connexion des clients au serveur via RMI.
- Envoi de messages à tous les clients connectés.
- Envoi de messages privés à un client spécifique.
- Déconnexion propre d'un client avec notification aux autres utilisateurs.
- Gestion de l'exportation et de la suppression des objets distants pour libérer les ressources.
