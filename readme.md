Aquí tienes un ejemplo de README para tu proyecto de Java con Servlets, Tomcat y PostgreSQL:


# Proyecto Horóscopo con Java y Servlets

Este proyecto es una aplicación web desarrollada en Java utilizando Servlets y JDBC. La aplicación permite gestionar usuarios y consultar su signo del horóscopo de acuerdo con su año de nacimiento. La base de datos está alojada en PostgreSQL y se conecta a través de un contenedor Docker.

## Funcionalidades

- **Registro de usuarios**: Los usuarios pueden registrarse en la aplicación y proporcionar su año de nacimiento.
- **Consulta de horóscopo**: Al registrarse, la aplicación consulta y asigna el signo del horóscopo correspondiente al usuario.
- **Gestión de usuarios**: Permite buscar, modificar y eliminar usuarios existentes.
- **Manejo de autenticación**: Los usuarios deben estar autenticados para acceder a ciertas funcionalidades. Si no tienen autorización, se les redirige a una página de error de autorización.
- **Carga de datos desde Excel**: Al iniciar, la aplicación carga un archivo Excel que contiene información relevante para el cálculo del horóscopo.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Servlets**: Para manejar las solicitudes HTTP y lógica de negocio.
- **JDBC**: Para la conexión a la base de datos PostgreSQL.
- **PostgreSQL**: Base de datos utilizada para almacenar usuarios y sus signos del horóscopo.
- **Apache POI**: Biblioteca para leer datos desde un archivo Excel.
- **Docker**: Usado para contenerizar tanto la aplicación con Tomcat como la base de datos PostgreSQL.

## Requisitos Previos

- **Java 17** o superior
- **Maven**: Para la gestión de dependencias y construcción del proyecto.
- **Docker** y **Docker Compose**: Para la contenedorización de la aplicación y la base de datos.

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/usuario/proyecto-horoscopo.git
   cd proyecto-horoscopo
   ```

2. Crea el archivo `.war` con Maven:
   ```bash
   mvn clean package
   ```

3. Construye y ejecuta los contenedores con Docker Compose:
   ```bash
   docker-compose up --build -d
   ```

4. Accede a la aplicación en tu navegador en [http://localhost:8080/horoscopo](http://localhost:8080/horoscopo).

## Configuración

### Archivo `docker-compose.yml`
El archivo `docker-compose.yml` define los servicios para la base de datos PostgreSQL y la aplicación en Tomcat. La base de datos se inicializa con un archivo SQL y un archivo Excel que contiene información de horóscopos.



### Variables de Entorno

Para que la aplicación se conecte correctamente a PostgreSQL, se utilizan variables de entorno dentro del `docker-compose.yml`. Estas deben estar configuradas en la clase de conexión a la base de datos.

## Uso

### Registro y Autenticación de Usuarios

1. **Registro**: Los usuarios pueden registrarse y, de acuerdo con su año de nacimiento, se les asigna un signo del horóscopo.
2. **Autenticación**: Solo los usuarios autenticados pueden acceder a ciertas funcionalidades de la aplicación.
3. **Gestión**: Los usuarios pueden actualizar sus datos, eliminar su cuenta, y consultar información relacionada con su signo del horóscopo.

## Estructura del Proyecto

- **`src/main/java`**: Contiene las clases Java, incluyendo los Servlets y clases de modelo.
- **`src/main/webapp`**: Archivos JSP y otros recursos web.
- **`Dockerfile`**: Define la configuración de Docker para Tomcat.
- **`docker-compose.yml`**: Configura los contenedores para Tomcat y PostgreSQL.
- **`init.sql`**: Script SQL para inicializar la base de datos.
- **`horoscopo.xlsx`**: Archivo de datos de signos de horóscopo.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para obtener más información.
```

Este README proporciona un resumen detallado del proyecto, los requisitos, y la configuración necesaria para ejecutarlo.