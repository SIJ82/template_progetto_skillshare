# Sviluppo locale

Assicuratevi di aver installato java jdk 21+ e maven

?? Istruzioni per ubutnu ??
?? Istruzioni per windows ??

## Primo avvio
``` sh
mvn clean install
```

## Per lanciare il progetto in modalità di sviluppo

``` sh
mvn gwt:codeserver -pl *-client -am
```

``` sh
mvn jetty:run -pl *-server -am -Denv=dev
```

Potete accedere all'applicazione su http://127.0.0.1:8080/


# Deploy con docker


## Lancio
``` sh
docker compose up -d --build
```

## Distruzione
```sh
docker compose down
```


## Pulizia del database

Eliminare la cartella dockerdata/
