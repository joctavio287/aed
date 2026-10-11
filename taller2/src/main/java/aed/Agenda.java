package aed;

public class Agenda {
    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios arreglo_record;

    public Agenda(Fecha fechaActual) {
        this.arreglo_record = new ArregloRedimensionableDeRecordatorios();
        this.fecha = new Fecha(fechaActual);
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.arreglo_record.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String mensaje_a_imprimir = this.fecha.toString()
        .concat("\n=====\n");
        
        for (int i = 0; i<this.arreglo_record.longitud(); i++){
            if (this.fecha.equals(
                this.arreglo_record.obtener(i).fecha()
            )){
                mensaje_a_imprimir = mensaje_a_imprimir.concat(
                  this.arreglo_record.obtener(i).toString()  
                )
                .concat("\n");
            }
        };
        return mensaje_a_imprimir;
    }

    public void incrementarDia() {
        this.fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(this.fecha);
    }

}
