```bash
docker run -d --name postgresql -p 5433:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=12345 -e POSTGRES_DB=AuthDB postgres:16
```

```bash
docker run -d --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=12345 mongo:latest
```

```bash
docker run -d --name microservice-redis -p 6379:6379 redis 
```

```bash
docker run -d --name redis-gui -p 8001:8001 redislabs/redisinsight:1.14.0 
```