# Rebuild the project
```bash
./gradlew clean build
```

# Run the project
```bash
./gradlew bootRun
```

# Run the project with Docker
```bash
docker-compose up -d
```
Créer et démarre tous les conteneurs définis dans docker-compose.yml en mode détaché

## Services

### Service app
Ce service est l’application Spring Boot.
Docker utilise le Dockerfile pour :
- Construire une image Docker avec le code de l’application.
- Créer un conteneur à partir de cette image.
- Exposer le port 8080 pour accéder à l’application.
Ce service dépend du service db, ce qui signifie qu’il attend que la base de données soit prête avant de démarrer.

### Service db
Ce service est le conteneur de la base de données PostgreSQL.
- Il utilise l'image postgres:alpine.
- Expose le port 5432 pour les connexions à la base de données.
- Initialise la base de données avec le fichier init.sql (pour créer les tables et insérer des données initiales si nécessaire).
Les données sont stockées dans un volume nommé msReservationPgdata, ce qui garantit que les données sont conservées même si le conteneur est redémarré.

## Autres commandes

- Arrêter les conteneurs sans les supprimer:

    ```bash
    docker-compose stop
    ```

- Arrêter et supprimer les conteneurs et les volumes:

    ```bash
    docker-compose down -v
    ```