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
* **género**: Male o Female, Polygender, Agender ...

**return**: List&lt;EstudianteDTO&gt;

```
http://localhost:8080/estudiantes/genero/Female
```

### GET **`http://localhost:8080/estudiantes/carrera`**

Devuelve todos los estudiantes de una carrera determinada filtrados por ciudad de residencia.

**Path parameters**
* **idCarrera**: id de la carrera de interés.
* **ciudad**: nombre de la ciudad.

**return**: List&lt;EstudianteDTO&gt;

```
http://localhost:8080/estudiantes/2/Idvor
```

### GET **`http://localhost:8080/estudiantes/buscarPorCampos`**

Obtiene un listado de estudiantes filtrando por los siguientes campos:

**Query parameters**
* dni: int
* nombre: String
* apellido: String
* edad: int
* genero: String
* ciudad: String
* lu: int

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

* dni: int
* nombre: String
* apellido: String
* edad: int
* genero: String
* ciudad: String
* lu: int

```
http://localhost:8080/estudiantes
```

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

## Carrera

### GET **`http://localhost:8080/inscriptos`**

Devuelve el listado de carreras ordenadas de mayor a menor en base a la cantidad de inscriptos.

**return**: List&lt;CarreraDTO&gt;

```
http://localhost:8080/inscriptos
```

### POST **`http://localhost:8080/carreras`**

Inserta una nueva carrera en la base de datos.

Se espera un JSON con los siguientes campos:

* id: int
* nombre: String
* duracion: int

```
http://localhost:8080/carreras
```

```
{
    "id": 1234567,
    "nombre": "Apicultura",
    "duracion": 1
}
```

## EstudianteCarrera

### GET **`http://localhost:8080/reportes`**

Devuelve un reporte de cada carrera que haya tenido inscriptos. Muestra el nombre de la carrera, cantidad de inscriptos y cantidad de egresados por año (ordenados por nombre y cantidad de inscriptos).

**return**: List&lt;ReporteDTO&gt;

```
http://localhost:8080/reportes
```

### POST **`http://localhost:8080/matricular`**

Matricula un estudiante en una carrera.

Se espera un JSON con los siguientes campos:

* estudiante: Estudiante
* carrera: Carrera
* inscripcion: int
* graduacion: int
* antiguedad: int

```
http://localhost:8080/matricular
```

```
{
  "estudiante": { "dni": 71779527 },
  "carrera": { "id": 1 },
  "inscripcion": 2022,
  "graduacion": 0,
  "antiguedad": 3
}
```