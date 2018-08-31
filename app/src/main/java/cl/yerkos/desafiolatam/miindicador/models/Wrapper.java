package cl.yerkos.desafiolatam.miindicador.models;

public class Wrapper {

    private String version, autor, codigo, nombre, unidad_medida;
    private Indicator[] serie;

    public Wrapper() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public Indicator[] getSerie() {
        return serie;
    }

    public void setSerie(Indicator[] serie) {
        this.serie = serie;
    }

}
