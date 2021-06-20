# Integrations project

This project uses Quarkus.

### Adress from correios using SOAP with cxf quarkus

WSDL: https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl

Routes:
```cmd
curl --location --request GET 'localhost:8080/v1/endereco/89805350'
```

Swagger:
```cmd
http://localhost:8080/swagger/
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```cmd
./mvnw quarkus:dev
```

You can run your application in test mode using variables from application.properties %test:
```cmd
mvn quarkus:dev -Dquarkus.profile=test
```

You can run test with:
```cmd
./mvnw test
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `integrations-0.1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/integrations-0.1.0-SNAPSHOT-runner.jar`.

### Generate class from wsdl

All configurations they are at the cxf-codegen-plugin in pom.xml
For generate class from wsld you need run:

```cmd
.mvnw compile
```
