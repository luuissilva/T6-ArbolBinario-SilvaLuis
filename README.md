# T6-ArbolBinario-SilvaLuis
# Implementación de un Árbol Binario en Java

**Asignatura:** Estructura de Datos  
**Nivel:** Tercero – Ingeniería de Software  
**Herramientas:** Java, Visual Studio Code y GitHub

## 1. Descripción del proyecto

Este proyecto implementa un árbol binario para representar la organización jerárquica de las dependencias de una universidad.

Cada nodo almacena el nombre de una dependencia y puede contener hasta dos hijos.

## 2. Estructura del árbol

- UNIVERSIDAD
  - FISEI
    - SOFTWARE
      - NIVEL1
      - NIVEL3
    - TI
  - DIDE
    - INVEST.
    - VINCULACION

## 3. Clases implementadas

**Nodo.java:** Representa cada nodo mediante una clase genérica. Incluye los atributos del nodo y los métodos `esHoja()` y `grado()`.

**ArbolBinario.java:** Permite insertar nodos, buscar dependencias, contar nodos y hojas, calcular la altura y visualizar el árbol. Los cálculos de conteo y altura utilizan recursividad.

**Main.java:** Contiene el menú interactivo de ocho opciones y utiliza `Scanner` para interactuar con el usuario.

## 4. Instrucciones de ejecución

Desde la carpeta principal del proyecto, compilar con:

`javac -d out src/modelo/Nodo.java src/negocio/ArbolBinario.java src/app/Main.java`

Ejecutar el menú interactivo:

`java -cp out app.Main`

Ejecutar los casos de prueba especiales:

`java -cp out app.Main pruebas`

## 5. Resultados esperados

| Caso | Nodos | Hojas | Altura |
|---|---:|---:|---:|
| Árbol vacío | 0 | 0 | -1 |
| Árbol con un nodo | 1 | 1 | 0 |
| Árbol universitario | 9 | 5 | 3 |

El grado de FISEI es 2 y el de SOFTWARE también es 2.

El programa impide insertar un hijo en una posición previamente ocupada.

## 6. Evidencias

Las capturas de pantalla de la ejecución y de los casos de prueba se incorporarán como evidencias del funcionamiento del programa.

## 7. Conclusión

Este proyecto permite aplicar conceptos de programación orientada a objetos, árboles binarios y recursividad mediante un ejemplo práctico de organización jerárquica universitaria.