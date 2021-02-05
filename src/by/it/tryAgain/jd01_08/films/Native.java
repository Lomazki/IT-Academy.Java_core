package by.it.tryAgain.jd01_08.films;

abstract class Native implements Film{
    private String name;
    private int yearRelease;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", yearRelease " + yearRelease ;
    }

}
