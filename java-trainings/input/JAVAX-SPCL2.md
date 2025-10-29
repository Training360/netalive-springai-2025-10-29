×

# JAVAX-SPCL2 - Fontosabb Spring Cloud projektek a gyakorlatban (2 nap)

Spring Cloud projektek részletes ismertetése gyakorlati feladatokon keresztül

[A képzés oldala](https://www.training360.com/kepzes/javax-spcl2)

## Ismertető

A képzés célja a fontosabb Spring Cloud projektek bemutatása. Minden projekthez több gyakorlati feladat is tartozik.

A képzés csak érintőlegesen foglalkozik architektúrális kérdésekkel, microservice architektúrával, tervezési döntésekkel. A _Microservice tervezési minták Spring Clouddal megvalósítva Kubernetes környezetben (JAVAX-SPCL)_ képzés, mely ezeket a kérdéseket járja körbe egy konkrét microservice alkalmazás megvalósításával. 

## Szükséges előképzettség

Elvárt a Spring Boot alapvető ismerete, Rest API, adatbáziskezelés. Ennek megfelel a _Microservice alkalmazás felépítése Spring Boot keretrendszerrel Docker környezetben (JAVAX-MCR)_ képzés anyagának gyakorlati ismerete.

## Tematika

  * Spring Cloud alapelveinek bemutatása
  * Spring Cloud verziószámozása, és kapcsolata a Spring Boottal
  * Spring Cloud Config 
    * Cloud Config Server Git backenddel
    * Spring Config Client
    * Különböző alkalmazások és környezetek kezelése
    * Kódolt értékek kezelése
    * Hashicorp Vault backend
  * Spring Cloud Bus 
    * Változó konfigurációról értesítés Spring Cloud Bussal, Kafkán, konfiguráció újratöltése
    * Saját esemény küldése és fogadása
  * Spring Cloud Function 
    * Programming model, Supplier, Function, Consumer
    * REST végpontok implementálása Functionként
    * Function composition
    * Header kezelése
    * Routing
    * Actuator
    * Reaktív modell
  * Spring Cloud Stream 
    * Spring Cloud Function felhasználásával, Kafka streaming platformon
    * Spring Cloud Stream RabbitMQ binder
    * JSON formátumú üzenetek küldése üzleti logikából
    * JSON formátumú üzenetek fogadása
    * JSON formátumú kérés üzenetekre válasz küldése
    * Error handling
    * DLQ
    * AVRO formátumú üzenetek, Spring Cloud Stream Schema Registry
    * Protobuf üzenetek küldése
  * Spring Cloud Circuit Breaker 
    * Resilience4J Circuit Breaker
    * Fallback
    * TimeLimiter
    * Retry
    * Bulkhead
    * RateLimiter
  * Spring Cloud Gateway 
    * Alapfelépítés, routing, Route Predicate Factory, filters, Gateway Filter Factories
    * Route példa header alapján  

    * Circuit breaker
    * Fallback
    * Timeout
    * Retry
    * Cache
    * Trace
  * Eureka Service Discovery 
    * Service Discovery
    * Load balancing
  * Spring Cloud Task 
    * Launcher