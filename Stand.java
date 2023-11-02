import java.util.ArrayList;
import java.util.List;

public class Stand {
    private List<DispositivoElectronico> dispositivos;

    public Stand() {
        dispositivos = new ArrayList<>();
    }

    public void agregarDispositivo(List<DispositivoElectronico> dispositivos) {
        this.dispositivos.addAll(dispositivos);
    }
    
    

    public void mostrarInformacion() {
        for (DispositivoElectronico dispositivo : dispositivos) {
            System.out.println("Información del dispositivo:");
            if (dispositivo instanceof Telefono) {
                Telefono telefono = (Telefono) dispositivo;
                System.out.println("Tipo: Telefono");
                System.out.println("Modelo: " + telefono.getModelo());
            } else if (dispositivo instanceof Computadora) {
                Computadora computadora = (Computadora) dispositivo;
                System.out.println("Tipo: Computadora");
                System.out.println("Marca: " + computadora.getMarca());
            }
            System.out.println("Encendido: " + (dispositivo.estaEncendido() ? "Sí" : "No"));
            System.out.println("-------------------");
        }
    }

    public void validarEncendidos() {
        System.out.println("Dispositivos encendidos:");
        for (DispositivoElectronico dispositivo : dispositivos) {
            if (dispositivo.estaEncendido()) {
                System.out.println(dispositivo.getClass().getSimpleName());
            }
        }
    }

    public void validarApagados() {
        System.out.println("Dispositivos apagados:");
        for (DispositivoElectronico dispositivo : dispositivos) {
            if (!dispositivo.estaEncendido()) {
                System.out.println(dispositivo.getClass().getSimpleName());
            }
        }
    }
}
