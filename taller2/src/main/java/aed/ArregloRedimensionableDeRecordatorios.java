package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] arreglo;

    public ArregloRedimensionableDeRecordatorios() {
        this.arreglo = new Recordatorio[] {};
    }

    public int longitud() {
        return this.arreglo.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevo_arreglo =
        new Recordatorio[this.longitud()+1];
        
        for (int j=0; j<this.longitud(); j++){
            nuevo_arreglo[j]=this.obtener(j);
        }
        nuevo_arreglo[this.longitud()] = i;
        this.arreglo=nuevo_arreglo;
    }

    public Recordatorio obtener(int i) {
        String mensaje = this.arreglo[i].mensaje();
        Horario horario = this.arreglo[i].horario();
        Fecha fecha = this.arreglo[i].fecha();
        return new Recordatorio(
            mensaje, fecha, horario
        );
    }

    public void quitarAtras() {
        Recordatorio[] arreglo_sinultimo = new Recordatorio[this.longitud()-1];
        for (int j=0;j<arreglo_sinultimo.length; j++){
            arreglo_sinultimo[j] = this.obtener(j);
        };
        this.arreglo = arreglo_sinultimo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arreglo[indice]=valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        Recordatorio[] copia = new Recordatorio[vector.longitud()];

        for (int i=0; i<vector.longitud();i++){
            copia[i] = vector.obtener(i);
        }
        this.arreglo = copia;        
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        for (int j=0; j<this.longitud(); j++){
            copia.agregarAtras(new Recordatorio(
                this.obtener(j).mensaje(),
                this.obtener(j).fecha(),
                this.obtener(j).horario()
            )
        );
        };
        return copia;
    }
}
