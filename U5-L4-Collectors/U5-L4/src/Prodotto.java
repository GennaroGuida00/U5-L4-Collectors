public class Prodotto {

    protected int id;
    protected String nome;
    protected Categoria categoria;
    protected double prezzo;

    public Prodotto(int id, String nome, Categoria categoria, double prezzo) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    public Prodotto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return
                "id:" + id +
                ", nome:'" + nome + '\'' +
                ", categoria:" + categoria +
                ", prezzo:" + prezzo
                ;
    }
}
