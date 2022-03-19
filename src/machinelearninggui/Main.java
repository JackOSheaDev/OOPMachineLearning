package machinelearninggui;

public class Main
{
    static View display = new View();
    static Model data = new Model();

    public static void main(String[] args)
    {
        Controller main = new Controller(display,data);

    }
}
