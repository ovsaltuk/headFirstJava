public class PhraseOMatic{
    public static void main (String[] args){
        String[] wordListOne =
                {
                        "круглосуточный", "трех-звенный", "30000-футовый", "взаимный","обоюдный выигрыш",
                        "фронтэнд", "на основе веб-технологий", "проникающий", "умный", "шесть сигм",
                        "метод критического пути", "динамичный"
                };
        String[] wordListTwo =
                {
                        "умопомрачительный", "трудный", "чистый продукт", "ориентированный", "центральный",
                        "распределенный", "кластеризованный", "фирменный", "нестандартный ум", "позиционированный",
                        "сетевой", "сфокусированный", "использованный с выгодой", "выровненный", "нацеленный на",
                        "общий", "совместный", "ускоренный"
                };
        String[] wordListThree =
                {
                        "процесс", "пункт разгрузки", "выход из положения", "тип структуры", "талант", "подход",
                        "уровень завоеванного внимания", "портал", "период времени", "обзор", "образец",
                        "пункт следования"
                };
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLenght = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLenght);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
        System.out.println(phrase);
    }
}