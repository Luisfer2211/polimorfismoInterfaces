import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stand stand = new Stand();
        CSVFileHandler csvFileHandler = new CSVFileHandler();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Desplegar la información de cada dispositivo");
            System.out.println("2. Validar elementos encendidos y apagados");
            System.out.println("3. Guardar los dispositivos en un archivo CSV");
            System.out.println("4. Cargar los dispositivos desde un archivo CSV");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    stand.mostrarInformacion();
                    break;
                case 2:
                    stand.validarEncendidos();
                    stand.validarApagados();
                    break;
                case 3:
                    List<DispositivoElectronico> dispositivos = new ArrayList<>();
                    dispositivos.add(new Telefono("Samsung Galaxy S21"));
                    dispositivos.add(new Computadora("Dell XPS 13"));
                    dispositivos.add(new Telefono("iPhone 12"));
                    dispositivos.add(new Computadora("HP Spectre x360"));

                    csvFileHandler.guardarCSV(dispositivos);
                    System.out.println("Los dispositivos se han guardado en el archivo CSV.");
                    break;
                case 4:
                    List<DispositivoElectronico> dispositivosCargados = csvFileHandler.cargarCSV();
                    stand = new Stand();
                    stand.agregarDispositivo(dispositivosCargados);
                    System.out.println("Los dispositivos se han cargado desde el archivo CSV.");
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }

        scanner.close();
    }
}
