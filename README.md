# Projet Kata

Ce projet est une application de démonstration qui met en œuvre un système de gestion de réservations. Il comprend un backend développé avec Spring Boot et sécurisé par Spring Security.

## Installation

1. Assurez-vous d'avoir Java 21 installée sur votre système.
2. Clonez ce dépôt sur votre machine locale.
3. Naviguez vers le répertoire `Kata`.
4. Accédez au fichier `application.yml` et configurez les paramètres de base de données selon vos besoins (h2 ou mysql).
5. Ouvrez un terminal et exécutez la commande `./mvnw spring-boot:run` pour lancer le backend.
6. Le backend sera accessible à l'adresse `http://localhost:8080`.


## Utilisation

- Le backend fournit une API REST sécurisée par Spring Security pour gérer les réservations.
- Avant d'utiliser l'API, vous devez créer un utilisateur en envoyant une requête POST à `/api/auth/addUser`.
- Ensuite, vous pouvez générer un token JWT en envoyant une requête POST à `/api/auth/generateToken`. Le token aura une validité de 30 minutes.
- Utilisez ce token pour accéder aux endpoints sécurisés de l'API, comme `/api/delivery`, pour créer de nouvelles réservations ou récupérer la liste des réservations.

## Documentation

- La documentation de l'API du backend est générée automatiquement à partir des annotations Swagger dans le code. Vous pouvez y accéder en naviguant vers `http://localhost:8080/swagger-ui.html` après avoir lancé le backend.

## Tests Unitaires

Le projet Kata comprend également une suite de tests unitaires pour assurer la qualité du code. Les tests unitaires sont écrits en utilisant JUnit et Mockito. Vous pouvez exécuter les tests unitaires en utilisant votre IDE préféré ou en utilisant la commande `mvn test` à partir du répertoire racine du projet.

## Gestion des Exceptions

L'API gère plusieurs exceptions courantes, y compris `MethodArgumentNotValidException`, `HttpMessageNotReadableException` et `DataAccessException`, pour garantir une expérience utilisateur fluide et sécurisée.

## Solution de Persistence des Données avec Spring Data JPA

L'application implémente une solution de persistence des données en utilisant Spring Data JPA. Spring Data JPA simplifie le développement d'applications basées sur JPA en fournissant une abstraction de haut niveau pour interagir avec la couche de persistance.

## Solution de Cache

L'application utilise également une solution de cache pour améliorer les performances, en utilisant CacheManager fourni par Spring Boot.

## Potentielles subtilités

- Assurez-vous que les paramètres de base de données dans `application.yml` correspondent à votre environnement local.

## Auteur

- Yassine Skaou <yassineskaou@gmail.com>
