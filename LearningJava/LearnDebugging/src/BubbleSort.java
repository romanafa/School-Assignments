/*
 ** Klassen : BubbleSort - en klasse med en del logiske feil
 */
public class BubbleSort {
    private String [] Liste;    // Arrayet over strenger
    /*
     ** Konstruktør : BubbleSort
     */
    public BubbleSort ()
    {
// Lager listen med 10 posisjoner
        Liste = new String[10];
// Og setter verdier i de 6 første (fra Mummitrollet)
        Liste[0] = "Mummi";
        Liste[1] = "Snorken";
        Liste[2] = "Filifjonka";
        Liste[3] = "Snorkfrøken";
        Liste[4] = "My";
        Liste[5] = "Sniff";
        Liste[6] = "Mumrik";
    }
    /*
     ** print() : Skriver ut innholdet i lista.
     */
    public void print()
    {
        for (int i = 0; i < Liste.length; i++)
            System.out.println("Element nr. " + i + " : " + Liste[i]);
    }
    /*
     ** ByttOm(String, String) : Bytter om innholdet i to strenger
     */
    private void ByttOm(String A, String B)
    {
        String Temp;    // Hjelpevariabel som trengs under byttingen
        Temp = A;       // Innholdet av A inn i Temp
        A = B;          // Innholdet av B inn i A
        B = Temp;       // og innholdet i Temp (opprinnelig A) inn i B
    }
    /*
     ** sortit() : Sorterer arrayen Liste
     */
    private void sortit()
    {
        for (int i = 0; i < Liste.length; i++)
            if (Liste[i].compareTo(Liste[i+1]) > 0)
                ByttOm(Liste[i], Liste[i+1]);
    }
    /*
     ** main() : Hovedprogrammet
     */
    public static void main( String [] args)
    {
// Oppretter objektet B av objekttypen BubbleSort
        BubbleSort B = new BubbleSort();
// Skriver ut innholdet i arrayen
        B.print();
// Sorterer innholdet
        System.out.println("------------\nSortert\n----------");
        B.sortit();
// Skriver ut resultatet av sorteringen
        B.print();
    }
}