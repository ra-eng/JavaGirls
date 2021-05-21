<h1 align="center">🚀 Wishlist 🚀</h1>
<p align="center">  In this project, we create an e-commerce's Wishlist using API Spring bootgit  and swagger
</p>

## :heavy_check_mark: Table of contents 

<!--ts-->
- [Features](#Features)
- [Table of contents ](#table-of-contents)
- [Installation](#installation)
- [Usage](#usage)
    - [Dependencies](#dependencies)
- [Tests](#tests)
<!--te-->


## :heavy_check_mark: Features

- [x] SWAGGER with endpoints access 
- [x] Client Register
- [x] Product Register
- [x] Add product in Client's wishlist
- [x] Remove product in Client's wishlist
- [x] Consult all products of Client's wishlist
- [x] Consult if a determined product is in Client's wishlist

## :heavy_check_mark: Installation

### 🛠 Technologies and Dependencies
* [Git](#Git)
* [Java8](#Java8)
* [Maven](#Maven)
* [Springboot2.4.5](#Springboot2.4.5)
* [JPA](#JPA)
* [Lombok](#Lombok)
* [Postgres](#Postgres)
* [Editor](#Editor4.5)

### :arrow_forward: How to use this repository
```bash
$ git clone git@github.com:ra-eng/JavaGirls.git
```
- Open the project in the Editor
- After that you can RUN


## :arrow_forward: Usage

- Run project
- Start swagger: http://localhost:8080/swagger-ui.html

### :heavy_check_mark: Add new Client
Input:
```bash
{
  "cpf":  , 
  "email":  ,
  "name":  ,
  "password":  
  
}
```
### :heavy_check_mark: Add new Product
Input:
```bash
{
  "category":  , 
  "details":  ,
  "name":  ,
  "price":  
  
}
```

### :heavy_check_mark: Fetch all products
Input:
No parameters

### :heavy_check_mark: Search a wishlist for a given client id
```bash
clientId: 
```

### :heavy_check_mark: Add a product to the client's wishlist
Link clientId to productId

### :heavy_check_mark: Deletes a product in client's wishlist
Deletes a product in client's wishlist by id 

Input: 
```bash
clientId: 
productId:
```
### :heavy_check_mark: Search a product by name
Input:
```bash
clientId: 
name:
```




