
##API Tests

For the tests to work correctly in IntelliJ Idea, you need to install the 'Cucumber for Java' plugin.

Run test: mvn clean test

Generate allure report: mvn allure:serve

By default, all tests with the @all tag are executed in one thread.

Available options:
```
+ -DthreadCount=2 | (default = 1) Parallelization is performed only at the feature file level

+ -Dcucumber.filter.tags='@Pet'| (default = @all)

+ -Denv=stage | (default  = default)
```
In the "src/main/resources/properties" folder there are files with different environments.

They can be used when running tests from the command line.

The base URL of the application and the API version are specified there, 

if necessary, you can add the necessary settings there

![Снимок экрана 2021-08-26 в 00 07 04](https://user-images.githubusercontent.com/25115868/130868818-0ab81423-db3a-481b-89ce-93c93eefa4c5.png)

![Снимок экрана 2021-08-26 в 00 07 20](https://user-images.githubusercontent.com/25115868/130868863-2cd4475a-c6f4-47e3-882f-f112c24e17b1.png)




