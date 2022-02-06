import java.util.ArrayList;

public class Clube {

    public String Designação;
    public ArrayList<Jogador> Jogadores;
    public Clube(){}

    public Clube(String designação,ArrayList<Jogador> jogadores)
    {
        this.Designação=designação;
        this.Jogadores=jogadores;
    }

    public String getDesignação()
    {
        return (this.Designação);
    }
    public void setDesignação(String designação)
    {
        this.Designação=designação;
    }
    public ArrayList<Jogador> getJogadores()
    {
        return (this.Jogadores);
    }
    public void setJogadores(ArrayList<Jogador>jogadores)
    {
        this.Jogadores=(ArrayList<Jogador>) jogadores.clone();
    }
    public double SalarioAnualTotal()
    {
        int total=0;
        for(Jogador a: this.Jogadores)
        {
            total+=a.SalarioAnual();
        }
        return (total);
    }
    public int NTotalJogadores()
    {
        int totalJogadores=0;
        for(Jogador a: Jogadores) {
            totalJogadores++;
        }
        return totalJogadores;
    }
}
