
---

# API Documentation

## Base URL
`http://lafiesta/api/v1/`

---

## **Customer API**

### 1. **Create a New Customer**
- **Endpoint:** `/customers`
- **Method:** `POST`
- **Description:** Creates a new customer in the system.
- **Request Body:**
    - Content-Type: `application/json`
    - Example:
      ```json
      {
        "customerId": "CUST001",
        "customerName": "John Doe",
        "address": "123 Main St",
        "contact": "123456789"
      }
      ```
- **Response:**
    - **201 Created:** Customer successfully created.
    - **400 Bad Request:** Invalid input.
    - **500 Internal Server Error:** Unexpected server error.

### 2. **Retrieve a Customer by ID**
- **Endpoint:** `/customers/{customerId}`
- **Method:** `GET`
- **Description:** Retrieves details of a specific customer based on `customerId`.
- **Path Parameter:** `customerId` (String)
- **Response:**
    - **200 OK:** Returns the `CustomerDTO` object.
    - **400 Bad Request:** Invalid `customerId`.
    - **404 Not Found:** Customer not found.

### 3. **Retrieve All Customers**
- **Endpoint:** `/customers`
- **Method:** `GET`
- **Description:** Retrieves a list of all customers.
- **Response:**
    - **200 OK:** Returns a list of `CustomerDTO`.
    - **204 No Content:** No customers found.

### 4. **Update a Customer**
- **Endpoint:** `/customers/{customerId}`
- **Method:** `PUT`
- **Description:** Updates the details of a specific customer.
- **Request Body:**
    - Content-Type: `application/json`
    - Example:
      ```json
      {
        "customerName": "Updated John Doe",
        "address": "456 Elm St",
        "contact": "987654321"
      }
      ```
- **Response:**
    - **204 No Content:** Customer successfully updated.
    - **400 Bad Request:** Invalid input.
    - **404 Not Found:** Customer not found.

### 5. **Delete a Customer**
- **Endpoint:** `/customers/{customerId}`
- **Method:** `DELETE`
- **Description:** Deletes a specific customer.
- **Response:**
    - **204 No Content:** Customer successfully deleted.
    - **404 Not Found:** Customer not found.

---

## **Order API**

### 1. **Create a New Order**
- **Endpoint:** `/orders`
- **Method:** `POST`
- **Description:** Creates a new order in the system.
- **Request Body:**
    - Content-Type: `application/json`
    - Example:
      ```json
      {
        "orderID": "ORDER001",
        "customerId": "CUST001",
        "items": [
          {"itemId": "ITEM001", "quantity": 2},
          {"itemId": "ITEM002", "quantity": 1}
        ],
        "totalPrice": 500.00,
        "orderDate": "2024-10-15"
      }
      ```
- **Response:**
    - **201 Created:** Order successfully created.
    - **400 Bad Request:** Invalid input.
    - **500 Internal Server Error:** Unexpected server error.

### 2. **Retrieve an Order by ID**
- **Endpoint:** `/orders/{orderId}`
- **Method:** `GET`
- **Description:** Retrieves details of a specific order based on `orderId`.
- **Response:**
    - **200 OK:** Returns the `OrderDTO` object.
      ```json
      {
        "orderID": "ORDER001",
        "customerId": "CUST001",
        "items": [
          {"itemId": "ITEM001", "quantity": 2},
          {"itemId": "ITEM002", "quantity": 1}
        ],
        "totalPrice": 500.00,
        "orderDate": "2024-10-15"
      }
      ```
    - **400 Bad Request:** Invalid `orderId`.
    - **404 Not Found:** Order not found.

### 3. **Retrieve All Orders**
- **Endpoint:** `/orders`
- **Method:** `GET`
- **Description:** Retrieves a list of all orders.
- **Response:**
    - **200 OK:** Returns a list of `OrderDTO`.
    - **204 No Content:** No orders found.

### 4. **Update an Order**
- **Endpoint:** `/orders/{orderId}`
- **Method:** `PUT`
- **Description:** Updates the details of a specific order.
- **Request Body:**
    - Content-Type: `application/json`
    - Example:
      ```json
      {
        "orderID": "ORDER001",
        "customerId": "CUST001",
        "items": [
          {"itemId": "ITEM001", "quantity": 3}
        ],
        "totalPrice": 600.00
      }
      ```
- **Response:**
    - **204 No Content:** Order successfully updated.
    - **400 Bad Request:** Invalid input.
    - **404 Not Found:** Order not found.

### 5. **Delete an Order**
- **Endpoint:** `/orders/{orderId}`
- **Method:** `DELETE`
- **Description:** Deletes a specific order.
- **Response:**
    - **204 No Content:** Order successfully deleted.
    - **404 Not Found:** Order not found.

---

## **Item API**

### 1. **Create a New Item**
- **Endpoint:** `/items`
- **Method:** `POST`
- **Description:** Creates a new item in the system.
- **Request Body:**
    - Content-Type: `application/json`
    - Example:
      ```json
      {
        "itemId": "ITEM001",
        "itemName": "Notebook",
        "price": 150.00,
        "quantity": 50
      }
      ```
- **Response:**
    - **201 Created:** Item successfully created.
    - **400 Bad Request:** Invalid input.
    - **500 Internal Server Error:** Unexpected server error.

### 2. **Retrieve an Item by ID**
- **Endpoint:** `/items/{itemId}`
- **Method:** `GET`
- **Description:** Retrieves details of a specific item based on `itemId`.
- **Response:**
    - **200 OK:** Returns the `ItemDTO` object.
      ```json
      {
        "itemId": "ITEM001",
        "itemName": "Notebook",
        "price": 150.00,
        "quantity": 50
      }
      ```
    - **400 Bad Request:** Invalid `itemId`.
    - **404 Not Found:** Item not found.

### 3. **Retrieve All Items**
- **Endpoint:** `/items`
- **Method:** `GET`
- **Description:** Retrieves a list of all items.
- **Response:**
    - **200 OK:** Returns a list of `ItemDTO`.
    - **204 No Content:** No items found.

### 4. **Update an Item**
- **Endpoint:** `/items/{itemId}`
- **Method:** `PUT`
- **Description:** Updates the details of a specific item.
- **Request Body:**
    - Content-Type: `application/json`
    - Example:
      ```json
      {
        "itemId": "ITEM001",
        "itemName": "Updated Notebook",
        "price": 180.00,
        "quantity": 40
      }
      ```
- **Response:**
    - **204 No Content:** Item successfully updated.
    - **400 Bad Request:** Invalid input.
    - **404 Not Found:** Item not found.

### 5. **Delete an Item**
- **Endpoint:** `/items/{itemId}`
- **Method:** `DELETE`
- **Description:** Deletes a specific item.
- **Response:**
    - **204 No Content:** Item successfully deleted.
    - **404 Not Found:** Item not found.

---

### **Error Codes:**
- **400 Bad Request:** Invalid input, such as malformed IDs or missing required fields.
- **404 Not Found:** Resource not found.
- **500 Internal Server Error:** Unexpected server errors.

---
