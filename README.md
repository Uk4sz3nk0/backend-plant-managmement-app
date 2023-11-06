# Backend Plant Managmement App

Projekt aplikacji backendowej używanej w projekcie inżynierskim w aplikacji do zarządzania plantacjami owoców.

# Spis treści

* [Technologie](#technologie)
* [OpenApi v3](#openapi-v3)
* [Flyway 9.16.3](#flyway-9163)

# Technologie

* Java 17
* Spring 6
* Spring Boot 3
* Lombok
* OpenApi 3
* Flyway 9.16.3

# OpenApi v3

W projekcie korzystamy z OpenApi v3 oraz generatora OpenApi v3. OpenApi jest specyfikacją do tworzenia intefejssów API
w sposób niezależny od języka programowania. Jest to standard, który umożliwia tworzenie, publikowanie, znajdowanie i
używanie interfejsów API w sposób zgodny i niezawodny. Specyfikacja ta umożliwia tworzenie opisów RESTful API. Generator
OpenAPI v3 to narzędzie, które umożliwia automatyczne generowanie dokumentacji interfejsów API na podstawie
specyfikacji OpenAPI v3. Dzięki temu można szybko tworzyć czytelną i spójną dokumentację dla API. Generator ten
umożliwia także generowanie kodu klienta lub serwera na podstawie specyfikacji, co pozwala na szybsze wdrażanie i
integrację zaimplementowanego interfejsu API. Przykładowo, w naszym projekcie używamy OpenApi wraz z generatorem do
generowania modeli Dto (Data Transfer Object) oraz metod dla kontrolerów (endpointów).

Przykładowe użycie:

1. Najpierw zaczynamy od utworzenia pliku specyfikacji. Przyjeliśmy taką konwencję w nazewnictiwe:
   `<nazwa_specyfikacji>-specification.yaml` np. `authentication-specification.yaml`. Specyfikacje piszemy przy
   wykorzystaniu języka yaml.
2. Kolejnym krokiem jest napisanie zawartości pliku. Tutaj przykładowy plik specyfikacji do pobierania listy samochodów:
   ```yaml
      openapi: 3.0.3
      info:
        title: Example specification
        description: Example specification
        version: 1.0.0
      servers:
        - url: 'http://localhost:8080'
      paths:
        /example/get-cars:
          description: |
            Endpoint for getting list of cars.
          get:
            tags: 
              - "Example"
            operationId: getCars
            responses: 
              "200":
                description: Ok. Successful response returns OK status and list of CarDto objects.
                content: 
                  application/json:
                    schema: 
                      type: array
                      items: 
                        $ref: "#/components/schemas/Car"
      components: 
        schemas: 
          Car:
            type: object
            properties: 
              id:
                type: integer
                format: int64
              name:
                type: string
              productionYear:
                type: integer
   ```
3. Mając gotowy plik należy dodać odpowiedni fragment kodu w module `Api` w pliku `pom.xml`. Pod pluginem `swagger-codegen-maven-plugin` 
   dodajemy blok execution. W naszym przypadku:
   ```xml
                    <execution>
                        <id>generate-example-spec</id>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <inputSpec>${project.basedir}/src/main/resources/spec/example-specification.yaml</inputSpec>
                            <language>spring</language>
                            <library>spring-mvc</library>
                            <generateApiTests>false</generateApiTests>
                            <modelNameSuffix>Dto</modelNameSuffix>
                            <configOptions>
                                <useTags>true</useTags>
                                <interfaceOnly>true</interfaceOnly>
                                <dateLibrary>java8</dateLibrary>
                                <apiPackage>${base.generated.path}.example.specification.api</apiPackage>
                                <modelPackage>${base.generated.path}.example.specification.model</modelPackage>
                                <output>${project.build.directory}</output>
                                <apis/>
                                <models/>
                            </configOptions>
                        </configuration>
                    </execution>
   ```
4. Mając dodany taki taki blok, przechodzimy do terminala. W terminalu przechodzimy do root katalogu projektu i 
   wykonujemy polecenie 
   ```bash
      mvn clean install
   ```
   w tym momencie buduje się projekt i generują wszystkie zależności.
5. Ostatnim krokiem będzie implementacja kodu w javie. Oto fragment kodu, już z zastosowanymi zgodnie z naszą konwencją, handlerami:
   ```java
    @Slf4j
    @RestController
    @RequiredArgsConstructor
    public class ExampleController implements ExampleApi {

        private final ExampleHandler exampleHandler;

        @Override
        public ResponseEntity<List<CarDto>> getCars() {
            return ResponseEntity.ok(exampleHandler.handleGetCars());
        }
   }
   ```
Link do dokumentacji: https://swagger.io/docs/specification/about/

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
