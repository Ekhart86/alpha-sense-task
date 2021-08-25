
#API Tests

Run test: mvn clean test

Generate allure report: mvn allure:serve

By default, all tests with the @all tag are executed in one thread.

Available options:

+ -DthreadCount=2 | (default = 1) Parallelization is performed only at the feature file level

+ -Dcucumber.filter.tags='@Pet'| (default = @all)

+ -Denv=stage | (default  = default)

In the "src/main/resources/properties" folder there are files with different environments.

They can be used when running tests from the command line.

The base URL of the application and the API version are specified there, 

if necessary, you can add the necessary settings there

------------------------------------------------------------------------------------------------------------




