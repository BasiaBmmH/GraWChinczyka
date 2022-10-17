import java.util.Scanner;

public class ChinczykGame {
    static char bPole = '\u25A0'; //biale pole
    static char cPole = ' '; //czarne pole
    static char pionek1 = '%'; //zaczyna na 0
    static char pionek2 = '@'; //zaczyna na 10
    static char pionek3 = '#'; //zaczyna na 20
    static char pionek4 = 'X'; //zaczyna na 30

    static char[] gracze = {pionek1, pionek2, pionek3, pionek4};
    static char[] gracz1Baza = {pionek1, pionek1, pionek1, pionek1};
    static char[] gracz2Baza = {pionek2, pionek2, pionek2, pionek2};
    static char[] gracz3Baza = {pionek3, pionek3, pionek3, pionek3};
    static char[] gracz4Baza = {pionek4, pionek4, pionek4, pionek4};

    static char[][] Bazy = {gracz1Baza, gracz2Baza, gracz3Baza, gracz4Baza};

    static int[] Punkty = {0, 0, 0, 0}; //z iloma pionkami sie konczy
    static int[] pozaBaza = {0, 0, 0, 0}; //ile pionkow gracza jest 'w grze'(poza baza)

    static int ruch = 0; //czyj ruch-1

    static int iluGraczy = 4; //ilu graczy jest w grze

    public static void main(String[] args) {
        System.out.println("Plansza:");
        char[] plansza = {bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole,
                bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole, bPole,
                bPole, bPole, bPole, bPole, bPole, bPole};

//        String[] nr = {" ", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", "11"};
//        char[][] plansza = {
//                {'A', cPole, cPole, cPole, cPole, plansza[38], plansza[39], plansza[0], cPole, cPole, cPole, cPole},
//                {'B', cPole, pionek1, pionek1, cPole, plansza[37], cPole, plansza[1], cPole, pionek2, pionek2, cPole},
//                {'C', cPole, pionek1, pionek1, cPole, plansza[36], cPole, plansza[2], cPole, pionek2, pionek2, cPole},
//                {'D', cPole, cPole, cPole, cPole, plansza[35], cPole, plansza[3], cPole, cPole, cPole, cPole},
//                {'E', plansza[30], plansza[31], plansza[32], plansza[33], plansza[34], cPole, plansza[4], plansza[5], plansza[6], plansza[7], plansza[8]},
//                {'F', plansza[29], cPole, cPole, cPole, cPole, cPole, cPole, cPole, cPole, cPole, plansza[9]},
//                {'G', plansza[28], plansza[27], plansza[26], plansza[25], plansza[24], cPole, plansza[14], plansza[13], plansza[12], plansza[11], plansza[10]},
//                {'H', cPole, cPole, cPole, cPole, plansza[23], cPole, plansza[15], cPole, cPole, cPole, cPole},
//                {'I', cPole, pionek3, pionek3, cPole, plansza[22], cPole, plansza[16], cPole, pionek4, pionek4, cPole},
//                {'J', cPole, pionek3, pionek3, cPole, plansza[21], cPole, plansza[17], cPole, pionek4, pionek4, cPole},
//                {'K', cPole, cPole, cPole, cPole, plansza[20], plansza[19], plansza[18], cPole, cPole, cPole, cPole}
//        };


        rysowaniePlanszy(plansza);
        ruch(plansza);

    }

    public static void rysowaniePlanszy(char[] plansza) {
        System.out.println();

        String puste5 = "     ";
        String puste6 = "      ";
        String s15 = puste5 + puste5 + puste5;
        System.out.println("Gracz 4   " + puste5 + plansza[38] + "  " + plansza[39] + "  " + plansza[0] + " 0" + puste5 + "Gracz 1");
        System.out.println(puste6 + gracz4Baza[0] + "  " + gracz4Baza[1] + puste5 + plansza[37] + puste5 + plansza[1] + puste5 + gracz1Baza[0] + "  " + gracz1Baza[1]);
        System.out.println(puste6 + gracz4Baza[2] + "  " + gracz4Baza[3] + puste5 + plansza[36] + puste5 + plansza[2] + puste5 + gracz1Baza[2] + "  " + gracz1Baza[3]);
        System.out.println(s15 + plansza[35] + puste5 + plansza[3]);
        System.out.println("30 " + plansza[30] + "  " + plansza[31] + "  " + plansza[32] + "  " + plansza[33] + "  " + plansza[34] + puste5 + plansza[4] + "  " + plansza[5] + "  " + plansza[6] + "  " + plansza[7] + "  " + plansza[8]);
        System.out.println("   " + plansza[29] + s15 + puste5 + puste5 + "    " + plansza[9]);
        System.out.println("   " + plansza[28] + "  " + plansza[27] + "  " + plansza[26] + "  " + plansza[25] + "  " + plansza[24] + puste5 + plansza[14] + "  " + plansza[13] + "  " + plansza[12] + "  " + plansza[11] + "  " + plansza[10] + " 10");
        System.out.println("Gracz 3   " + puste5 + plansza[23] + puste5 + plansza[15] + "  " + puste5 + "Gracz 2");
        System.out.println(puste6 + gracz3Baza[0] + "  " + gracz3Baza[1] + puste5 + plansza[22] + puste5 + plansza[16] + puste5 + gracz2Baza[0] + "  " + gracz2Baza[1]);
        System.out.println(puste6 + gracz3Baza[2] + "  " + gracz3Baza[3] + puste5 + plansza[21] + puste5 + plansza[17] + puste5 + gracz2Baza[2] + "  " + gracz2Baza[3]);
        System.out.println(puste6 + puste6 + "20 " + plansza[20] + "  " + plansza[19] + "  " + plansza[18]);
    }

    public static void ruch(char[] plansza) {
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        while (!end) { // poki ktos nie wygra
            System.out.println("Ruch gracza: " + (ruch + 1));

            int rzut = (int) ((Math.random() * 6) + 1);
            System.out.println("Wyrzucono: " + rzut);

            if (pozaBaza[ruch] == 0) {
                for (int i = 0; i < 2 && rzut != 6; i++) {
                    rzut = (int) ((Math.random() * 6) + 1);
                    System.out.println("Wyrzucono: " + rzut);
                }
                if (rzut != 6) {
                    System.out.println("Nie mozesz sie ruszyc");
                    System.out.println();
                    ruch++;
                    if (ruch == iluGraczy) ruch = 0;
                    continue;
                }
            }

            if (rzut == 6 && pozaBaza[ruch] + Punkty[ruch] < 4) System.out.println("Wpisz '-1', aby wyjsc z bazy: ");

            while (true) {
                System.out.print("Ruch z: ");

                int i = scanner.nextInt();

                if (i < -1 || i > 39) { //bledne wspolrzedne
                    System.out.println("Błędna wspolrzedna");
                    continue;
                }
                int gdzie;
                if (i == -1) {
                    if (rzut != 6) {
                        System.out.println("Musisz wyrzucic 6, aby moc opuscic baze");
                        continue;
                    }
                    gdzie = 10 * ruch;
                } else {
                    if (plansza[i] != gracze[ruch]) {
                        System.out.println("Nie masz pionka na polu: " + i);
                        continue;
                    }
                    gdzie = i + rzut;
                    if (gdzie >= plansza.length) gdzie -= plansza.length;
                    if (i < ruch * 10 && gdzie >= ruch * 10) {
                        Punkty[ruch]++;
                        pozaBaza[ruch]--;
                        System.out.println("Twoj pionek jest w domku");
                        gdzie = -1;

                        if (Punkty[ruch] == 4) {
                            System.out.println("Gracz " + (ruch + 1) + " WYGRYWA!");
                            end = true;
                        }
                    }
                }
                if (gdzie != -1) {
                    if (plansza[gdzie] == gracze[ruch]) {
                        System.out.println("Twoj pionek juz stoi na " + 10 * ruch + " polu");
                        continue;
                    }
                    if (plansza[gdzie] != bPole) {
                        int zbity = -1;
                        if (plansza[gdzie] == pionek1) zbity = 0;
                        else if (plansza[gdzie] == pionek2) zbity = 1;
                        else if (plansza[gdzie] == pionek3) zbity = 2;
                        else if (plansza[gdzie] == pionek4) zbity = 3;

                        if (zbity != -1) {
                            Bazy[zbity][(pozaBaza[zbity]--) - 1] = gracze[zbity];
                            System.out.println("Gracz " + (zbity + 1) + " zostaje zbity");
                        }
                    }

                    plansza[gdzie] = gracze[ruch];

                    if (i == -1) Bazy[ruch][pozaBaza[ruch]++ - Punkty[ruch]] = cPole;
                    else plansza[i] = bPole;
                }

                rysowaniePlanszy(plansza);
                ruch++;
                if (ruch == iluGraczy) ruch = 0;

                break;
            }
        }
    }
}



