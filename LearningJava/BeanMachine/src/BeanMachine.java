public class BeanMachine {
    private static java.util.Scanner input = new java.util.Scanner(System.in);
    private static java.util.Random random = new java.util.Random();
    private static int numberOfSlots;

    public static void main(String[] args) {
        System.out.print("Oppgi antall baller: ");
        int numberOfBalls = input.nextInt();

        System.out.print("Oppgi antall spor:   ");
        numberOfSlots = input.nextInt();

        // Lager en array som vil holde antall ball for hver "spor" i maskinen.
        int[] slots = new int[numberOfSlots];

        // Påkaller metoden som vil generere en tilfeldig sti for èn ball gjennom maskinen.
        // Returverdien fra metoden som er posisjonsindeksen til ballen i maskinen blir da
        // brukt for å inkrementere antall ball for den gitte "sporet" i arrayet.
        for (int i = 0; i < numberOfBalls; i++) {
            slots[getPathForOneBall()]++;
        }

        // Til slutt bruker vi metoden printResult for å vise fram ballene i maskinen.
        printResult(slots);
    }

    private static int getPathForOneBall() {
        // Vi antar at sluttposisjonen er 0, dvs. at ballen faller til venstre hele veien
        int position = 0;

        // Dersom n er antallet spor i maskinen så er n-1 antall lag med spikrer som ballen
        // må treffe, derfor for løkken genrerer sti som er en mindre enn antall spor
        for (int i = 0; i < numberOfSlots - 1; i++) {
            // Genrerer en tilfeldig verdi mellom 0 og 99 som bestemmer hvor ballen skal gå.
            if (random.nextInt(100) < 50) {
                // Dersom ballen går til venstre posisjonen forandres ikke.
                System.out.print("L");
            } else {
                // Dersom ballen går til høyre så skrifter vi posisjonen en hakk til høyre.
                System.out.print("R");
                position++;
            }
        }

        System.out.println();

        return position;
    }

    private static void printResult(int[] slots) {
        // Variablen definerer hvilket spor som har flest baller.
        int maxBallCount = max(slots);

        // Løkken går stegvis nedover radene i "sporene".
        // i betegner raden som jeg skriver resultatet for.
        for (int i = maxBallCount; i > 0; i--) {
            System.out.println();

            // Så sjekker jeg hver "spor" i arrayet og ser om verdien i sporet er større enn
            // gjeldende verdi for i, hvis så skriver jeg ut en ball, eller en tom rom.
            for (int j = 0; j < numberOfSlots; j++) {
                if (slots[j] < i) {
                    System.out.print("   ");
                } else {
                    System.out.print(" O ");
                }
            }
        }

        System.out.println();

        // Dette er bare pynteutskrift som skriver ut nummeret for hvert "spor".
        for (int i = 0; i < numberOfSlots; ) {
            System.out.printf("|%d|", i++);
        }
    }

    private static int max(int[] slots) {
        // Antar at første "sporet" holder mest baller.
        int result = slots[0];

        // Dersom en annen "spor" holder mer så erstatter man result med antall ball i
        // gjeldende "sporet".
        for (int i = 1; i < numberOfSlots; i++) {
            if (slots[i] > result) {
                result = slots[i];
            }
        }

        return result;
    }
}
