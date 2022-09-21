import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class Farmacie {
    private String nume;
    private int numarAngajati = 0;
    private Set<Medicament> stocMedicamente;
    private String oras;
    private boolean contractCAS;
    private boolean acceptaPlataCard = false;
    private boolean achizitiiCardReduceri = false;
    private String telefon;
    private String adresaEmail;
    private String adresaFarmaciei;
    private Program program = Program.ZILELE_SAPTAMANII;
    private TipFarmacie tipFarmacie = TipFarmacie.HIBRID;

    public enum Program {
        NON_STOP, ZILELE_SAPTAMANII, ZILNIC_8H
    }
    public enum TipFarmacie {
        ONLINE, FIZIC, HIBRID
    }

    public Farmacie(String nume) {
        this.nume = nume;
        this.stocMedicamente = new HashSet<>();
    }

    public boolean adaugaMedicament(Medicament medicament) {
        return stocMedicamente.add(medicament);
    }

    public void setAdresaFarmaciei(String adresaFarmaciei) {
        this.adresaFarmaciei = adresaFarmaciei;
    }
    public void setNumarAngajati(int numarAngajati) {
        this.numarAngajati = numarAngajati;
    }
    public void setContractCAS(boolean contractCAS) {
        this.contractCAS = contractCAS;
    }
    public void setAcceptaPlataCard(boolean acceptaPlataCard) {
        this.acceptaPlataCard = acceptaPlataCard;
    }
    public void setAchizitiiCardReduceri(boolean achizitiiCardReduceri) {
        this.achizitiiCardReduceri = achizitiiCardReduceri;
    }
    public void setProgram(Program program) {
        this.program = program;
    }
    public void setTipFarmacie(TipFarmacie tipFarmacie) {
        this.tipFarmacie = tipFarmacie;
    }
    public void setAdresaEmail(String email) {
        if (email == null) {
            System.out.println("Adresa introdusa nu este valida");
        } else {
            String emailRegex = "^[a-zA-Z0-9+&*-]+(?:\\." + "[a-zA-Z0-9+&-]+)@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            if (pattern.matcher(email).matches()) {
                // verificare adresa de mail
                this.adresaEmail = email;
            } else {
                System.out.println("Adresa introdusa nu este valida");
            }
        }
    }
    public void setTelefon(String telefon) {
        if (esteValid1(telefon) || esteValid2(telefon) || esteValid3(telefon)) {
            this.telefon = telefon;
        } else {
            System.out.println("Formatul numarului de telefon nu este corect!");
        }
    }
    public void setOras(String oras) {
        this.oras = oras;
    }

    public int getNumarAngajati() {
        return numarAngajati;
    }
    public String getTelefon() {
        return telefon;
    }
    public String getAdresaEmail() {
        return adresaEmail;
    }
    public Program getProgram() {
        return program;
    }
    public String getNume() {
        return nume;
    }
    public String getOras() {
        return oras;
    }
    public TipFarmacie getTipFarmacie() {
        return tipFarmacie;
    }
    public Set<Medicament> getStocMedicamente() {
        return stocMedicamente;
    }
    public boolean acceptaPlataCard() {
        return acceptaPlataCard;
    }

    // Metode statice invocate de alte metode din clasa
    private static boolean verificaCifre(String numarTelefon) {
        for (int i = 0; i < numarTelefon.length(); i++) {
            if (!Character.isDigit(numarTelefon.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean esteValid1(String numarTelefon) {
        //1234122113
        if (numarTelefon.length() != 10) {
            return false;
        }
        return verificaCifre(numarTelefon);
    }
    public static boolean esteValid2(String numarTelefon) {
        // 888-222-3232
        if (!(numarTelefon.charAt(3) == '-' && numarTelefon.charAt(7) == '-'
                && numarTelefon.length() == 12)) {
            return false;
        }
        String numarTelefonNou = numarTelefon.replace("-", "");
        return verificaCifre(numarTelefonNou);
    }
    public static boolean esteValid3(String numarTelefon) {
        //(999)-323-1213
        if (!(numarTelefon.charAt(0) == '(' && numarTelefon.charAt(4) == ')'
                && numarTelefon.charAt(5) == '-' && numarTelefon.charAt(9) == '-'
                && numarTelefon.length() == 14)) {
            return false;
        }
        String numarTelefonNou = numarTelefon.replace("-", "")
                .replace("(", "").replace(")", "");
        return verificaCifre(numarTelefonNou);
    }
    public static int cautaMedicament(List<Medicament> listaMed, String numeMed) {
        for(Medicament medCurent : listaMed) {
            if(medCurent.getNume().equalsIgnoreCase(numeMed)) {
                return listaMed.indexOf(medCurent);
            }
        }
        return -1;
    }

    public void afiseazaStocMedicamente() {
        int totalCantitate = 0;
        System.out.println("----------------------------");
        System.out.println("Farmacia " + nume + " are pe stoc: ");
        for (Medicament med : stocMedicamente) {
            System.out.println(med.getNume() + ", cantitate: " + med.getCantitate());
            totalCantitate += med.getCantitate();
        }
        System.out.println("Farmacia are un numar total de " + totalCantitate + " de medicamente (cutii, fiole etc).");
        System.out.println("----------------------------");
    }
    public void achizitioneazaStocMedicamente(List<Medicament> stocNou) {
        Set<Medicament> stocDeAdaugat = new HashSet<>();
        for(Medicament medicamentNou : stocNou) {
            boolean medEstePeStoc = false;
            for(Medicament med : stocMedicamente) {
                if(medicamentNou.getNume().equalsIgnoreCase(med.getNume())) {

                    med.setCantitate(med.getCantitate() + medicamentNou.getCantitate());
                    medEstePeStoc = true;
                }
            }
            if(!medEstePeStoc) {
                stocDeAdaugat.add(medicamentNou);
            }
        }
        stocMedicamente.addAll(stocDeAdaugat);
    }
    public void plasareComanda(List<Medicament> comanda) {
        System.out.println("----------------------------");
        System.out.println("Detalii comanda: ");
        List<Medicament> stoc = new LinkedList<>(stocMedicamente); // transformam stocul de medicamente in list
        double pretTotal = 0.0;
        for(Medicament medComanda : comanda) {
            int index = cautaMedicament(stoc, medComanda.getNume());
            if(index >= 0 && stoc.get(index).getCantitate() >= medComanda.getCantitate()) {
                    Medicament medStoc = stoc.get(index);
                    medStoc.setCantitate(medStoc.getCantitate() - medComanda.getCantitate());
                    pretTotal += achizitiiCardReduceri ? (medStoc.getPret() * medComanda.getCantitate() * 0.9) :
                            medStoc.getPret() * medComanda.getCantitate();
                    System.out.println("Vandut: " + medStoc.getNume() + ", cantitate: " +
                            medComanda.getCantitate() + ", cantitate ramasa pe stoc: " + medStoc.getCantitate());
                    if (medStoc.getCantitate() == 0) {
                        stoc.remove(index);
                    }
            } else {
                System.out.println("Medicamentul " + medComanda.getNume() +
                        " nu se gaseste pe stoc sau cantitatea este insuficienta.");
            }
        }
        System.out.println("Costul total pentru aceasta comanda este: " +
                new DecimalFormat("#.##").format(pretTotal) + " RON");
        stocMedicamente.retainAll(stoc);
        System.out.println("----------------------------");
    }
    public void verificaMedicamenteExpirate(String data) {
        System.out.println("----------------------------");
        LocalDate dataCurenta = LocalDate.parse(data);
        Set<Medicament> medicamenteExpirate = new HashSet<>();

        for(Medicament medCurent : stocMedicamente) {
            if(medCurent.getDataExpirare() != null && medCurent.getDataExpirare().isBefore(dataCurenta)) {
                System.out.println("Medicamentul " + medCurent.getNume() + " este expirat.");
                medicamenteExpirate.add(medCurent);
            }
        }
        stocMedicamente.removeAll(medicamenteExpirate);
        System.out.println("Medicamentele expirate au fost scazute de pe stocul farmaciei.");
        System.out.println("----------------------------");
    }
    public void afiseazaMedicamenteDupaTipDecontare() {
        StringBuilder stocMedDecontate = new StringBuilder();
        StringBuilder stocMedNedecontate = new StringBuilder();

        for(Medicament medCurent : stocMedicamente) {
            if(medCurent.getTipDecontare() == null ||
                    medCurent.getTipDecontare().equals(Medicament.TipDecontare.PLATA_PRET_INTEGRAL)) {
                stocMedNedecontate.append(medCurent.getNume()).append(", ");
            } else {
                stocMedDecontate.append(medCurent.getNume()).append(", ");
            }
        }

        System.out.println("----------------------------");
        System.out.println("Farmacia " + this.nume);
        if(stocMedDecontate.length() > 0) {
            stocMedDecontate.insert(0, "Medicamentele decontate (total sau partial) de pe stoc sunt: ");
            System.out.println(stocMedDecontate.substring(0, stocMedDecontate.length()-2));
        } else {
            System.out.println("Momentan nu sunt medicamente decontate pe stoc.");
        }

        if(stocMedNedecontate.length() > 0) {
            stocMedNedecontate.insert(0, "Medicamentele nedecontate de pe stoc sunt: ");
            System.out.println(stocMedNedecontate.substring(0, stocMedNedecontate.length()-2));
        } else {
            System.out.println("Momentan nu sunt medicamente nedecontate pe stoc.");
        }
        System.out.println("----------------------------");
    }
    public void cautaMedicamentul(String numeMedicament) {
        System.out.println("---------------------------");
        boolean gasit = false;
        for(Medicament medicamentCurent : stocMedicamente) {
            if(medicamentCurent.getNume().equalsIgnoreCase(numeMedicament)) {
                gasit = true;
            }
        }
        if(gasit) {
            System.out.println("Medicamentul " + numeMedicament + " este pe stoc.");
        } else {
            System.out.println("Medicamentul " + numeMedicament + " nu este pe stoc.");
        }
        System.out.println("---------------------------");
    }
    public void afiseazaListaProducatori() {
        System.out.println("---------------------");
        Set<String> listaProducatori = new TreeSet<>();

        for(Medicament medicament : stocMedicamente) {
            listaProducatori.add(medicament.getFirmaProducatoare());
        }

        System.out.println("Lista producatorilor medicamentelor disponibile in farmacia " + this.nume + ": ");
        for(String producator : listaProducatori) {
            System.out.println(producator);
        }
        System.out.println("---------------------");
    }
    public void afiseazaDupaUnitati() {
        System.out.println("---------------------");
        Set<String> medicamenteComprimate = new TreeSet<>();
        Set<String> medicamenteFiole = new TreeSet<>();
        Set<String> medicamenteTablete = new TreeSet<>();

        for(Medicament medicament : stocMedicamente) {
            if(medicament.getUnitateDeMasura().equalsIgnoreCase("Comprimate")) {
                medicamenteComprimate.add(medicament.getNume());
            } else if(medicament.getUnitateDeMasura().equalsIgnoreCase("Fiole")) {
                medicamenteFiole.add(medicament.getNume());
            } else {
                medicamenteTablete.add(medicament.getNume());
            }
        }

        System.out.println("Farmacia " + this.nume);

        if(medicamenteComprimate.isEmpty()) {
            System.out.println("Nu avem medicamente comprimate pe stoc");
        } else {
            System.out.println("Medicamente comprimate de pe stoc: ");
            for(String medicamentPeStoc : medicamenteComprimate) {
                System.out.println(medicamentPeStoc);
            }
        }

        if(medicamenteFiole.isEmpty()) {
            System.out.println("Nu avem medicamente sub forma de fiole pe stoc");
        } else {
            System.out.println("Medicamente sub forma de fiole de pe stoc: ");
            for(String medicamentPeStoc : medicamenteFiole) {
                System.out.println(medicamentPeStoc);
            }
        }

        if(medicamenteTablete.isEmpty()) {
            System.out.println("Nu avem medicamente sub forma de tablete pe stoc");
        } else {
            System.out.println("Medicamente sub forma de tablete de pe stoc: ");
            for(String medicamentPeStoc : medicamenteTablete) {
                System.out.println(medicamentPeStoc);
            }
        }
    }
}


