# Spring Boot 電商後端系統

本專案為使用 Java 與 Spring Boot 開發之電商後端系統，主要實作 RESTful API 設計、資料庫操作、系統架構設計與單元測試，展示完整後端開發能力。

---

## 功能介紹

* 商品管理功能（新增、查詢、修改、刪除）
* 使用者註冊與登入驗證
* 訂單建立與訂單查詢
* RESTful API 設計
* 分層架構實作

---

## 專案亮點

* 建立完整 **RESTful API 後端系統**
* 採用 **Controller / Service / DAO 分層架構**
* 使用 **Spring JDBC 與 MySQL 進行資料管理**
* 完成商品、使用者、訂單等電商核心流程

---

## 系統架構

本專案採用分層架構以提升系統可維護性與擴展性

* **Controller**：負責處理 HTTP 請求與回應
* **Service**：負責業務邏輯處理
* **DAO**：負責資料庫存取

---

## 技術使用

* **程式語言**：Java
* **框架**：Spring Boot
* **資料庫**：MySQL
* **資料存取**：Spring JDBC
* **測試工具**：JUnit 5、H2 Database
* **版本控制**：Git

---

## API 設計

### 商品相關

* `GET /products`：查詢商品列表
* `POST /products`：新增商品
* `PUT /products/{id}`：修改商品
* `DELETE /products/{id}`：刪除商品

### 使用者相關

* `POST /users/register`：使用者註冊
* `POST /users/login`：使用者登入

### 訂單相關

* `POST /orders`：建立訂單
* `GET /orders`：查詢訂單列表

---

## 測試

* 使用 **JUnit 5** 進行單元測試
* 使用 **H2 記憶體資料庫** 模擬測試環境

---

## 專案結構

```
src
├── main
│   ├── java
│   │   └── com.yumi.springbootmall
│   │       ├── controller
│   │       ├── service
│   │       ├── dao
│   │       ├── model
│   │       └── dto
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com.yumi.springbootmall
```

---

