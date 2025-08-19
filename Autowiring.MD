# Autowiring in Spring Boot

Um Methoden einer Klasse aufzurufen, wird ein Objekt dieser Klasse benötigt. Standardmäßig ist eine Instanzvariable `null`, was zu einer `NullPointerException` führt. Das manuelle Erstellen eines Objekts mit `new Laptop()` löst das Problem, ist aber in Spring Boot nicht die bevorzugte Methode.

**Autowiring** ermöglicht es Spring Boot, Objekte automatisch zu erstellen und zu verbinden.

## Wichtige Annotationen

- `@Component`: Wird verwendet, um Spring mitzuteilen, dass eine Klasse (z.B. `Laptop`) als Bean verwaltet und ein Objekt davon erstellt werden soll.
- `@Autowired`: Wird verwendet, um eine Abhängigkeit automatisch zu verdrahten, d.h. Spring verbindet das benötigte Objekt mit der Instanzvariablen.

## Arten der Dependency Injection

Spring Boot unterstützt drei Haupttypen der Dependency Injection:

1. **Feld-Injektion (Field Injection)**
   - Die `@Autowired`-Annotation wird direkt über dem Feld platziert.
2. **Konstruktor-Injektion (Constructor Injection)**
   - Das Objekt wird über den Konstruktor übergeben; die `@Autowired`-Annotation ist hier optional, da Spring sie standardmäßig erkennt.
3. **Setter-Injektion (Setter Injection)**
   - Eine Setter-Methode wird erstellt, und die `@Autowired`-Annotation muss über der Setter-Methode platziert werden.

> **Hinweis:** Konstruktor- und Setter-Injektionen werden der Feld-Injektion vorgezogen.

## Lose Kopplung mit Interfaces

Um eine feste Abhängigkeit von einer spezifischen Klasse (z.B. `Laptop`) zu vermeiden, sollte eine Schnittstelle (z.B. `Computer`) verwendet werden. Klassen wie `Laptop` und `Desktop` können diese Schnittstelle implementieren.

Ein Entwickler sollte von der Computer-Schnittstelle abhängig sein, nicht von einer spezifischen Implementierung wie Laptop. Spring führt das Autowiring standardmäßig nach dem Typ durch; es sucht nach einer Bean, die dem Typ der Schnittstelle entspricht (z.B. Computer), und findet dann eine implementierende Klasse wie Laptop.

## Auflösung von Mehrdeutigkeiten

Wenn mehrere Klassen (z.B. Laptop und Desktop) dieselbe Schnittstelle (Computer) implementieren und beide mit @Component annotiert sind, entsteht eine Mehrdeutigkeit, da Spring nicht weiß, welche Bean injiziert werden soll.

Zur Lösung dieser Mehrdeutigkeit gibt es zwei Hauptmethoden:

- **@Primary Annotation**: Platziert man @Primary über der bevorzugten Klasse (z.B. Laptop), wird diese bei Mehrdeutigkeit bevorzugt. Wenn @Primary auf mehreren Klassen verwendet wird, führt dies zu einem Fehler ("more than one primary being found").
- **@Qualifier Annotation**: Am Injektionspunkt kann @Qualifier("beanName") verwendet werden, um explizit den Namen der zu injizierenden Bean anzugeben (z.B. @Autowired @Qualifier("laptop") Computer comp). Der Standard-Bean-Name ist der Klassenname mit dem ersten Buchstaben kleingeschrieben (z.B. laptop für die Klasse Laptop).
