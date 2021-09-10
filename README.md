# ToDoApplication

Functional Requirements,
1. To-do name should be alphanumeric where it should not start with number. Also it
   should have minimum 5 characters and maximum 25 chars
2. Should not allow duplicate names, and if so graceful error message should be shown
3. User cannot be able to create more than X to-dos per day (X should be configurable)
4. Todo Entries are identifiable by its status like Yet to start, progress, completed, etc.. And
   also be tagged with Priorities like low, medium, high
5. Define schema for entities and use any in-memory database
6. All the API endpoints are protected and use any oauth based auth as security