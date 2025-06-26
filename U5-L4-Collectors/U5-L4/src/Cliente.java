public class Cliente extends Prodotto {
    int livello;

    public Cliente(int id, String nome, int livello) {
        super(id, nome);
        this.livello=livello;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "livello=" + livello +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
