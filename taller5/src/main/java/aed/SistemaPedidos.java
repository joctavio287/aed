package aed;
import java.util.ArrayList;

public class SistemaPedidos {
    private ListaEnlazada<Pedido> _listaPedidos;
    // de menor a mayor ID
    private ArrayList<Handle<Pedido>> _listaHandles;

    public SistemaPedidos(){
        this._listaHandles = new ArrayList<Handle<Pedido>>();
        this._listaPedidos = new ListaEnlazada<Pedido>();
    }

    public void agregarPedido(Pedido pedido){
        Handle<Pedido> handle=this._listaPedidos.agregarAtras(pedido);
        this.agregarOrdenado(handle);
    }

    private void agregarOrdenado(Handle<Pedido> p){
        int number_of_handles = _listaHandles.size();
        int i=0;
        // comparación positiva: de mayor a menor
        while ( i<number_of_handles &&_listaHandles.get(i).compareTo(p)>0){
            i++;
        }
        _listaHandles.add(i, p);
    }

    public Pedido proximoPedidoPorId(){
        int indiceMenor = _listaHandles.size() - 1;
        Handle<Pedido> handleMenor = _listaHandles.get(indiceMenor);
        Pedido pedido = handleMenor.valor();

        handleMenor.eliminar();
        _listaHandles.remove(indiceMenor);

        return pedido;
    }

    public Pedido proximoPedidoPorLlegada(){
        Pedido pedido = _listaPedidos.obtenerPrimero();

        for (int i = 0; i < _listaHandles.size(); i++) {
            Handle<Pedido> handle = _listaHandles.get(i);

            if (handle.valor() == pedido) {
                handle.eliminar();
                _listaHandles.remove(i);
                break;
            }
        }

        return pedido;
    }

    public Pedido pedidoMenorId(){
        if (_listaHandles.size() == 0) {
            return null;
        }
        return _listaHandles.get(_listaHandles.size() - 1).valor();
    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        return this._listaPedidos.toString();
    }

    public String obtenerPedidosOrdenadosPorId(){
        String str = "[";
        int number_of_handles = _listaHandles.size();
        for (int i = number_of_handles - 1; i >= 0; i--) {
            if (i < number_of_handles - 1) {
                str += ", ";
            }
            str += _listaHandles.get(i).valor().toString();
        }
        str += "]";
        return str;
    }
}
