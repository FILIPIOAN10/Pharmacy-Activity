import java.time.LocalDate;

public class Medicament {
    private String nume;
    private double pret;
    private String unitateDeMasura;
    private String firmaProducatoare;
    private TipDecontare tipDecontare;
    private LocalDate dataExpirare;


    private boolean necesitaPrescriptie;
    private int cantitate;

    public enum TipDecontare {DECONTAT_CAS_INTEGRAL,
        DECONTAT_CAS_PARTIAL,
        PLATA_PRET_INTEGRAL}
    public enum UnitateDeMasura {
        COMPRIMATE, TABLETE, FIOLE
    }

    public Medicament(String nume, double pret, String firmaProducatoare, UnitateDeMasura unitateDeMasura) { // Medicament in farmacie
        this.nume = nume;
        this.pret = pret;
        this.cantitate = 0;
        this.firmaProducatoare = firmaProducatoare;
        this.unitateDeMasura = setUnitateDeMasura(unitateDeMasura);
    }
    public Medicament(String nume, int cantitate) {  // medicament pentru comanda
        this.nume = nume;
        this.cantitate = cantitate;
    }

    public String setUnitateDeMasura(UnitateDeMasura unitateDeMasura) {
        String unitateMed = "";
        switch(unitateDeMasura) {
            case FIOLE:
                unitateMed = "Fiole";
                break;
            case TABLETE:
                unitateMed = "Tablete";
                break;
            case COMPRIMATE:
                unitateMed = "Comprimate";
                break;
        }
        return unitateMed;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = LocalDate.parse(dataExpirare);
    }
    public void setTipDecontare(TipDecontare tipDecontare) {
        this.tipDecontare = tipDecontare;
    }

    public String getFirmaProducatoare() {
        return firmaProducatoare;
    }
    public String getNume() {
        return nume;
    }
    public double getPret() {
        return pret;
    }
    public int getCantitate() {
        return cantitate;
    }
    public LocalDate getDataExpirare() {
        return dataExpirare;
    }
    public String getUnitateDeMasura() {
        return unitateDeMasura;
    }
    public TipDecontare getTipDecontare() {
        return tipDecontare;
    }


}
