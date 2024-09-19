import java.util.ArrayList;
import java.util.List;

public class BasePorto {
    protected String nome;
    protected List<Barco> barcosAtracados = new ArrayList<>();

    public BasePorto(String nome) {
        this.nome = nome;
    }

    public boolean atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        System.out.println("Barco " + barco.getNome() + " atracado no " + nome);
        return true;
    }

    public void desatracarBarco(Barco barco) {
        if (barcosAtracados.remove(barco)) {
            System.out.println("Barco " + barco.getNome() + " desatracado do " + nome);
        } else {
            System.out.println("Barco " + barco.getNome() + " não está atracado no " + nome);
        }
    }
}
