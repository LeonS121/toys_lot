import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        ToyList toys1 = new ToyList();
        toys1.addToy(new Toy(20,"Радиоуправляемый робот",2));
        toys1.addToyList(List.of(
                new Toy(5,"Машинка",3),
                new Toy(10,"Лего",6),
                new Toy(10,"Конструктор",7),
                new Toy(3, "мягкая игрушка",4)
        ));
        System.out.println(toys1);
        ParticipantQueue pq = new ParticipantQueue(List.of(
                new Participant("Вася"),
                new Participant("Коля"),
                new Participant("Дима"),
                new Participant("Женя"),
                new Participant("Генна"),
                new Participant("Олеся"),
                new Participant("Ангелина")
        ));

        Raffle raf = new Raffle(pq,toys1);
        System.out.println(raf.currentToys.toString());
        raf.runRaffle();

        System.out.println("\nВероятность пройгрыша\n");
        ParticipantQueue pqloss = new ParticipantQueue();
        for (int i = 1; i <= 10 ; i++){
            pqloss.addParticipant(new Participant());
        }
        Raffle raf2 = new Raffle(pqloss,toys1);
        raf2.setLossWeight(30);
        System.out.println(raf2.currentToys.toString());
        raf2.runRaffle();

        toys1.saveToFile();
    }

}
