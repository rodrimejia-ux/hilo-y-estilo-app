# Plan de Implementación: Menú de Navegación Jerárquico para "Hilo & Estilo"

Implementar un sistema de navegación jerárquico profesional utilizando `DrawerLayout`, `NavigationView`, y menús anidados en XML para soportar las categorías principales y subcategorías requeridas, utilizando estrictamente **View Binding** sin `findViewById`.

## User Review Required

> [!IMPORTANT]
> Se utilizará un **Navigation Drawer (Menú Desplegable Lateral)** con categorías y submenús anidados, accesible mediante un botón Hamburguesa en la Toolbar, que es el patrón estándar y más limpio en Android para representar estructuras web jerárquicas complejas en dispositivos móviles.

## Proposed Changes

### Componente de Navegación y UI (`.xml` y `.java`)

#### [NEW] [nav_drawer_menu.xml](file:///C:/Users/SENA/AndroidStudioProjects/hilo-y-estilo-app/app/src/main/res/menu/nav_drawer_menu.xml)
- Definición de los ítems principales y submenús anidados:
  - Inicio
  - Inicio de sesión
  - Añadir producto
  - Ventas (con submenús: Registro de Compras, Registro de Ventas)
  - Categoría de insumos (con submenús: Tipos de tela, Accesorios, Hilo)
  - Envíos (con submenús: Nacionales, Internacionales)
  - Contacto
  - Cuenta

#### [NEW] [nav_header.xml](file:///C:/Users/SENA/AndroidStudioProjects/hilo-y-estilo-app/app/src/main/res/layout/nav_header.xml)
- Cabecera visual del menú lateral con el branding de "Hilo & Estilo".

#### [MODIFY] [activity_barra_hilo_estilo.xml](file:///C:/Users/SENA/AndroidStudioProjects/hilo-y-estilo-app/app/src/main/res/layout/activity_barra_hilo_estilo.xml)
- Reestructurar para utilizar `DrawerLayout` como contenedor raíz, conteniendo el diseño principal con `Toolbar` y el `NavigationView`.

#### [MODIFY] [BarraHiloEstilo.java](file:///C:/Users/SENA/AndroidStudioProjects/hilo-y-estilo-app/app/src/main/java/com/rodrigo/hiloyestiloapp/BarraHiloEstilo.java)
- Configurar `ActionBarDrawerToggle` para el botón hamburguesa, inicializar `ActivityBarraHiloEstiloBinding` y manejar los clics de las opciones y subcategorías del menú mediante View Binding.

#### [MODIFY] [strings.xml](file:///C:/Users/SENA/AndroidStudioProjects/hilo-y-estilo-app/app/src/main/res/values/strings.xml)
- Añadir etiquetas de texto para todas las nuevas opciones y subcategorías del menú.

## Verification Plan

### Automated Tests
- Ejecutar compilación de Gradle (`app:assembleDebug`) para asegurar que View Binding y los recursos XML no presenten errores.

### Manual Verification
- Desplegar en emulador o dispositivo físico y comprobar que:
  1. El menú lateral se abre correctamente al pulsar el botón hamburguesa.
  2. Las categorías con submenús (Ventas, Categoría de insumos, Envíos) despliegan sus subcategorías.
  3. Al seleccionar cualquier opción o subcategoría, se muestra un mensaje Toast y se actualiza el contenido de la pantalla usando exclusivamente View Binding.
