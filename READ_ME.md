# Running docker (DB, Keycloak)
- docker-compose up

# Run only keycloak with Docker CE
# mapping to 9090 because our spring boot app is also run at 8080
docker run --name keycloak -p 9090:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev

# Check Docker images: 
docker ps
# Start Docker image:
docker start keycloak
# Stop Docker image
docker stop keycloak