# Nome Progetto

Progetto GWT + Maven con supporto al deploy via Docker.

---

# Sviluppo locale

## Prerequisiti

Assicurarsi di avere installato **Java JDK 17+** e **Maven 3.8+**.

### Ubuntu / Debian

```sh
# Installazione Java JDK 21
sudo apt update
sudo apt install -y openjdk-17-jdk

# Verifica
java -version

# Installazione Maven
sudo apt install -y maven

# Verifica
mvn -version
```

### Windows

#### Tramite powershell

```sh
# Installazione Java JDK 17
winget install EclipseAdoptium.Temurin.17.JDK
# Installazione Maven
winget install Apache.Maven
```

```sh
# Verifica
java -version
mvn -version
```

#### Metodo manuale
1. Scaricare e installare **Java JDK 21+** da [adoptium.net](https://adoptium.net/)
2. Aggiungere `JAVA_HOME` alle variabili d'ambiente di sistema:
   - Variabile: `JAVA_HOME`
   - Valore: percorso di installazione JDK (es. `C:\Program Files\Eclipse Adoptium\jdk-17`)
3. Aggiungere `%JAVA_HOME%\bin` alla variabile `Path`
4. Scaricare **Maven** da [maven.apache.org](https://maven.apache.org/download.cgi), estrarlo e aggiungere la cartella `bin` alla variabile `Path`
5. Verificare l'installazione aprendo un terminale (cmd o PowerShell):

```sh
java -version
mvn -version
```

---

## Primo avvio

Compilare e installare tutte le dipendenze del progetto:

```sh
mvn clean install
```

---

## Avvio in modalità sviluppo

Il progetto si avvia con due processi separati da lanciare in **due terminali distinti**.

**Terminale 1 — GWT Code Server** (compilazione incrementale del frontend):

```sh
mvn gwt:codeserver -pl *-client -am
```

**Terminale 2 — Server Jetty** (backend):

```sh
mvn jetty:run -pl *-server -am -Denv=dev
```

Una volta avviati entrambi, l'applicazione è raggiungibile su:

👉 http://127.0.0.1:8080/



---

## Eseguire i test

Per eseguire tutti i test JUnit del progetto:

```sh
mvn test
```

Per eseguire i test di un modulo specifico:

```sh
mvn test -pl *-server
```

Per eseguire una singola classe di test:

```sh
mvn test -pl *-server -Dtest=NomeDellaClasseTest
```

---

# Deploy con Docker

> Assicurarsi di avere **Docker** e **Docker Compose** installati.

## Avvio

```sh
docker compose up -d --build
```

## Arresto e rimozione dei container

```sh
docker compose down
```

## Pulizia del database

Eliminare la cartella dei dati persistenti in app/dockerdata:

```sh
rm -rf dockerdata/
```

> ⚠️ **Attenzione:** questa operazione è irreversibile e comporta la perdita di tutti i dati salvati.