# Coolio OAuth2 Application

This application is a secure micro service that stores information about people belonging to different organizations. This micro service will be used as an *authorization server* for the future applications that come under the brand _Savio Apps_.

## Code Structure
The micro service has a **controller** package where all the end points are defined. 

The **service** package has service methods that performs all the validations and other necessary operations that need to be performed on the attributes received through the API request.

The **repository** package has interfaces that extend to CRUD repository. These interfaces have implementations for a vast majority of the db operations performed by the micro service.

The **configuration** package, as the name suggests has configurations for the micro service.

The **entities** package has entity classes that mimic the Relational Database tables in the project. 

The **POJO** package has plain old java object classes for the Entity classes that are essentially created to move data to and from the entity classes.

The **template** package has templates designed for request and response structures. 

The **Utils** package has utilities, as the name suggests.

## Major Units
There are two major units in the application - **Users** and **Company**. 

## License
This project has an **MIT License**. 
Copyright (c) 2019 Aseem Savio
