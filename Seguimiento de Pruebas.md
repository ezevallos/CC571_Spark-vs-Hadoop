# Seguimiento de Pruebas
## Verificación de Instalación de Hadoop en Windows 10
Una vez instalado el Hadoop procederemos a iniciar el entorno de trabajo, dirigiendonos al folder sbin del hadoop

```
C:\Hadoop-2.8.0\sbin\
```

y luego ejecutando el comando `star-all.cmd` y se iniciará el entorno apache del hadoop

Abrimos un navegador web y nos dirigimos a `http://localhost:8088`

<Insertar Imagen>

En una nueva pestaña abrimos `http://localhost:50070`

<Insertar Imagen>

## Pruebas con el archivo JAR wordcount y MapReduce

Ya teniendo el entorno corriendo procederemos a crear un folder en HDFS

```
hadoop fs -mkdir /input_dir
```

Copiamos un archivo de texto `input_file.txt` en el folder de ingreso creado previamente (`/input_dir`).

```
hadoop fs -put C:/input_file.txt /input_dir
```

Siempre es bueno verificar que la copia del archivo se haya realizado correctamente y para ello veremos si el archivo `input_file.txt` ya se encuentra en `/input_dir`.

```
hadoop fs -ls /input_dir/
```

Verificamos el contenido del archivo con:

```
hadoop dfs -cat /input_dir/input_file.txt
```

Por último ejecutamos el archivo `MapReducerClient.jar` y proveemos los directorios de entrada y salida, mediante:

```
hadoop jar C:/MapReduceClient.jar wordcount /input_dir /output_dir
```

Verificamos el contenido generado en el archivo de salida con:

```
hadoop dfs -cat /output_dir/*
```
