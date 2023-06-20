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

```json
{
  "id": 1,
  "title": "Título del libro",
  "author": "Autor del libro"
}
```
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
```json[
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
```
<h3>Obtener un libro por su ID (GET /books/{bookId})</h3>
<b>Solicitud:</b>
GET /books/1

HTTP/1.1 200 OK
Content-Type: application/json
```json
{
  "id": 1,
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald"
}
```
<b>Respuesta de error (libro no encontrado):</b>
HTTP/1.1 404 Not Found
Content-Type: application/json
```json
{
  "error": "Libro no encontrado"
}
```
<h3>Crear un nuevo libro (POST /books)</h3>
<span style="color:red">Solicitud:</span>
POST /books
# Content-Type: application/json
```json
{
  "title": "Nuevo libro",
  "author": "Autor del nuevo libro"
}
```
<b>Respuesta exitosa:</b>

HTTP/1.1 201 Created
Content-Type: application/json
```json
{
  "id": 4,
  "title": "Nuevo libro",
  "author": "Autor del nuevo libro"
}
```
# Actualizar un libro existente (PUT /books/{bookId})
# Solicitud:

PUT /books/4
Content-Type: application/json
```json
{
  "title": "Libro actualizado",
  "author": "Autor actualizado"
}
```
# Respuesta exitosa:
HTTP/1.1 200 OK
Content-Type: application/json
```json
{
  "id": 4,
  "title": "Libro actualizado",
  "author": "Autor actualizado"
}
```
# Respuesta de error (libro no encontrado):
HTTP/1.1 404 Not Found
Content-Type: application/json
```json
{
  "error": "Libro no encontrado"
}
```
# Eliminar un libro (DELETE /books/{bookId})
Solicitud:

# DELETE /books/4

HTTP/1.1 200 OK
Content-Type: application/json
```json
{
  "message": "Libro eliminado correctamente"
}
```
# Respuesta de error (libro no encontrado):

HTTP/1.1 404 Not Found
Content-Type: application/json
```json
{
  "error": "Libro no encontrado"
}
```
# Limitaciones y mejoras futuras
<ul>
<li><p>Se podrían implementar mecanismos de seguridad adicionales, como la encriptación de datos sensibles y el control de acceso basado en roles.</p></li>
<li><p>Para una mayor escalabilidad, se podría considerar migrar la base de datos a un servidor remoto o utilizar servicios de almacenamiento en la nube.</p></li>
</ul>

# Contribuciones
Si deseas contribuir a este proyecto, puedes hacerlo abriendo issues o enviando pull requests. ¡Estaremos encantados de revisar y colaborar contigo!

# Licencia
Este proyecto se encuentra bajo la <a href="https://opensource.org/licenses/MIT">Licencia MIT</a>.
