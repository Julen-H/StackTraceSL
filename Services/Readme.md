## Services and processes programming

### What we aimed to create
Services and Processes programming is a good tool when you have a lot of traffic in your system. Analyzing our challenge we saw that we needed 2 main things to achieve: 
Creating a TCP Server to collect data from our game and adding concurrency to improve the performance of our application.

### What we created
#### TCP Server

Firstly, we created our TCP server as a Java based program that is developed using Maven. This TCP server is going to be used to insert the data from our game. Since it’s multithreaded, 
the players can play simultaneously and when they finish the session the program will insert the data even if there are several request at the same time. The server will use an http request to call to 
one of our rest apis and do the post operation of the game data.

#### Improving performance with multithreading
As an added bonus, we realized that our API consumer program’s performance could be greatly improved by using multithreading. The idea is that the program will simultaneously fetch data from the different
API from the other groups and then will insert the data in our mongo application in a synchronized manner. 
For this purpose we added a new feature in our consumer to read from all APIs at the same time and then synchronized the function to insert the data to our mongoDB database. 

Once we did that, the program executes all the reads from the different APIs at the same time and it greatly improved the execution speed.

### Final words
All in all, we created an intermediary server for our game to connect to before inserting the data using TCP technology and we made it spawn a new thread based on how many calls are there to the server. 
Adding to that, we realized the potential of multithreading, not only in our TCP server, but in other parts of our system and we used this technology to  greatly improve the performance of our whole system.
