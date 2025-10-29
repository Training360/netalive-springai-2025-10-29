×

#  Microservice tervezési minták Spring Clouddal megvalósítva Kubernetes környezetben (JAVAX-SPCL) (3 nap)

Microservice tervezési minták felhasználásával, Spring Boot service-ekkel, néhány Spring Cloud projekt bevezetésével

[A képzés oldala](https://www.training360.com/kepzes/javax-spcl)

## Ismertető

A képzés során a microservice tervezési minták alapján kerül felépítésre egy több, mint tíz, főleg Spring Boot microservice-ekből álló alkalmazás. A képzés erősen gyakorlati jellegű, a microservice-ek megfelelő komponensei egyénileg kerülnek megvalósításra, valamint kerül összeépítésre egy működő alkalmazássá. Ahol a használata indokolt, egy Spring Cloud projekt kerül felhasználásra, bevezető jelleggel (pl. Gateway, Stream, Config). A végén telepítésre kerül Kubernetes környezetbe, melyek használatával bizonyos komponensek leválthatóak. A képzés során összehasonlításra kerül a monolitikus, modularizált és microservice architektúra, sőt gyakorlati tanácsokat is ad, hogyan lehet ezek között mozogni.

A képzés tartalmaz elméleti részeket a microservice architektúráról, valamint a tervezési döntésekről. A Spring Cloud projekteket csak részben érinti, pont annyira, hogy implementálható legyen az alkalmazás. A Spring Cloud projekteket részletesen a _Fontosabb Spring Cloud projektek a gyakorlatban (JAVAX-SPCL2)_ képzésünk ismerteti.

## Szükséges előképzettség

Elvárt a Spring Boot alapvető ismerete, Rest API, adatbáziskezelés. Ennek megfelel a _Microservice alkalmazás felépítése Spring Boot keretrendszerrel Docker környezetben (JAVAX-MCR)_ képzés anyagának gyakorlati ismerete.

Mivel a tananyagok egy része angol nyelvű, ezért alapfokú, dokumentumolvasás-szintű angol nyelvtudás szükséges. A képzés magyar nyelvű, magyar slide-ok alapján.

## Tematika

  * Microservice és monolitikus alkalmazás összehasonlítása
  * Bevezetés a microservice tervezési mintákba
  * Transaction script
  * Domain driven design, bounded context, aggregate, Ubiquitous language, domain event
  * Clean architecture
  * CQRS, Elasticsearch
  * API composition
  * Backend for frontend
  * GraphQL
  * Serialization formátumok (JSON, Protocol Buffers, Avro)
  * API gateway, Spring Cloud Gateway
  * Circuit breaker, Resilience4J
  * gRPC
  * Protocol translation
  * Messaging, Kafka
  * Spring Cloud Stream, Spring Cloud Function
  * Tranzakciókezelés, sagas, choreography, orchestration
  * Security, OAuth 2, authentication and authorization, Keycloak
  * Externalized configuration, Spring Cloud Config, deployment infrastructure based configuration
  * Spring Boot Admin
  * Application metrics, Promeheus, Graphana
  * Log aggregation, (Elasticsearch, Fluentd, Kibana)
  * Distributed tracing, Zipkin
  * Deployment, containerisation, orchestration, Kubernetes
  * Service registry, deployment infrastructure based service registry
  * Health check, Kubernetes “Liveness”, “Readiness” probes
  * Átállás monolitikus alkalmazásról microservice alkalmazásra