# carKeeper
A small Java-based API project to catalog my cars and learn Spring Boot.

Contributors:
* Bradley Niedt


# About carKeeper

The carKeeper API was created to help me keep track of all of the cars I have owned. It is a very simple API, and I've been using it as a platform to learn Spring Boot with Java.
Currently, the project only performs basic CRUD (create, read, update, delete) functions, but IT WORKS!

## Getting Started - Prerequisites

You will need Java 11, and an IDE that supports Spring, like IntelliJIDEA.

### Clone down

* `git clone https://github.com/Bradniedt/carKeeper.git`
* `cd carKeeper`
* Ensure that you have no errors by trying to run the application:

```
./mvnw clean spring-boot:run
```
* Keep this running in the background - this is what keeps your API "live" and working.
* If you have errors, get them sorted first (aka google!).
* If not, then you should be able to visit the first endpoint via a browser on your machine:

```
http://localhost:8080/cars
```
* The output on the screen should look like this:

```
[{"id":1,"vin":"1FTEE4FH3MLD48055","make":"Ford","model":"Ranger","year":"2021","color":"Rapid Red"},
{"id":2,"vin":"JTEBT14R348016808","make":"Toyota","model":"4Runner","year":"2004","color":"White"}]
```
* If your output looks like that ^, you're good to go! If not, begin thine debugging journey.

### CREATE
* To create and add a new car to the database, run this curl POST command in a new terminal window:

```
curl -X POST localhost:8080/cars -H 'Content-type:application/json' -d '{"vin": "KMHCT5AE5EU163958", "make": "Hyundai", "model": "Accent", "year": "2014", "color": "silver"}'
```

* The new car object should be returned to you in the terminal as confirmation that your POST request was successful:

```
{"id":3,"vin":"KMHCT5AE5EU163958","make":"Hyundai","model":"Accent","year":"2014","color":"silver"}
```

* To confirm creation, you visit the all cars endpoint again, and you should see that the new car appears:

```
http://localhost:8080/cars
```


### READ
* To retrieve a list of all cars in the database, visit the following page in your browser:

```
http://localhost:8080/cars
```

* Alternately, you can retrieve information on a specific car by passing it's id in the URL (this will return the first car):

```
http://localhost:8080/cars/1
```


### UPDATE
* To update and car's info in the database, run this curl PUT command in a new terminal window (updating the color of the 4Runner):

```
curl -X PUT localhost:8080/cars/2 -H 'Content-type:application/json' -d '{"vin": "JTEBT14R348016808", "make": "Toyota", "model": "4Runner", "year": "2004", "color": "arctic white"}'
```

* Visit the endpoint for that particular car, and you'll see that the color was updated from "white" to "arctic white".

```
http://localhost:8080/cars/2
```


### DELETE
* To delete a car from the database, run this curl DELETE command in a new terminal window:

```
curl -X DELETE localhost:8080/cars/3
```
* To confirm deletion, visit the all cars endpoint again, and you should see that the deleted car no longer appears:

```
http://localhost:8080/cars
```

That's it! A working API to store your car information!

*Future updates:
-add ability to find by make
-add ability to find by year
-add ability to add a photo url to the object

## Created with

* `Spring Boot`
* `Java`

### Dependencies:
* `Web`
* `JPA`
* `H2`
