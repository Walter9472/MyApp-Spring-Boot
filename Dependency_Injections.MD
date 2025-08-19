# Erklärung von Dependency Injection in Spring

## Was passiert in Spring?

Spring verwaltet Objekte in einem **IoC (Inversion of Control) Container** innerhalb der JVM.  
Sobald du `SpringApplication.run(...)` aufrufst, erzeugt Spring einen **ApplicationContext**.  
Dieser Kontext fungiert als Container, in dem sogenannte **Beans** (Objekte) definiert, erstellt und verwaltet werden.

---

## Beispiel aus dem Code

```java
// Starten der Anwendung und Abrufen des ApplicationContext
ApplicationContext context = SpringApplication.run(MyAppApplication.class, args);

// Manuelles Auslesen einer Bean (Dev) aus diesem Kontext
Dev obj = context.getBean(Dev.class);
