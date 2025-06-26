import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Prodotto> prodotti= new ArrayList<Prodotto>();
        ArrayList<Ordine> ordini= new ArrayList<Ordine>();
        ArrayList<Cliente> clienti= new ArrayList<Cliente>();
        LocalDate today=LocalDate.now();


        Prodotto p1= new Prodotto(1, "b1", Categoria.BOOKS, 112);
        Prodotto p2= new Prodotto(2, "b2", Categoria.BOYS, 13);
        Prodotto p3= new Prodotto(3, "b3", Categoria.BOOKS, 114);
        Prodotto p4= new Prodotto(4, "b4", Categoria.BABY, 15);
        Prodotto p5= new Prodotto(5, "b5", Categoria.BOYS, 116);

        prodotti.add(p1);
        prodotti.add(p2);
        prodotti.add(p3);
        prodotti.add(p4);
        prodotti.add(p5);

        Cliente c1=new Cliente(001,"Claudio",1);
        Cliente c2=new Cliente(002,"Luca",2);
        Cliente c3=new Cliente(003,"Giulio",3);
        Cliente c4=new Cliente(004,"Franco",4);
        Cliente c5=new Cliente(005,"Simone",5);

        clienti.add(c1);
        clienti.add(c2);
        clienti.add(c3);
        clienti.add(c4);
        clienti.add(c5);




        ordini.add(new Ordine(1,Status.CONSEGNATO,LocalDate.of(2022,1,3),today,prodotti,c1));
        ordini.add(new Ordine(2,Status.IN_CONSEGNA,LocalDate.of(2021,2,3),today,prodotti,c2));
        ordini.add(new Ordine(3,Status.CONSEGNATO,LocalDate.of(2023,1,3),today,prodotti,c3));
        ordini.add(new Ordine(4,Status.IN_CONSEGNA,LocalDate.of(2021,3,3),today,prodotti,c2));
        ordini.add(new Ordine(5,Status.SPEDITO,LocalDate.of(2021,3,19),today,prodotti,c2));


//        System.out.println("-------------------------------------ESERCIZIO 1--------------------------------------------");
//
//        List<Prodotto> libriMaggioriCento= prodotti.stream()
//                .filter(p->p.getPrezzo()>100)
//                .toList();
//
//        libriMaggioriCento.forEach(System.out::println);
//
//
//
//        System.out.println("-------------------------------------ESERCIZIO 2--------------------------------------------");
//
//        List<Ordine> categoriaBaby = ordini.stream()
//                .filter(o -> o.prodotti.stream().anyMatch(p -> p.getCategoria() == Categoria.BABY))
//                .toList();
//
//        categoriaBaby.forEach(System.out::println);
//
//        System.out.println("-------------------------------------ESERCIZIO 3--------------------------------------------");
//
//        List<Prodotto> CategoriaBoys = prodotti.stream()
//                .filter(bo->bo.getCategoria()==Categoria.BOYS)
//                .map(bo->new Prodotto
//                                (bo.getId(),
//                                bo.getNome(),
//                                bo.getCategoria(),
//                                bo.getPrezzo()*1.10
//                                ))
//                .toList();
//
//        CategoriaBoys.forEach(System.out::println);
//
//        System.out.println("-------------------------------------ESERCIZIO 4--------------------------------------------");
//        List<Ordine> ordiniClienti = ordini.stream()
//                .filter(o->o.customer.livello==2 && o.orderDate.isAfter(LocalDate.of(2021,2,1)) && o.orderDate.isBefore(LocalDate.of(2021,4,1)) )
//                .toList();
//
//        ordiniClienti.forEach(System.out::println);

       System.out.println("-------------------------------------ESERCIZIO 1--------------------------------------------");
        Map<Cliente, List<Ordine>> ordiniPerCliente = ordini.stream()
                .collect(Collectors.groupingBy(o -> o.customer));

        System.out.println(ordiniPerCliente);

        ordiniPerCliente.forEach((cliente, listaOrdini) -> {
            System.out.println("Cliente: " + cliente);
            listaOrdini.forEach(ordine -> System.out.println("   Ordine: " + ordine));
        });

        System.out.println("-------------------------------------ESERCIZIO 2--------------------------------------------");

        Map<Object, DoubleSummaryStatistics> CalcoloVendite= ordini.stream().collect(Collectors.groupingBy(o -> o.getCustomer(),Collectors.summarizingDouble(o ->
                        o.getProdotti().stream().mapToDouble(Prodotto::getPrezzo).sum()
                )
        ));
        CalcoloVendite.forEach((cliente, prezzo) -> {
            System.out.println("Cliente: "+cliente);
            System.out.println("Prezzo: " +prezzo.getSum());
        });


        System.out.println("-------------------------------------ESERCIZIO 3--------------------------------------------");

        OptionalDouble maxPrezzo = prodotti.stream().mapToDouble(Prodotto::getPrezzo).max();

        if (maxPrezzo.isPresent()) {
            System.out.println("Prezzo massimo: " + maxPrezzo.getAsDouble());
        }

        System.out.println("-------------------------------------ESERCIZIO 4--------------------------------------------");
        OptionalDouble mediaImportoOrdini = ordini.stream().mapToDouble(o -> o.getProdotti().stream().mapToDouble(Prodotto::getPrezzo).sum()).average();

        mediaImportoOrdini.ifPresent(media ->
                System.out.println("Media: " + media)
        );

        System.out.println("-------------------------------------ESERCIZIO 5--------------------------------------------");
        Map<Categoria,DoubleSummaryStatistics> stats= prodotti.stream().collect(Collectors.groupingBy(p->p.getCategoria(),Collectors.summarizingDouble(p-> p.getPrezzo())));
        stats.forEach((categoria, s) -> {
            System.out.println("Categoria: " + categoria);
            System.out.println(" Somma: " + s.getSum());

        });


    }
}