package cerinta3;

public class Masina {
    private String nrInmatriculare;
    private String marca;
    private int anFabricatie;
    private String culoare;
    private int nrKm;

    public Masina() {}

    public Masina(String nrInmatriculare, String marca, int anFabricatie, String culoare, int nrKm) {
        this.nrInmatriculare = nrInmatriculare;
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.culoare = culoare;
        this.nrKm = nrKm;
    }


    
    public String getNrInmatriculare() { return nrInmatriculare; }
    public void setNrInmatriculare(String nrInmatriculare) { this.nrInmatriculare = nrInmatriculare; }
    
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public int getAnFabricatie() { return anFabricatie; }
    public void setAnFabricatie(int anFabricatie) { this.anFabricatie = anFabricatie; }
    
    public String getCuloare() { return culoare; }
    public void setCuloare(String culoare) { this.culoare = culoare; }
    
    public int getNrKm() { return nrKm; }
    public void setNrKm(int nrKm) { this.nrKm = nrKm; }

    @Override
    public String toString() {
        return nrInmatriculare + " | " + marca + " | " + anFabricatie + " | " + culoare + " | " + nrKm + " km";
    }
}