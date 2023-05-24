package efs.task.oop;

public class ExtraordinaryVillager extends Villager
{
    public enum Skill
    {
        IDENTIFY,
        SHELTER
    }

    private final Skill skill;

    public ExtraordinaryVillager(String name, int age, Skill skill)
    {
        super(name, age);
        this.skill = skill;
        this.health = 0;
    }

    @Override public void sayHello()
    {
        System.out.printf("Greetings traveler... I'm %s and I'm %d years old. ", name, age);

        if (this.skill == Skill.IDENTIFY)
            System.out.println("I will identify items for you at no charge.");
        else if (this.skill == Skill.SHELTER)
            System.out.println("I can offer you poor shelter");
    }

    @Override public void attack(Fighter victim)
    {
        //deals no damage
    }

    @Override public void takeHit(int damage)
    {
        if (this.health == 0)
            throw new RuntimeException("Dead villager cannot be attacked");

        this.health = 0;
    }
}
