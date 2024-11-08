# Proyecto Domingus

## Funcionalidades de la Iteración 1

En esta primera iteración, hemos añadido dos funcionalidades principales:

1. **Elección de notificador**  
   
2. **Registro de notificaciones**

## Ejecución del Proyecto

Para ejecutar el `main` del proyecto, hay que configurar un argumento en el IDE que estes utilizando (en nuestro caso, IntelliJ IDEA) que especifique el intervalo de tiempo en milisegundos para el Timer.

### Configuración de Argumentos en IntelliJ IDEA

1. Ir a **Run > Modify run configurations**
2. Seleccionar la configuración de ejecución del `main` en `DomingusUI`.
3. En el campo **Program Arguments**, ingresar el intervalo de tiempo en milisegundos. Por ejemplo: 2000.
   Esto configurará el intervalo en 2 segundos para el timer.
4. Guardá los cambios, y finalmente, ejecutá el proyecto.

### Configuración de Argumentos en Eclipse

Para ejecutar el `main` del proyecto (`DomingusUI`), es necesario configurar un argumento en Eclipse que especifica el intervalo de tiempo en milisegundos para el Timer.

1. Ir a **Run > Run Configurations...**
2. En el panel izquierdo, buscar y seleccionar la configuración del proyecto `DomingusUI`.
    - Si no existe una configuración para `DomingusUI`, crear una nueva seleccionando **Java Application** > **New Configuration** e ingresarle un nombre.
3. En la pestaña **Arguments**, en el campo **Program Arguments**, ingresar el intervalo de tiempo en milisegundos. Por ejemplo: `2000`.
    - Esto configurará el intervalo en 2 segundos para el Timer.
4. Seleccionar **Apply** para guardar los cambios.
5. Finalmente, seleccionar **Run** para ejecutar el proyecto.
