package javasort;
//import java.lang.Comparable;

public class Dados implements Comparable<Dados> {

    private String name, origin;
    private int cylinders, horsepower, year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
    @Override
    public int compareTo(Dados outroDado) {
        return this.getName().
                compareTo(outroDado.getName());
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        
        if (o == null || getClass() != o.getClass()) 
            return false;
        
        Dados dados = (Dados) o;
        return name.equals(dados.name);
    }

}
