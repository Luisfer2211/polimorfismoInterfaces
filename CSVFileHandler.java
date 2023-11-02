import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler {
    private static final String CSV_FILENAME = "Registro.csv";

    public void guardarCSV(List<DispositivoElectronico> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILENAME))) {
            for (DispositivoElectronico dispositivo : data) {
                String tipo = dispositivo.getClass().getSimpleName();
                String estado = dispositivo.estaEncendido() ? "Encendido" : "Apagado";
                String atributoEspecifico = "";

                if (dispositivo instanceof Telefono) {
                    Telefono telefono = (Telefono) dispositivo;
                    atributoEspecifico = telefono.getModelo();
                } else if (dispositivo instanceof Computadora) {
                    Computadora computadora = (Computadora) dispositivo;
                    atributoEspecifico = computadora.getMarca();
                }

                String linea = String.format("%s,%s,%s", tipo, atributoEspecifico, estado);
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<DispositivoElectronico> cargarCSV() {
        List<DispositivoElectronico> dispositivos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILENAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String tipo = partes[0];
                    String atributoEspecifico = partes[1];
                    boolean encendido = partes[2].equalsIgnoreCase("Encendido");

                    DispositivoElectronico dispositivo = null;
                    if (tipo.equals("Telefono")) {
                        dispositivo = new Telefono(atributoEspecifico);
                    } else if (tipo.equals("Computadora")) {
                        dispositivo = new Computadora(atributoEspecifico);
                    }

                    if (dispositivo != null) {
                        if (encendido) {
                            dispositivo.encender();
                        } else {
                            dispositivo.apagar();
                        }
                        dispositivos.add(dispositivo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dispositivos;
    }
}
