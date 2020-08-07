package pl.yellowduck.netflix90;

public class MojaKlasa<T> {

    private T mojObiekt;

    public MojaKlasa() {
    }

    public MojaKlasa(T mojObiekt) {
        this.mojObiekt = mojObiekt;
    }

    public T getMojObiekt() {
        return mojObiekt;
    }

    public void setMojObiekt(T obiekt) {
        this.mojObiekt = mojObiekt;
    }
}
