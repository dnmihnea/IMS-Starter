Coverage: 74.1%
# IMS Starter Project

The IMS Starter links a Java project to a mySQL database with customers, items and orders. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* [Java](https://www.java.com/en/) 
* [mySQL](https://www.mysql.com/)
* [Git](https://git-scm.com/)

### Installing

#### Cloning the repo

```
git clone https://github.com/dnmihnea/IMS-Starter.git
```

#### Setting up the database in mySQL

```
CREATE DATABASE IF NOT EXISTS ims;

USE ims;

CREATE TABLE IF NOT EXISTS customers
(
id INT NOT NULL AUTO_INCREMENT,
firstName VARCHAR(25) NOT NULL,
surname VARCHAR(35) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS items
(
id INT NOT NULL AUTO_INCREMENT,
productName VARCHAR(50) NOT NULL,
price FLOAT(6,2) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
(
id INT NOT NULL AUTO_INCREMENT,
fk_customer_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (fk_customer_id) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS orders_items 
(
id INT NOT NULL AUTO_INCREMENT,
fk_order_id INT NOT NULL,
fk_item_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (fk_order_id) REFERENCES orders(id),
FOREIGN KEY (fk_item_id) REFERENCES items(id)
);
```

![Alt text](/ERD.jpeg?raw=true "ERD")

## Running unit tests

In order to run unit tests, you first need to open a terminal window inside of your *download directory*.

Run the following command.

```
mvn test
```

## Deployment

Open a terminal window inside of *Download directory*.

Run the following command.
```
java -jar IMS.jar
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Alex Dinu** - [dnmihnea](https://github.com/dnmihnea)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* QA
* Edward Reynolds
* Google and Youtube
