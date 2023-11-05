# Backend Plant Managmement App

Projekt aplikacji backendowej używanej w projekcie inżynierskim w aplikacji do zarządzania plantacjami owoców.

# Technologie
* Java 17
* Spring 6
* Spring Boot 3
* Lombok
* OpenApi 3
* Flyway 9.16.3

# OpenApi 3

# Flyway 9.16.3
Flyway to pakiet do zarządzania migracjami bazy danyh. Aby uruchomić migrację, należy w głównym katalogu projektu
wykonać komendę
```
mvn clean install
```
w celu zbudowania projektu. Następnie w plku flyway.conf w głównym katalogu projektu, podajemy dane do bazy danych do 
której ma zostać wykonan migracja (url, użytkownik, hasło, schemat, driver, itp.).
Po po daniu danych zapisujemy plik i otiweramy terminal. Przechodzimy do modułu (katalogu) "Application". W tym katalogu
 wykonujemy kolejno polecenia:
```
mvn flyway:info
mvn flyway:migrate #polecenie do migrowania
mvn flyway:validate
```
Jeżeli po każdej operacji otrzymamy informację 
<span style="color: green; font-weight: bold;">Build success</span>
oznacza to że migracja się powiodła.
