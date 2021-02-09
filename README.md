# README #

Proyecto de prueba

### HERRAMIENTAS USADAS ###

Este proyecto esta creado sobre el modelo de automatización Page Object, usando librerías
de Serenity, además se usa la metodología BDD apoyada con CUCUMBER.

Como gestor de dependencias se usó gradle, para dar formato al código se usó el style java de google,
con el fin de optimizar el código en los modelos, se uso el plugin Lombok.

### Pruebas realizadas ###

Las pruebas se hacen partiendo de test exploratorios sobre la pagina https://sobreplanos-staging.herokuapp.com/

La prueba está delimitada por la validación del envío del formulario de reserva de un apartamento, la validación de intento de
reserva con código incorrecto y una prueba de no reserva cuando no se ingresa codigo de activación.
Con esto se prueba el funcionamiento básico como flujo happy path y algunas validaciones extras
La construcción de los escenarios se hizo de forma tal, que se adapta facilmente a cambios en la data
de prueba

Se usa la metodología BDD, donde se plantean los escenarios en lenguaje de negocio y orientado al comportamiento,
haciendo una integración de la capa de negocio a la técnica, se plantean scenarios outline con el fin de ejecutar varias veces los casos
con diferente data.

Dado que se uso BDD para este proyecto, la documentación de los casos de prueba es en si mismo el reporte generado por la ejecución
(Living documentation)

### Ejecución de test ###

La ejecución está configurada sobre el navegador google Chrome para la versión 88. la ruta del driver y capabilities están
configurados desde el archivo serenity.properties dentro del proyecto.
La ruta por defecto para el WebDriver está configurada para la raíz del proyecto
Tambien pueden ejecutarse los test en un selenium grid dockerizado dentro del proyecto, para subir el container ejecute el
comando docker-compose up -d, las capabilities tambien estan en el serenity.properties

Para ejecutar la prueba, diríjase al runner "ReservationRunner", por efectos de generación del reporte
se recomienda ejecutar la prueba usando gradle, puede usarse el comando "gradle clean test"

### Reportes ###

Los reportes generados por la ejecución quedarán en la carpeta Target, para observar el reporta
abra el archivo index.html desde cualquier navegador