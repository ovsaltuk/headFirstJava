import java.util.*;

public class DotComBust {
    // объявляем и инициализируем переменные, которые нам понадобятся
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame(){
        //
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.addAll(Arrays.asList(one, two, three));


        //выводим краткие инструкции для пользователя
        System.out.println("Ваша цель - потопить \"три сайта\".");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComToSet : dotComsList){//повторяем с каждым объектом дотком в списке
            ArrayList<String> newLocation = helper.placeDotCom(3);// запрашиваем у вспомогательного объекта адрес сайта
            dotComToSet.setLocationCells(newLocation);// вызываем сеттер из объекта дотком чтобы передать
            //ему местоположение которое тольок что получили от вспомогательного объекта
        }
    }

    private void startPlaying(){
        while (!dotComsList.isEmpty()){// до тех пор пока список сайтов не пустой
            String userGuess = helper.getUserInput("Сделайте ход");//получаем пользовательский ввод
            checkUserGuess(userGuess);// вызываем метод checkUserGuess
        }
        finishGame();//вызываем метод finishGame
    }



    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComToTest : dotComsList){
            result = dotComToTest.checkYourSelf(userGuess);
            if(result.equals("Попал")){
                break;
            }
            if (result.equals("Потопил")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18){
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули");
        }else{
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
