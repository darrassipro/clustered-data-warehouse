# FX Deals Importer (Clustered Data Warehouse)

This Spring Boot app imports FX deal data from a CSV file and stores it in PostgreSQL.

### Run locally
1. `docker-compose up -d`
2. `mvn spring-boot:run`
3. Open `http://localhost:8080/api/import/csv` to upload CSV

### Example curl
```bash
curl -F "file=@sample-deals.csv" http://localhost:8080/api/import/csv
```
Open Postman → click New → Request.

Set method to POST.

URL: http://localhost:8080/api/import/csv.

Go to Body → form-data.

Add a key named file → set type to File → select your CSV file.

Click Send.

You should see the response from the backend.

