package by.it.tryAgain.jd01_08.films;

public class Historical extends Native implements Film {

    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void play() {
        System.out.println(genre);
    }

    @Override
    public String toString() {
        return " {" + super.toString() + ", " +
                "genre '" + genre + '\'' +
                '}';
    }
}
