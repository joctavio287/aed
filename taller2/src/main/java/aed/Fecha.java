package aed;

public class Fecha {
    private int mes;
    private int dia;
    
    // Inicializa la instancia de la clase con valores
    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    // Inicializa una nueva indstancia a partir de otra vieja
    public Fecha(Fecha fecha) {
		//: no debería hacear fecha.dia() dado que dia es privado?
        dia = fecha.dia(); 
		mes = fecha.mes();
    }
    public Integer dia() {
        return this.dia;
    }
    public Integer mes() {
        return this.mes;
    }

    public String toString() {
        String separador_string = (String) "/";
        return String.valueOf(this.dia()) + separador_string + String.valueOf(this.mes());
    }

    // Decidimos nostros qué significa que dos objetos Fecha sean iguales
    @Override
    public boolean equals(Object otra) {
        // Hay que verificar que el objeto input no sea vacío 
		boolean otroEsNull = (otra == null);
        if(otroEsNull){
			return false;
		}
        // Y que sea de la clase Fecha
		boolean claseDistinta = otra.getClass() != this.getClass();

		if (claseDistinta) {
			return false;
		}

		//  Casting -> le indicamos a Java que el Object es Fecha
        // #: supongo que Fecha se hereda de Object, por eso
        // el chequeo anterior funciono
		Fecha otraFecha = (Fecha) otra;


		// Para nosotros bastara que mes y día sean iguales
        // como las variables son int, esto compara los valores, 
        // no que apunten al mismo valor (que sean alias)
		return (this.mes()==otraFecha.mes()) && (this.dia()==otraFecha.dia());
	}

    public void incrementarDia() {
        int dias_en_mes = diasEnMes(this.mes());
        if (this.dia()<dias_en_mes){
            this.dia = this.dia+1;
            }else if (this.mes()==12){
                this.mes = 1;
                this.dia = 1;
            }else{
                this.dia = 1;
                this.mes +=1;
            };        
        }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
