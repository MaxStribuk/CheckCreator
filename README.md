# Project for generating checks
## Technologies - Java 17, Gradle 7.5, PostgreSQL 14
The application can be used as a web application or run from the console.
Be sure to specify at least 1 product.
It is possible to set a discount card to receive a discount.
Discount card can be only 1.

When run through the console, the arguments are given in the form productId-countProduct.
The discount card is specified as card-numberDiscountCard.
Example of passing arguments: 1-1 2-2 3-3 card-4

When used as a web application, the application is accessed via 
the URL http://localhost:8080/CheckCreator/check. The request type is GET.
Parameters are transferred according to HTTP rules. The parameter name for a product is product,
for a discount card it is card.
Request example: http://localhost:8080/CheckCreator/check?1=1&2=3&card=3.