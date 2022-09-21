import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Farmacie> farmacii = new ArrayList<>();

        Farmacie catena = new Farmacie("Catena");
        catena.setAchizitiiCardReduceri(false);
        catena.setAcceptaPlataCard(true);
        catena.setProgram(Farmacie.Program.ZILELE_SAPTAMANII);
        catena.setOras("Timisoara");
        catena.setTipFarmacie(Farmacie.TipFarmacie.ONLINE);
        catena.setTelefon("023-378-7643");
        catena.setAdresaEmail("catena.inimii@gmail.com");
        catena.setNumarAngajati(10);

        Farmacie donna = new Farmacie("Donna");
        donna.setAcceptaPlataCard(true);
        donna.setProgram(Farmacie.Program.ZILNIC_8H);
        donna.setOras("Oradea");
        donna.setTipFarmacie(Farmacie.TipFarmacie.HIBRID);
        donna.setTelefon("0233787643");
        donna.setAdresaEmail("donna.inimii@gmail.com");
        donna.setNumarAngajati(20);

        Farmacie vlad = new Farmacie("Vlad");
        vlad.setProgram(Farmacie.Program.ZILELE_SAPTAMANII);
        vlad.setOras("Timisoara");
        vlad.setTipFarmacie(Farmacie.TipFarmacie.FIZIC);
        vlad.setTelefon("0233787643");
        vlad.setAdresaEmail("vlad.inimii@gmail.com");
        vlad.setNumarAngajati(30);

        farmacii.add(catena);
        farmacii.add(donna);
        farmacii.add(vlad);

        Medicament paracetamol = new Medicament("Paracetamol", 2.7, "Terapia",
                Medicament.UnitateDeMasura.FIOLE);
        paracetamol.setCantitate(10);
        paracetamol.setDataExpirare("2022-08-29");
        paracetamol.setTipDecontare(Medicament.TipDecontare.DECONTAT_CAS_PARTIAL);

        Medicament nurofen = new Medicament("Nurofen", 25.89, "Zentiva",
                Medicament.UnitateDeMasura.COMPRIMATE);
        nurofen.setCantitate(5);
        nurofen.setDataExpirare("2023-01-18");
        nurofen.setTipDecontare(Medicament.TipDecontare.DECONTAT_CAS_INTEGRAL);

        Medicament ibuprofen = new Medicament("Ibuprofen", 15.45, "Antibiotice",
                Medicament.UnitateDeMasura.TABLETE);
        ibuprofen.setCantitate(20);
        ibuprofen.setDataExpirare("2021-09-30");

        Medicament molekin = new Medicament("Molekin Imuno", 74.14, "Sandoz",
                Medicament.UnitateDeMasura.TABLETE);
        molekin.setCantitate(20);
        molekin.setTipDecontare(Medicament.TipDecontare.DECONTAT_CAS_PARTIAL);

        Medicament aspenter = new Medicament("Aspenter", 14.0, "Sandoz",
                Medicament.UnitateDeMasura.FIOLE);
        aspenter.setDataExpirare("2023-05-12");
        aspenter.setCantitate(30);
        aspenter.setTipDecontare(Medicament.TipDecontare.PLATA_PRET_INTEGRAL);

        catena.adaugaMedicament(paracetamol);
        catena.adaugaMedicament(paracetamol);
        catena.adaugaMedicament(nurofen);
        catena.adaugaMedicament(ibuprofen);
        catena.adaugaMedicament(molekin);
        catena.adaugaMedicament(aspenter);


        Medicament paracetamol1 = new Medicament("Paracetamol", 2.7, "Terapia",
                Medicament.UnitateDeMasura.FIOLE);
        paracetamol1.setCantitate(3);
        paracetamol1.setDataExpirare("2022-08-29");
        paracetamol1.setTipDecontare(Medicament.TipDecontare.DECONTAT_CAS_PARTIAL);

        Medicament nurofen1 = new Medicament("Nurofen", 25.89, "Zentiva",
                Medicament.UnitateDeMasura.COMPRIMATE);
        nurofen1.setCantitate(5);
        nurofen1.setDataExpirare("2023-01-18");
        nurofen1.setTipDecontare(Medicament.TipDecontare.DECONTAT_CAS_INTEGRAL);

        Medicament ibuprofen1 = new Medicament("Ibuprofen", 15.45, "Antibiotice",
                Medicament.UnitateDeMasura.TABLETE);
        ibuprofen1.setCantitate(20);
        ibuprofen1.setDataExpirare("2021-09-30");
        ibuprofen1.setTipDecontare(Medicament.TipDecontare.DECONTAT_CAS_PARTIAL);

        Medicament molekin1 = new Medicament("Molekin Imuno", 74.14, "Sandoz",
                Medicament.UnitateDeMasura.TABLETE);
        molekin1.setCantitate(4);
        molekin1.setTipDecontare(Medicament.TipDecontare.DECONTAT_CAS_PARTIAL);
        molekin1.setDataExpirare("2024-09-23");

        donna.adaugaMedicament(paracetamol1);
        donna.adaugaMedicament(nurofen1);
        donna.adaugaMedicament(ibuprofen1);
        donna.adaugaMedicament(molekin1);


        Medicament siropDeTuse = new Medicament("Sirop de tuse", 21.89, "Pfizer",
                Medicament.UnitateDeMasura.TABLETE);
        siropDeTuse.setCantitate(2);
        ibuprofen1.setDataExpirare("2021-09-30");
        siropDeTuse.setTipDecontare(Medicament.TipDecontare.DECONTAT_CAS_PARTIAL);

        vlad.adaugaMedicament(siropDeTuse);

        //Comanda de plasat
        List<Medicament> comanda = new ArrayList<>();
        Medicament nurofen3 = new Medicament("Nurofen", 5);
        Medicament strepsils2 = new Medicament("Strepsils", 1);
        Medicament aspirina = new Medicament("Aspirina", 7);
        Medicament paracetamol2 = new Medicament("Paracetamol", 9);
        Medicament ibuprofen2 = new Medicament("Ibuprofen", 15);
        comanda.add(nurofen3);
        comanda.add(strepsils2);
        comanda.add(aspirina);
        comanda.add(paracetamol2);
        comanda.add(ibuprofen2);

        //Stoc de achizitionat
        List<Medicament> stocComandat = new ArrayList<>();
        stocComandat.add(paracetamol1);
        stocComandat.add(paracetamol1);
        stocComandat.add(paracetamol1);
        stocComandat.add(siropDeTuse);
        stocComandat.add(molekin1);
        stocComandat.add(ibuprofen1);

        //Achizitionarea unui stoc de medicamente
        catena.afiseazaStocMedicamente();
        catena.achizitioneazaStocMedicamente(stocComandat);
        catena.afiseazaStocMedicamente();

        //Plasare comanda spre farmacie
        catena.afiseazaStocMedicamente();
        catena.plasareComanda(comanda);
        catena.afiseazaStocMedicamente();

        //Calcularea numarului total de medicamente
        catena.afiseazaStocMedicamente();
        vlad.afiseazaStocMedicamente();
        donna.afiseazaStocMedicamente();

        //Verificare medicamente expirate
        donna.afiseazaStocMedicamente();
        donna.verificaMedicamenteExpirate("2022-09-08");
        donna.afiseazaStocMedicamente();

        //Afisare farmacii plata card
        afiseazaFarmaciiPlataCard(farmacii);

        //Afisare medicamente in functie de tipul de decontare
        catena.afiseazaMedicamenteDupaTipDecontare();
        donna.afiseazaMedicamenteDupaTipDecontare();

        //Afisare orase cu farmacii non-stop
        afiseazaOraseCuFarmaciiNonStop(farmacii);

        //Afisare farmacii sistem online sau hibrid
        afiseazaFarmaciiSistemOnlineSauHibrid(farmacii);


        //Numarul total de farmacisti
        afiseazaNumarDeAngajatiDinFarmacii(farmacii);

        //Cautati un medicament
        catena.cautaMedicamentul("ibuprofen");
        catena.cautaMedicamentul("coldrex");

        //Afisati lista de producatori
        catena.afiseazaListaProducatori();
        donna.afiseazaListaProducatori();
        vlad.afiseazaListaProducatori();

        //Afisati medicamentele dupa tipul unitatii de masura
        catena.afiseazaDupaUnitati();
        donna.afiseazaDupaUnitati();
        vlad.afiseazaDupaUnitati();

        //Afisare toate medicamentele
        afiseazaMedicamenteleDinOras(farmacii, "Timisoara");

    }

    public static void afiseazaFarmaciiPlataCard(List<Farmacie> farmacii) {
        System.out.println("Lista farmaciilor care accepta plata cu cardul: ");
        for (Farmacie farmacieCurenta : farmacii) {
            if (farmacieCurenta.acceptaPlataCard()) {
                System.out.println(farmacieCurenta.getNume());
            }
        }
    }
    public static void afiseazaOraseCuFarmaciiNonStop(List<Farmacie> farmacii) {
        System.out.println("--------------------------");
        Set<String> orase = new HashSet<>();
        for (Farmacie farmacie : farmacii) {
            if (farmacie.getProgram().equals(Farmacie.Program.NON_STOP) && farmacie.getOras() != null) {
                orase.add(farmacie.getOras());
            }
        }

        if(orase.isEmpty()) {
            System.out.println("Nu sunt orase cu farmacii non-stop");
        } else {
            System.out.println("Orasele cu farmacii non-stop sunt:");
            for (String oras : orase) {
                System.out.println(oras);
            }
        }
        System.out.println("--------------------------");
    }
    public static void afiseazaFarmaciiSistemOnlineSauHibrid(List<Farmacie> farmacii) {
        System.out.println("--------------------------");
        System.out.println("Farmaciile care lucreaza online sau hibrid: ");
        for (Farmacie farmacie : farmacii) {
            if (farmacie.getTipFarmacie().equals(Farmacie.TipFarmacie.ONLINE) ||
                    farmacie.getTipFarmacie().equals(Farmacie.TipFarmacie.HIBRID)) {
                System.out.println(farmacie.getNume() + ", numar de telefon: " +
                        farmacie.getTelefon() + ", adresa de email: " + farmacie.getAdresaEmail());

            }
        }
        System.out.println("--------------------------");
    }
    public static void afiseazaNumarDeAngajatiDinFarmacii(List<Farmacie> farmacii) {
        System.out.println("--------------------------");

        int numarTotalAngajati = 0;

        for (Farmacie farmacie : farmacii) {
            numarTotalAngajati += farmacie.getNumarAngajati();
        }

        System.out.println("Numarul total de angajati din farmacii este: " + numarTotalAngajati);
        System.out.println("--------------------------");
    }
    public static void afiseazaMedicamenteleDinOras(List<Farmacie> farmacii, String oras) {
        System.out.println("----------------------------");
        Map<String, Integer> medicamente = new LinkedHashMap<>(); // String - numele medicamentului, Integer - cantitatea
        for (Farmacie farmacie : farmacii) {
            if (farmacie.getOras() != null && farmacie.getOras().equalsIgnoreCase(oras)) {
                for (Medicament medicament : farmacie.getStocMedicamente()) {
                    if (medicamente.containsKey(medicament.getNume())) {
                        medicamente.replace(medicament.getNume(),
                                (medicamente.get(medicament.getNume()) + medicament.getCantitate()));
                    } else {
                        medicamente.put(medicament.getNume(), medicament.getCantitate());
                    }
                }
            }
        }
        System.out.println("In " + oras + " sunt pe stoc urmatoarele medicamente: ");
        for (Map.Entry<String, Integer> medicament : medicamente.entrySet()) {
            System.out.println(medicament.getKey() + ", cantitate: " + medicament.getValue());
        }
        System.out.println("----------------------------");
    }
}
