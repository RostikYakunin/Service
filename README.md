# Vehicle-fleet-service
App which imitated work of vehicle fleet service.

## How it work
App has consol menu and dividies into layers which interacts according to the scheme "console > service > repository".

- repository - saves info about vehicles, drivers and routes, has methods for CRUD operations and work with services. To save information is used arraylist;
- service - contains business logic, gets info from repositories and works with console;
- console - provides for user a menu for working with the application. Console gets info from service;

## Patterns

- Repository (DAO);
- Service.
