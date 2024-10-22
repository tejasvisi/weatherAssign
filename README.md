"# weatherAssign" 







---

## Features

- Fetch weather information based on a **pincode** and **date**.
- Store fetched weather data in an RDBMS (H2).
- Optimize future requests by retrieving data from the database if it's already stored.


---


---

## Project Setup

Follow these steps to get the project up and running:

1. **To Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/weatherassign.git
   ```

2. **If Configure own API Keys**:
   Open `WeatherPincodeService.java` and replace `"your_openweather_api_key"` with your actual OpenWeather API key:
   ```java
   private final String GEOCODING_API_KEY = "your_openweather_api_key";
   private final String WEATHER_API_KEY = "your_openweather_api_key";
   ```



4. **Access the H2 Console**:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - username: sa
   - password:


  
   
---

## API Endpoints

### 1. **Get Weather Information**

- **URL**: `/api/weather/pin`
- **Method**: `GET`
- **Description**: Fetch weather information for a given pincode and date.
  
  **Query Parameters**:
  - `pincode`: Postal code (e.g., 273408)
  - `for_date`: Date in `YYYY-MM-DD` format
  
  **Example Request**:
  ```bash
  GET http://localhost:8080/api/weather/pincode?pincode=273408&for_date=2024-10-21
  ```

  **Response**:
  ```json
  {
    "pincode": "273408",
    "latitude": 26.1559,
    "longitude": 83.0234,
    "temperature": 298.06,
    "humidity": 56.0,
    "weatherDescription": "clear sky",
    "date": "2024-10-21"
}
  ```

---

## Database

- **H2 Database**: The project uses H2 by default for development and testing. You can check the database using the **H2 Console**.
  
  - **H2 Console URL**: `http://localhost:8080/h2-console`
  - **JDBC URL**: `jdbc:h2:mem:testdb`
  

---

## Testing

You can test the API using **Postman**.

### Example Test via Postman:

1. **Method**: `GET`
2. **URL**: `http://localhost:8080/api/weather/pin`
3. **Query Parameters**:
   - `pincode`: 273408
   - `for_date`: 2024-10-21
4. **Expected Response**:
   ```json
   {
    "pincode": "273408",
    "latitude": 26.1559,
    "longitude": 83.0234,
    "temperature": 298.06,
    "humidity": 56.0,
    "weatherDescription": "clear sky",
    "date": "2024-10-21"
}
   ```

---



## Visual references
![ss1](https://github.com/user-attachments/assets/39b8dd9d-524c-4622-bb54-704616f740a1)
![ss2](https://github.com/user-attachments/assets/fe4ffcc7-3d71-4f0a-973f-b15d50ad8f6b)
![ss3](https://github.com/user-attachments/assets/1ea728f6-f42b-48ae-b7f2-10ec8567399c)


