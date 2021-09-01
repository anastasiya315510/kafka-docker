# kafka-docker
This project was written in Java.
It sends using Kafka KafkaRecords object to project changedatacapture
{
  "pk": the primary key of this row,
  "data": For insert and update - a json containing the row being inserted or updating the existing row in the source database. For delete - null.
  "beforeData": For update and delete - a json containing the row before it was updated or deleted in the source database. For insert - null.
  "headers": {
    "operation": A string indicating the operation that happend in the source database. Can be "INSERT", "UPDATE" or "DELETE"
    "timestamp": The event timestamp,
    "streamPosition": A unique string indicating the position of the transaction in the database.
  }
  
To make a request, please:
  1. Open your postman
  2. Create a new Post request
  3. add link http://localhost:8181/publish (this is default port, but, you can change in application properties file server.port)
  4. In the body section choose JSON in the list and add JSON. For example, can be JSON:
  {
       "pk":12,
       "data":"2020-01-30T21:07:07.572426",
       "beforeData":null,
       "headers":{
        "operation": "UPDATE",
        "timestamp": "2021-08-31T21:07:07.572426",
        "streamPosition":"17"
       }
      }
   By default, its received back transformaited and sorted data, after 5 requests. 
   If Operation is Delete - the record is null(by task)
   
