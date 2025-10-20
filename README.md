# Documentación endpoints

## Estudiante

### GET **`http://localhost:8080/estudiantes`**

Lista todos los estudiantes ordenados alfabéticamente por apellido.

**return**: List&lt;EstudianteDTO&gt;

```
http://localhost:8080/estudiantes
```

### GET **`http://localhost:8080/estudiantes/{lu}`**

Devuelve la información del estudiante cuyo LU coincida.

**Path parameters**
* **lu**: legajo del estudiante

**return**: EstudianteDTO

```
http://localhost:8080/estudiantes/28886
```

### GET **`http://localhost:8080/estudiantes/genero/{genero}`**

Devuelve todos los estudiantes de un género en específico.

**Path parameters**
* **género**: Male o Female

**return**: List&lt;EstudianteDTO&gt;

```
http://localhost:8080/estudiantes/genero/Female
```

### GET **`http://localhost:8080/estudiantes/carrera/{idCarrera}`**

Devuelve todos los estudiantes de una carrera determinada.

**Path parameters**
* **idCarrera**: id de la carrera de interés.

**return**: List&lt;EstudianteDTO&gt;

```
http://localhost:8080/estudiantes/carrera/1
```

### GET **`http://localhost:8080/estudiantes/buscarPorCampos`**

Obtiene un listado de estudiantes filtrando por los siguientes campos:

**Query parameters**
* dni
* nombre
* apellido
* edad
* genero
* ciudad
* LU

**return**: List&lt;EstudianteDTO&gt;

Búsqueda por nombre
```
http://localhost:8080/estudiantes/buscarPorCampos?nombre=Ronald
```
Búsqueda por edad
```
http://localhost:8080/estudiantes/buscarPorCampos?edad=32
```
Búsqueda por edad y apellido
```
http://localhost:8080/estudiantes/buscarPorCampos?edad=32&apellido=Pepys
```

### POST **`http://localhost:8080/estudiantes`**

Inserta un nuevo estudiante en la base de datos.

**Request body**

Se espera un JSON con los siguientes campos:

* dni
* nombre
* apellido
* edad
* genero
* ciudad
* lu

```
{
  "dni": "12345678",
  "nombre": "María",
  "apellido": "López",
  "edad": 21,
  "genero": "Female",
  "ciudad": "Rosario",
  "lu": 10025
}
```