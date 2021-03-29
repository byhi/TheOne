# The One Project

Ez a projekt lehetőséget biztosít a [The One API](https://the-one-api.dev/) kérés limit elkerülésére.
Jelenleg az alábbi néhány végpont elérhető a szolgáltatáson keresztül:

- **/character** - az összes karakter meta adatai
- **/quote** - minden filmbeli idézet


## Konfigurálás és futtatás

Ha ki akarja próbálni az alkalmazásokat, akkor csak annyit kell tennie, hogy klónozza a projektet és létrehozza az adatbázist.

**Git - clone**

```
$ mkdir TheOne
$ git clone https://github.com/byhi/TheOne.git
```

**Futtatás**
```
$ cd TheOne
$ mvn clean install
$ mvn spring-boot:run
```

## Konfigurációs lehetőségek
Alapvető konfiguráció mint szerver port és a The One API token beállítás megtalálható  megtalálható az alábbi fájlban:


 **application.properties**

```
server.port=8080
the-one-token=dKrpIj5AdzCiq6b8gDze
```

## Dokumentáció és Swagger

**Postman**

Igény esetén végpontokhoz tartozó kéréseket tartalmazó postman export fájl megtalálható itt:
 `documents\TheOne.postman_collection.json`

**Swagger**
A végpontok leírása a Swagger dokumentációban megtalálható az alábbi útvonalon amennyiben fut a szerver:
 
 [http://localhost:8080/swagger-ui/index.html#/characters-controller](http://localhost:8080/swagger-ui/index.html#/characters-controller) 


## Megjegyzés
A stabil működéshez ajánlott, saját tokent használni. A token a [The One API](https://the-one-api.dev/) oldalán beszerezhető egy regisztrációval.
A token csere elvégezhető a `Konfigurációs lehetőségek` pontban leírtak alapján.




