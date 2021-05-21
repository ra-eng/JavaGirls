<h1 align="center">Wishlist</h1>
<p align="center"> In this project, we create an e-commerce's Wishlist using API Spring boot, and swagger
</p>

## Table of contents 

<!--ts-->
- [Features](#Features)
- [Table of contents ](#table-of-contents)
- [Installation](#installation)
- [Usage](#usage)
    - [Dependencies](#dependencies)
- [Tests](#tests)
<!--te-->


## Features

- [x] SWAGGER with endpoints access 
- [x] Client Register
- [x] Product Register
- [x] Add product in Client's wishlist
- [x] Remove product in Client's wishlist
- [x] Consult all products of Client's wishlist
- [x] Consult if a determined product is in Client's wishlist

## Installation

### Dependencies

- Git
- Java 8
- Maven
- Spring boot 2.4.5
- JPA
- Lombok 
- Postgres
- Editor 

### Clone this Repository
```bash
$ git clone git@github.com:ra-eng/JavaGirls.git
```
- Open the project in the Editor
- After that you can RUN


## Usage

- Run project
- Start swagger: http://localhost:8080/swagger-ui.html

### Add new Client
Input:
```bash
{
  "cpf":  , 
  "email":  ,
  "name":  ,
  "password":  
  
}
```
### Add new Product
Input:
```bash
{
  "category":  , 
  "details":  ,
  "name":  ,
  "price":  
  
}
```

### Fetch all products
Input:
No parameters

### Search a wishlist for a given client id
```bash
clientId: 
```

### Add a product to the client's wishlist
Link clientId to productId

### Deletes a product in client's wishlist
Deletes a product in client's wishlist by id 

Input: 
```bash
clientId: 
productId:
```
### Search a product by name
Input:
```bash
clientId: 
name:
```




