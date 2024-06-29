# Despliegue de mi Proyecto en GCP

## Sobre el Despliegue

Primero, se tiene que habilitar el servicio “Compute Engine Api”. Luego, paso a crear la instancia; el nombre es a mi elección, la región es us-east1 para estar dentro de la capa gratuita y la zona la dejo por default. 
Paso a la configuración de la VM, elijo e2-micro para estar dentro de la capa gratuita, para el disco de arranque, selecciono SO Ubuntu 20.04 LTS, de tipo “disco persistente estándar”, y de capacidad de almacenamiento 15GB; finalmente, configuro para la IP pública se mantenga constante.
Luego, procedemos a configurar la conexión por SSH con las llaves generadas desde GCP; luego, se verifica que la VM tenga el JDK correcto, se instala apache Tomcat en la VM para correr el proyecto y se habilitan los puertos necesarios.
Finalmente, genero el archivo .war del proyecto en Intellij y lo subo a uno de los puertos habilitados.
