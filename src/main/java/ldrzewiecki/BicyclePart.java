package ldrzewiecki;

public class BicyclePart {

    /* TODO
    category - jest to typ wyliczeniowy, czyli z góry wiesz jakie wartosci bedzie przyjmowal.
    W JAVA do typow wyliczeniowych uzywa sie typu Enum - zastąp String z enum - zmień typ pola ze String, na typ, który sam utworzysz o nazwie
    BicyclePartCategory, albo lepszej
     */
    //public enum BicyclePartCategory {CRANK, REARDERAILLEUR, FRONTDERAILLEUR, WHEELS, BRAKES}
    private String category;
    private String name;

   // public BicyclePart(BicyclePartCategory category, String name){this.category = category; this.name = name;}


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){return "Bicycle part: " + category + " " + name;}
}
