# ClassDescriptorApp
*Prueba técnica para ClaroDom*

Este repositorio cuenta con 2 projectos:
- **front-end-app**: aplicación para registrar notas utilizando tecnologías Front-End.
- **back-end-app**: aplicación para línea de comando que puede leer un archivo que contenga una clase de java y puede describir los atributos y las firmas de los métodos contenidos en esta de forma dinámica.

## Tecnologías y Metodologías.
---

**front-end-app**
> node ^16.15.0 – 17.9.1 \
> react ^15.0.0 – 17.0.0 \
> redux ^3.5.0 – 3.7.2 \
> bootstrap 4 (opcional)
 
**back-end-app**
> java 1.8.0 \
> maven 3.0.0 – 3.8.5

## Preparación del ambiente de desarrollo.
---
### front-end-app
Esta aplicación utiliza JavaScript y la biblioteca React, manejada por el manejador de paquetes de Node (NPM). Esto quiere decir que, para ejecutarla a nivel local, será necesario:
- Explorador de internet actualizado (Google Chrome, Safari, etc.).
- [NodeJS](https://nodejs.org/en) actualizado.

Una vez instaladas las herramientas mencionadas anteriormente, se inicia una nueva terminal en la carpeta del projecto `./front-end-app/` y se ejecutan los siguientes comandos:
- `npm install`
- `npm start`

Una nueva instancia de la aplicación, iniciará en el navegador que el equipo por defecto.

### back-end-app
Para la ejecución de este aplicativo, se deberá instalar el [JDK y JRE para Java 8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html).

Una vez este instalado, se abre el projecto en el IDE de preferencia.

#### Ejecución por IDE:
La aplicación buscará, en la ruta del ejecutable, el archivo de texto cuyo nombre haya sido proporcionado en los parámetros de ejecución.

#### Ejecución por compilado:
Para generar un nuevo compilado del aplicativo, se deberá ejecutar la tarea de Maven, `assembly:single`.

Una vez se haya generado el compilado, se ejecutará siguiendo el siguiendo este formato de comando `java -jar ClaroTest Person.txt` donde Person.txt será el nombre del archivo de texto que contiene la clase a describir.