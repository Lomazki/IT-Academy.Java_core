package by.it.tryAgain.jd01_08.films;

public class Run {

    public static void main(String[] args) {

        Comedy comedy = new Comedy();
        Historical historical = new Historical();

        comedy.setName("DeadPull");
        historical.setName("Ivan IV");
        comedy.setYearRelease(2022);
        historical.setYearRelease(2021);

        comedy.setGenre("Comedy");
        comedy.play();
        System.out.println(comedy);
        historical.setGenre("Historical");
        historical.play();
        System.out.println(historical);
    }
}
