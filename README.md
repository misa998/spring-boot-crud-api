# spring-boot-crud-api
Spring boot app that supports crud operations on rest api.

This app contains three techniques of DAO:
1. hibernate api (EmployeeDAOImpl)
2. jpa api (EmployeeDAOJpaImpl)
  - To use it:
    In DAO implementation (@Repository) make a private field EntityManager and assign it through constructor injection. 
    In service implmenetation, constructor injection, add an Qualifier to dao implementation.
3. spring data jpa (EmployeeRepository)
  -To use it: 
    Extend jpaRepository in interface, and than make a field for that interface in service implementation that will assign it through constructor injection.
    Qualifier and Transactional are not needed. 
