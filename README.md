# movilidadMDQ

## Variables de entorno (.env)

La app usa variables de entorno definidas en `src/main/resources/application.properties`.
Spring Boot **no carga automaticamente** el archivo `.env`, por lo que debes cargarlas desde IntelliJ (plugin `.env`) o
exportarlas en tu shell.

### 1) Crear archivo local `.env`

Crea un archivo `.env` local tomando como base el contenido de `.env.example`.

### 2) Completar valores en `.env`

Variables requeridas:

- `SPRING_DATASOURCE_URL`: URL JDBC de MySQL (ej: `jdbc:mysql://localhost:3306/movilidadmdq`)
- `DB_USER`: usuario de la base de datos
- `DB_PASSWORD`: contrasena de la base de datos

### 3) Cargar variables y ejecutar

#### IntelliJ + descarga de plugin `.env`

1. Abri **Run/Debug Configurations** de tu app Spring Boot.
2. En la seccion del plugin `.env` (por ejemplo EnvFile), activa la opcion para cargar variables.
3. Selecciona el archivo `.env` del proyecto.
4. Ejecuta normalmente desde IntelliJ.

