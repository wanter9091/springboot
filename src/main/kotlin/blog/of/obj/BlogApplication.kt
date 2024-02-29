package blog.of.obj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogApplication

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}

/* docker DB start

$ docker exec -it db.blog.com /bin/bash

# mysql -u root -ppassword

mysql> CREATE DATABASE blog;

 */