<h1>Descripción de la API</h1>
La API RESTful proporciona funcionalidades básicas para administrar una colección de libros.

<h2>Recursos</h2>
<ul>
<li>Books: Representa una colección de libros.</li>
</ul>

<h2>Endpoints</h2>
<ul>
<li>GET /books: Obtiene todos los libros disponibles.</li>
<li>GET /books/{bookId}: Obtiene un libro específico por su ID.</li>
<li>POST /books: Crea un nuevo libro.</li>
<li>PUT /books/{bookId}: Actualiza un libro existente.</li>
<li>DELETE /books/{bookId}: Elimina un libro.</li>
</ul>

<h2>Estructura de un libro</h2>
Un libro tiene la siguiente estructura:

json
{
  "id": 1,
  "title": "Título del libro",
  "author": "Autor del libro"
}
<ul>
  <li>id (entero): Identificador único del libro.</li>
 <li>title (cadena): Título del libro.</li>
 <li>author (cadena): Autor del libro.</li>
</ul>
<h2>Ejemplos de solicitudes y respuestas</h2>
A continuación, se presentan ejemplos de solicitudes y respuestas utilizando la API RESTful.

<h3>Obtener todos los libros (GET /books)</h3>
Solicitud:
GET /books

Respuesta exitosa:
HTTP/1.1 200 OK
Content-Type: application/json
<code>
[
  {
    "id": 1,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald"
  },
  {
    "id": 2,
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee"
  },
  {
    "id": 3,
    "title": "1984",
    "author": "George Orwell"
  }
]
</code>
<h3>Obtener un libro por su ID (GET /books/{bookId})</h3>
<b>Solicitud:</b>
GET /books/1

HTTP/1.1 200 OK
Content-Type: application/json
<code>
{
  "id": 1,
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald"
}
</code>
<b>Respuesta de error (libro no encontrado):</b>
HTTP/1.1 404 Not Found
Content-Type: application/json
<code>
{
  "error": "Libro no encontrado"
}
</code>
<h3>Crear un nuevo libro (POST /books)</h3>
<span style="color:red">Solicitud:</span>
POST /books
Content-Type: application/json
<code>
{
  "title": "Nuevo libro",
  "author": "Autor del nuevo libro"
}
</code>
Respuesta exitosa:</b>

HTTP/1.1 201 Created
Content-Type: application/json
<code>
{
  "id": 4,
  "title": "Nuevo libro",
  "author": "Autor del nuevo libro"
}
</code>
Actualizar un libro existente (PUT /books/{bookId})
Solicitud:

PUT /books/4
Content-Type: application/json
<code>
{
  "title": "Libro actualizado",
  "author": "Autor actualizado"
}
</code>
Respuesta exitosa:
HTTP/1.1 200 OK
Content-Type: application/json
<code>
{
  "id": 4,
  "title": "Libro actualizado",
  "author": "Autor actualizado"
}
</code>
Respuesta de error (libro no encontrado):
HTTP/1.1 404 Not Found
Content-Type: application/json
<code>
{
  "error": "Libro no encontrado"
}
</code>
Eliminar un libro (DELETE /books/{bookId})
Solicitud:

DELETE /books/4

HTTP/1.1 200 OK
Content-Type: application/json
<code>
{
  "message": "Libro eliminado correctamente"
}
</code>
Respuesta de error (libro no encontrado):

HTTP/1.1 404 Not Found
Content-Type: application/json
<code>
{
  "error": "Libro no encontrado"
}
</code>
