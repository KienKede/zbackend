PROYECTO:

El proyecto consta de 3 modulos:

- El módulo zparent del que dependen los otros dos.
- El módulo zcommon donde está el código común de las llamadas REST.
- El módulo zbackend donde se encuentra toda la lógica de la aplicación.

Se ha creado una aplicación REST con los siguientes controladores:

Deposit -> Permite tener un histórico de los ingresos que hagan los jugadores
Game -> Los juegos a los que se les permite jugar a los jugadores
Kind Of Game -> Tipos de juegos
Play -> Permite a un jugador hacer una jugada en un juego
Player -> Permite gestionar los jugadores
Provider -> El proveedor del que vienen los jugadores

Todo esto es visible desde el swagger que incorpora: http://localhost:8090/swagger-ui.html

NOTA: a la hora de hacer el POST no es necesario el id del elemento que se va a crear pues es autogenerado 
(cosa que indica el swagger).

También se usa la herramienta h2 para regenerar la base de datos cada vez que se inicia la aplicación: 
http://localhost:8090/h2 (no he cambiado las credenciales, asi que solo hay que darle a Connect y ya se accede a la plataforma)
Se cargan valores por defecto que estan en el fichero data.sql en resources.

Hay un juego de pruebas en el módulo de zparent que se llama RunPlays, que lo que hace es hacer 10 jugadas aleatorias. Esto podrá
verse en el log que hay en la raíz del proyecto la carpeta logs.

COSAS A MEDIAS:

- No me ha dado tiempo a acabar de gestionar todos los PUT y DELETES. Y hay alguno que puede provocar algún problema.
- No he conseguido generar un WAR del proyecto para subirlo a un servidor que sea accesible (cosas del multimódulo de maven).
- El módulo common es un proyecto que tenía entre manos y he querido aprovecharlo para este test, pero he visto que hay algunas 
cosillas que no acaban de estar del todo bien. Sobre todo a la hora de gestionar los DTOs.
- Me hubiese gustado crear una instancia de EC2 en AWS para subir el proyecto pero como no ha habido WAR...

