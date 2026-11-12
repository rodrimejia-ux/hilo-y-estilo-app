# Hilo y Estilo

Aplicacion Android desarrollada en Java con Android Studio para el proyecto **Hilo y Estilo**.

## Requisitos

- Android Studio 2026.1.3 o superior
- JDK 11 (incluido con Android Studio)
- Git
- Cuenta de GitHub con acceso al repositorio

## Clonar el proyecto

```bash
git clone https://github.com/rodrimejia-ux/hilo-y-estilo-app.git
cd hilo-y-estilo-app
```

Luego abrir la carpeta en Android Studio y esperar la sincronizacion de Gradle.

> No crear un proyecto nuevo para copiar el codigo. Siempre clonar desde GitHub para conservar la conexion con el repositorio.

## Ramas del equipo

| Rama | Proposito | Responsable |
| --- | --- | --- |
| `main` | Version estable / entregable | Equipo |
| `develop` | Integracion de todas las funcionalidades | Equipo |
| `feature/BrianTorres/Texto` | Funcionalidad de texto | Brian Torres |
| `feature/David/Desarrollador2` | Desarrollo 2 | David |
| `feature/Eduardo/desarrollador3` | Desarrollo 3 | Eduardo |
| `feature/Oscar/Piedepagina` | Pie de pagina | Oscar |
| `feature/Rodrigo/desarrollador4` | Desarrollo 4 | Rodrigo |
| `feature/camilobenachi/encabezado` | Encabezado | Camilo Benachi |
| `feature/cristian/desarrollador5` | Desarrollo 5 | Cristian |
| `feature/jhonathan/estructura-base` | Estructura base | Jhonathan |
| `fix/revert-merge-david` | Correccion de una integracion de David | David |

Nadie trabaja directamente sobre `main`. Los cambios llegan a `main` asi:

```
feature/*  ->  Pull Request  ->  develop  ->  Pull Request  ->  main
```

## Flujo de trabajo obligatorio

Cada vez que se vaya a trabajar:

1. **Pull**: actualizar la rama con los cambios remotos.
2. **Programar**: realizar las modificaciones en Android Studio.
3. **Commit**: registrar los cambios con un mensaje claro.
4. **Push**: subir los commits a GitHub.
5. **Pull Request**: solicitar la integracion a `develop` (o a `main` cuando corresponda).

### Comandos basicos

```bash
# 1. Cambiar a tu rama
git checkout feature/Rodrigo/desarrollador4

# 2. Traer los ultimos cambios
git pull origin develop

# 3. Ver que archivos cambiaron
git status

# 4. Preparar y registrar los cambios
git add .
git commit -m "feat: descripcion corta del cambio"

# 5. Subir la rama
git push origin feature/Rodrigo/desarrollador4
```

### Regla de oro

Antes de hacer `Pull`, guardar los cambios locales con **Commit** o **Stash** para evitar conflictos.

Si dos integrantes modifican las mismas lineas de un archivo, Git generara un conflicto que debe resolverse antes de integrar los cambios.

## Estructura del proyecto

```
app/
  src/main/java/com/rodrigo/hiloyestiloapp/   Codigo fuente Java
  src/main/res/                                Layouts, textos, imagenes y temas
  build.gradle.kts                             Configuracion del modulo app
build.gradle.kts                               Configuracion raiz
settings.gradle.kts                            Modulos y repositorios
```
