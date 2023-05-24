package efs.task.oop;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {

        Villager kashya = (new Villager("Kashya", 30));
        ExtraordinaryVillager akara = (new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER));
        Villager gheed = (new Villager("Gheed", 50));
        ExtraordinaryVillager deckardCain = (new ExtraordinaryVillager("Deckard Cain",
                85,
                ExtraordinaryVillager.Skill.IDENTIFY));
        Villager warriv = (new Villager("Warriv", 35));
        Villager flawia = (new Villager("Flawia", 25));

        List<Villager> villagers =
                new ArrayList<>()
                {{
                    add(kashya);
                    add(akara);
                    add(gheed);
                    add(deckardCain);
                    add(warriv);
                    add(flawia);
                }};

        villagers.forEach(Villager::sayHello);

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;

        /*
         nie można - kompilator nie widzi metod zawartych w ExtraordinaryVillager, ponieważ zmienne referuja do Object
         objectDeckardCain.sayHello();
         objectAkara.sayHello();
        */

        int i = 0;
        int villagersCount = villagers.size();
        while (Monsters.getMonstersHealth() > 0 && Villager.GetVillagersHealth(villagers) > 0)
        {
            Fight(villagers.get(i), Monsters.andariel);
            Fight(villagers.get(i), Monsters.blacksmith);

            if (++i == villagersCount)
                i = 0;
        }

        if (Villager.GetVillagersHealth(villagers) == 0)
            System.out.println("Obozowisko pokonane!");
        else
            System.out.println("Obozowisko ocalone!");

        villagers.set(villagers.indexOf(deckardCain), (ExtraordinaryVillager) objectDeckardCain);
        villagers.set(villagers.indexOf(akara), (ExtraordinaryVillager) objectAkara);

        deckardCain.sayHello();
        akara.sayHello();
    }

    private static void Fight(Villager currVillager, Monster monster)
    {
        if (currVillager.getHealth() == 0 || monster.getHealth() == 0)
            return;

        System.out.printf("Potwory posiadaja jeszcze %d punkty życia%n", Monsters.getMonstersHealth());
        System.out.printf("Aktualnie walczacy osadnik to %s%n", currVillager.getName());

        currVillager.attack(monster);

        if (monster.getHealth() == 0)
        {
            System.out.printf("Osadnik %s pokonał potwora!%n", currVillager.name);
            return;
        }

        monster.attack(currVillager);

        if (currVillager.getHealth() == 0)
            System.out.printf("Osadnik %s poległ!%n", currVillager.name);
    }
}

