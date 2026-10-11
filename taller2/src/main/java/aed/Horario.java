package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.minutos = minutos;
        this.hora = hora;
    }

    public Horario(Horario horario) {
		minutos = horario.minutos();
		hora = horario.hora();
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        String separador_string = (String) ":";
        return String.valueOf(this.hora()) +
        separador_string + String.valueOf(this.minutos());
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

		//  casting -> cambiar el tipo
		Horario otroHorario = (Horario) otro;


		// comparar item a ítem
		return (this.hora()==otroHorario.hora()) && (this.minutos()==otroHorario.minutos());
	}

}
