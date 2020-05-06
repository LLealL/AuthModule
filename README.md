# AuthModule

Módulo de autenticação via JWT com Springboot e Postgres


**SignUp**
----

* **URL**

  /api/auth/signup

* **Method:**
  
  `POST`

* **Data Params**
```
  {
    "username":"username",
    "email":"email@email.com",
    "password":"123456",
    "role": ["user"],
  }
```

**SignIn**
----

* **URL**

  /api/auth/signin

* **Method:**
  
  `POST`

* **Data Params**
```
  {
    "username":"username",
    "password":"123456",
  }
```
