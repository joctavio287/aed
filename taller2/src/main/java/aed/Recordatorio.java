package aed;

public class Recordatorio {
    private Horario horario;
    private String mensaje;
    private Fecha fecha;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.horario = new Horario(horario);
        this.mensaje = new String(mensaje);
        this.fecha = new Fecha(fecha);
    }

    public Horario horario() {
        return new Horario(this.horario);
    }

    public Fecha fecha() {
        return new Fecha(this.fecha);
    }

    public String mensaje() {
        return new String(this.mensaje);
    }

    @Override
    public String toString() {
        String string_resultado = 
        this.mensaje().toString() + 
        " @ " + 
        this.fecha().toString() + 
        " " + 
        this.horario().toString();
        return string_resultado;
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        if(otroEsNull){
			return false;
		}
		boolean claseDistinta = otro.getClass() != this.getClass();
		if (claseDistinta) {
			return false;
		}
		Recordatorio otroRecordatorio = (Recordatorio) otro;
        boolean susElementosSonIguales = 
        (this.horario().equals(otroRecordatorio.horario())) && 
        (this.mensaje().equals(otroRecordatorio.mensaje())) && 
        (this.fecha().equals(otroRecordatorio.fecha()));
        return susElementosSonIguales;
    }

}
