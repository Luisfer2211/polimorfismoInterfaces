import csv

# Datos de ejemplo
datos = [
    ["Teléfono", "Samsung Galaxy S21", "Encendido"],
    ["Computadora", "Dell XPS 13", "Apagado"],
    ["Teléfono", "iPhone 12", "Encendido"],
    ["Computadora", "HP Spectre x360", "Apagado"]
]

# Nombre del archivo CSV
nombre_archivo = "Registro.csv"

# Crear y escribir en el archivo CSV
with open(nombre_archivo, mode='w', newline='') as archivo_csv:
    writer = csv.writer(archivo_csv)
    
    # Escribir encabezados
    writer.writerow(["Tipo", "Modelo/Marca", "Estado"])

    # Escribir datos de ejemplo
    for fila in datos:
        writer.writerow(fila)

print(f'Se ha creado el archivo "{nombre_archivo}" con datos de ejemplo.')
