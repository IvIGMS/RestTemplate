
COMUNICACION ENTRE MICROSERVICIOS

Dependencias [DevTools, Spring Web]

Los proyectos de SpringBoot-servicio-producto y Springboot-servicio-item son dos microservicios que se comunican entre sí mediante REST template.

Es la primera forma de comunicación que vamos a ver en los microservicios, es la mas simple, se comunican accediendo a su host y puerto, hay otras mejores formas que se hacen con herramientas de spring y con herramientas como Spring Cloud Config, que les da una serie de identificadores a los microservicios para poder comunicarse entre sí de una manera mas sencilla, sin que ellos tengan que saber las rutas de cada microservicio.

Para ello nos creamos un Microservicio que entregue la info en un endpoint, y otro micorservicio que va a rescatar el response de este endpoint, si rescatamos un objeto producto (formato json) vamos a tener que tener un objeto que tenga una estructura igual a este producto en el microservicio que lo rescata.

En el microservicio que consume al de productos tenemos que crear un AppConfig con un @Bean que llame devuelva un objeto de la clase RestTemplate y luego inyectarlo en service para poder llamar al método getForObject y poder consumir la API. Hay dos ejemplos, uno consumiendo una lista de objetos y otro consumiendo solo un objeto.

Queda un ejemplo bien definido de como comunicar dos microservicios, pero no es la manera más elegante, esto no se va a hacer de esta manera en producción.

CURIOSIDAD: cuando retornamos un objeto en el controller lo que nos da son los métodos get (nombre sin get y valor)