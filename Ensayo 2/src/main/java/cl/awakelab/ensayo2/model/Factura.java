package cl.awakelab.ensayo2.model;

public class Factura {

    private int facturaid;
    private String cliente;
    private String fecha;

    public Factura() {

    }

    public int getFacturaid() {
        return facturaid;
    }

    public void setFacturaid(int facturaid) {
        this.facturaid = facturaid;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
