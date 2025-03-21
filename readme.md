```bash
docker run -d --name postgresql -p 5433:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=12345 -e POSTGRES_DB=AuthDB postgres:16
```

```bash
docker run -d -name mongodb -p 27017:27017 mongodb:latest
```