public class Computadora implements DispositivoElectronico {
    private String marca;
    private boolean encendido;

    public Computadora(String marca) {
        this.marca = marca;
        this.encendido = false;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void encender() {
        encendido = true;
    }

    @Override
    public void apagar() {
        encendido = false;
    }

    @Override
    public boolean estaEncendido() {
        return encendido;
    }
}
