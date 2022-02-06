public class Jogador {

    public String Nome;
    public int Idade;
    public String Morada;
    public double Peso;
    public double Altura;
    public int NCamisola;
    public String Posição;
    public double Remuneração;
    public Jogador(){}
    public Jogador(String nome,int idade,String morada,double peso,double altura,int nCamisola,String posição,double renumeração)
    {
        this.Nome=nome;
        this.Idade=idade;
        this.Morada=morada;
        this.Peso=peso;
        this.Altura=altura;
        this.NCamisola=nCamisola;
        this.Posição=posição;
        this.Remuneração=renumeração;

    }
    public double SalarioAnual()
    {
        return (Remuneração*14);
    }
    public double MassaCorporal()
    {
        return (Peso/(Altura*Altura));
    }
    public String getNome()
    {
        return (this.Nome);
    }
    public int getIdade()
    {
        return (this.Idade);
    }
    public String getMorada()
    {
        return (this.Morada);
    }
    public double getPeso()
    {
        return (this.Peso);
    }
    public double getAltura()
    {
        return (this.Altura);
    }
    public int getNCamisola()
    {
        return (this.NCamisola);
    }
    public String getPosição()
    {
        return (this.Posição);
    }
    public double getRemuneração()
    {
        return (this.Remuneração);
    }

    public void setNome(String nome)
    {
        this.Nome=nome;
    } public void setIdade(int idade)
    {
        this.Idade=idade;
    } public void setMorada(String morada)
    {
        this.Morada=morada;
    } public void setPeso(double peso)
    {
        this.Peso=peso;
    } public void setAltura(double altura)
    {
        this.Altura=altura;
    } public void setNCamisola(int nCamisola)
    {
        this.NCamisola=nCamisola;
    } public void setPosição(String posição)
    {
        this.Posição=posição;
    } public void setRenumeração(double remuneração)
    {
        this.Remuneração=remuneração;
    }

    public String toString(){
        String s=this.Nome + ", \n";
        s +=" Idade: "+ this.Idade + ", \n";
        s +=" Posição: "+this.Posição + ", \n";
        s +=" Peso: "+this.Peso + ", \n";
        s +=" Altura: "+this.Altura + ", \n";
        s +=" Salario Anual:  "+this.SalarioAnual() + ", \n";
        s +=" Indice Massa Corporal: "+this.MassaCorporal() + ", \n";
        s +=" Morada: "+this.Morada + ", \n";
        s +=" Peso: "+this.Peso + ", \n";
        s +=" Altura: "+this.Altura + ", \n";
        s +=" Nº Camisola: "+this.NCamisola + ", \n";
        s +=" Posição: "+this.Posição + ", \n";
        s +=" Remuneração: "+this.Remuneração + ", \n";
        s +="-----------------------------------------------------------";
        return s;
    }
}
