package by.it.doNotTouch.kondratev.jd01_03;

public class Runner {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //String  str = scanner.nextLine();
        //double [] mas1 = {3, 4, 7, 43, 56};
        //double [] mas2 = {1, 5, 7, 32, 65};
        //double [] mas3 = merge(mas1,mas2);
        //InOut.printArray(mas3,"V",2);

    }

        private static double[ ] merge(double[ ] part1, double[ ] part2){
            double [] mas = new double[part1.length+part2.length];
            int i=0; int j=0; int k=0;
            while(i<part1.length || j<part2.length) {
                if(part1[i]<part2[j]) {
                    mas[k] = part1[i]; i++;
                    if(i==part1.length) {
                        do {
                            k++;
                            mas[k] = part2[j];
                            j++;}
                        while (j < part2.length) ;
                        break;
                    }
                }
                else { mas[k] = part2[j]; j++;
                    if(j==part2.length) {
                        do {
                            k++;
                            mas[k] = part1[i];
                            i++;}
                        while (i < part1.length) ;
                        break;}
                }
                k++;
            }
            return mas;
        }


}
