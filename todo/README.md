## ToDo App Rest API build as final project for Santander Bootcamp 2023 - Backend Java

## Running 
- Start postgresql with docker compose
```shell
    cd src/main/ && docker compose up
```

## Testing
- Go to [swagger-ui](http://localhost:8080/swagger-ui/index.html) 
- First we need to login by calling: `/api/auth/login`
```json
{
  "username": "admin",
  "password": "password"
}
```
- After login, we will receive a JWT token to use in next requests.
```json
{
  "user": {
    "id": 202,
    "username": "admin",
    "roles": [
      {
        "id": 152,
        "name": "ADMIN",
        "authority": "ADMIN"
      }
    ]
  },
  "jwt": "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoiYWRtaW4iLCJpYXQiOjE2OTY4NDE0NzcsInJvbGVzIjoiQURNSU4ifQ.GzOjz67fwtkyGW-oLMv-MyMdOh55qFAFsKln9Bl1PgNjYk5Vk4_t6yYW3yo3gSb7v1uC9FS9pVcqoEogYV-VnKB42PEVYYq3obf7kmRSVIjcBzZ4eZ0JaZgmaS_-27EnvdacRkeA66oX620nlcOuBCf-KjEmZXSs2tB1foL6N-IXqrcXq7lR5W7GzpH4Ju-zTYwAlxhAu-Zqt3JX84n0zRJmGkV5K641atzn0v1qFYwHa0N6rdBGeaprb9VgFwq0KbIxqqpy92ch2q1GvndjYJ2UiWqwLz0S5_B8hAKfolQQfLPBba-5dJH5ZOhTv7p7UCOZoJNgenOB-bIPbaMZqg"
}
```
- Now setup Autorization token and have fun.