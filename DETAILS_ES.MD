# 📌 TaskAPI - API REST de Gestión de Tareas

TaskAPI es una API REST desarrollada con Java y Spring Boot, enfocada en la gestión de tareas personales y colaborativas. Diseñada como un proyecto de portafolio profesional con principios SOLID, arquitectura limpia y preparada para escalar mediante microservicios.

---

## 🧠 Resumen del Proyecto

TaskAPI permite a los usuarios crear, actualizar, eliminar, asignar y organizar tareas de manera eficiente y segura. La API sigue una arquitectura RESTful y aplica buenas prácticas de diseño para garantizar un backend robusto, mantenible y escalable.

---

## 🎯 Objetivos

- Permitir a los usuarios registrar y administrar tareas.

- Soportar múltiples usuarios y roles (ej. administrador, colaborador).

- Establecer prioridades, fechas límite y estado de las tareas.

- Permitir asignación de tareas entre usuarios.

- Ofrecer endpoints REST seguros, escalables y documentados.

---

## 🔧 Requerimientos Funcionales

| ID    | Requerimiento                                                                 |
|-------|--------------------------------------------------------------------------------|
| RF01  | El sistema debe permitir el registro e inicio de sesión de usuarios.          |
| RF02  | El sistema debe permitir crear, ver, actualizar y eliminar tareas.            |
| RF03  | El sistema debe permitir asignar tareas a otros usuarios.                     |
| RF04  | Las tareas deben tener título, descripción, fecha de vencimiento, estado, prioridad y etiquetas. |
| RF05  | El sistema debe permitir listar tareas por filtros: fecha, prioridad, estado, usuario asignado. |
| RF06  | El sistema debe enviar notificaciones por vencimientos próximos (futuro opcional). |
| RF07  | Los usuarios deben poder colaborar en tareas (agregar comentarios).           |

---

## 🧱 Modelo de Datos

### 🧑 Usuario (User)

```json
{
  "id": "UUID",
  "nombre": "string",
  "email": "string",
  "password": "hashed",
  "rol": "USER | ADMIN"
}
```

### ✅ Tarea (Task)

```json
{
  "id": "UUID",
  "titulo": "string",
  "descripcion": "string",
  "estado": "PENDIENTE | EN_PROGRESO | COMPLETADA | CANCELADA",
  "prioridad": "BAJA | MEDIA | ALTA",
  "fechaCreacion": "datetime",
  "fechaLimite": "datetime",
  "creadorId": "UUID",
  "asignadoA": "UUID",
  "etiquetas": ["Trabajo", "Estudio", "Otro"]
}
```
### 💬 Comentario (Comment)
```json
{
  "id": "UUID",
  "contenido": "string",
  "autorId": "UUID",
  "tareaId": "UUID",
  "fechaCreacion": "datetime"
}
```
## 🚦 Estados de las Tareas
- PENDIENTE: Recién creada, sin iniciar.

- EN_PROGRESO: El usuario ha comenzado a trabajar en ella.

- COMPLETADA: El usuario marcó la tarea como finalizada.

- CANCELADA: La tarea fue descartada por decisión del usuario.

## 🔐 Requerimientos No Funcionales

| ID    |	  Requerimiento                                            |
|-------|------------------------------------------------------------|
| RNF01 |	La API debe seguir principios RESTful.                     |
| RNF02	| Las contraseñas deben ser cifradas (BCrypt).               |  
| RNF03	| La autenticación debe usar JWT.                            |
| RNF04	| La API debe estar documentada (Swagger / OpenAPI).         |
| RNF05	| El sistema debe tener pruebas unitarias y de integración.  |
| RNF06	| La arquitectura debe ser desacoplada y escalable.          |
| RNF07	| El código debe seguir principios SOLID y Clean Code.       |

## 🛠️ Tecnologías Sugeridas

- ☕ Java 17+

- 🚀 Spring Boot 3.x

- 🧬 Spring Data JPA

- 🐘 PostgreSQL

- 🛡 Spring Security + JWT

- 📚 Springdoc OpenAPI (Swagger)

- 🧪 JUnit 5 + Mockito

- 📦 (Escalabilidad) Spring Cloud / Netflix Eureka / OpenFeign (futuro)

## 🔁 Flujos Principales
- Registro de Usuario

- Login con generación de JWT

- Creación de Tareas

- Asignación de Tareas a otros usuarios

- Actualización de Estado

- Comentarios y seguimiento colaborativo

- Filtrado y búsqueda de tareas

## 📦 Endpoints REST Ejemplo

| Método | Ruta	                    | Descripción                           |
|--------|--------------------------|---------------------------------------|
| POST	 | /api/auth/register	      | Registro de usuario                   |
| POST	 | /api/auth/login	        | Login y generación de token JWT       |
| GET	   | /api/tasks	              | Listar tareas del usuario autenticado |
| POST	 | /api/tasks   	          | Crear nueva tarea                     |
| PUT	   | /api/tasks/{id}	        | Editar una tarea existente            |
| DELETE | /api/tasks/{id}	        | Eliminar una tarea                    |
| POST	 | /api/tasks/{id}/comments | Agregar comentario a una tarea        |

## 🧠 Ideas Futuras
- 🔔 Notificaciones por correo electrónico o push para tareas próximas a vencer.

- 📅 Integración con calendarios (Google, Outlook).

- 📂 Archivos adjuntos en tareas.

- 📊 Exportación de tareas en formatos PDF o Excel.

- 📋 Interfaz visual tipo Kanban si se desarrolla frontend.

- 👥 Subtareas y checklist por cada tarea.

## 💼 Autor
**Mike Lawrence (Emanuel Obredor)**  
Desarrollador Backend Java  
📍 Barranquilla, Colombia  
🎯 Apasionado por la arquitectura limpia, el diseño de APIs RESTful y la mejora continua.  

## 📜 Licencia
Este proyecto es de código abierto y está diseñado con fines educativos y de portafolio. Puedes usarlo como base o inspiración, pero por favor da crédito si lo compartes públicamente.

