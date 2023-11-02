public class Telefono implements DispositivoElectronico {
    private String modelo;
    private boolean encendido;

    public Telefono (String modelo) {
        this.modelo = modelo;
        this.encendido = false;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
