package cl.yerkos.desafiolatam.miindicador.models;

public class Indicator {

    private String fecha;
    private double valor;

    public Indicator() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
