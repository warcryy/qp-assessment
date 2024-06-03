# Assesement Application

## Prerequisites
- MS SQL Server
- Java 17
- Docker

## User APIs

### Get Available Items
- **Endpoint**: `/User/check_available_items`
- **Method**: GET
- **Description**: Get a list of available grocery items.

### Book Grocery Items
- **Endpoint**: `/User/book_grocery`
- **Method**: POST
- **Description**: Book multiple grocery items.

## Admin APIs

### Add Grocery Item
- **Endpoint**: `/Admin/add_grocery_item`
- **Method**: POST
- **Description**: Add a new grocery item.

### Get Item List
- **Endpoint**: `/Admin/get_item_list`
- **Method**: GET
- **Description**: Get a list of all grocery items.

### Delete Grocery Item
- **Endpoint**: `/Admin/delete/{id}`
- **Method**: DELETE
- **Description**: Delete a grocery item by ID.

### Update Grocery Item
- **Endpoint**: `/Admin/update_grocery_item`
- **Method**: PUT
- **Description**: Update a grocery item.

### Update Inventory Status
- **Endpoint**: `/Admin/update_inventory_status`
- **Method**: POST
- **Description**: Update inventory status.

## Database File
Added database .bak file which can be restored on SSMS.

## Building the Application with Docker

1. Navigate to the project directory:
   ```bash
   cd qp-assessment
2. Build the Docker image using the provided Dockerfile:
   ```bash
   docker build -t assessment .
3. Once the image is built, you can run the Docker container:
   ```bash
   docker run -p 8086:8086 assessment
4. The application will be accessible at http://localhost:8086/assesement.
   
5. Also you can see the container on your docker desktop
![image](https://github.com/warcryy/qp-assessment/assets/95096739/548552cb-2722-4111-9a9b-1725ffa4b9ee)

