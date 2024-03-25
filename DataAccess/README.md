## Data access

### API Development

For our development in the data access subject, we had 4 main tasks to complete: Creation of the databases that will hold our data, development of REST APIs to act on that data( 2 of them) and the development of a consumer program that consumes data from the REST APIs and inserts them into our mongoDB database (again, using another API).
Our APIs are documented using OpenAPI version 3 specification. Here are the links for the standar API documentation. To view it download the corresponding directories and click on index.html:

  - [Postgres API](../../documentation/postgre_rest_api_definition)
  - [MongoDB API](../../documentation/mongo_rest_api_definition)

First of all, we started by making sure our databases were correctly made and were well structured in all of our systems. This meant making sure that we knew how data was structured and processed. 
Once we had our databases and data structure well defined, we started developìng the APIs to access our data. These APIs are developed using Spring, a popular Java framework for developing web services. These web services map the database tables and, in the case of MongoDB, documents and are able to store and retrieve data. For these services to be available for us, we execute them in a virtual machine that is up 24/7. 

### API Consumer program

The consumer program is developed using Vanilla Java( with no frameworks, just maven as a build tool). This app consumes different Rest Apis from other companies and ourselves and inserts them as JSON documents into MongoDB. From then on, our other applications can use the data on MongoDB for their purposes.

This consumer program is developed using concurrent programming, meaning that it will spawn different threads to handle the request to the different APIs. Once the threads have received the data from the APIs and have formatted them correctly, they insert it into the MongoDB database in a synchronized manner, since it would be risky to have them access the same resource at the same time. WIth this we reach a higher performance and we are able to use more of a computer’s performance to execute our application.

### Final words

All in all, our work in this subject revolves around the data flow and how to pass the data in a structured manner between different systems and programs. We think that this data flow is one of the most important aspects of our system and one we have polished to work well and fast.
