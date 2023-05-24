package efs.task.oop;

import java.util.List;

public class Villager implements Fighter
{
    protected final String name;
    protected int age;
    protected int health;

    public Villager(String name, int age)
    {
        if (name == null || name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty or blank");

        this.name = name;

        if (age <= 0)
            throw new IllegalArgumentException("Age must be higher than 0");

        this.age = age;
        this.health = 100;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public int getDamage()
    {
        return (int) ((100 - age * 0.5) / 10);
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        if (health <= 0)
        {
            this.health = 0;
            return;
        }

        this.health = health;
    }

    public static int GetVillagersHealth(List<Villager> villagers)
    {
        return villagers.stream().mapToInt(Villager::getHealth).sum();
    }

    public void sayHello()
    {
        System.out.printf("Greetings traveler... I'm %s and I'm %d years old%n", name, age);
    }

    @Override public void attack(Fighter victim)
    {
        if (this.health == 0)
            throw new RuntimeException("Cannot attack with dead villager");

        int damage = (int) ((100 - age * 0.5) / 10);
        victim.takeHit(damage);
    }

    @Override public void takeHit(int damage)
    {
        if (this.health == 0)
            throw new RuntimeException("Dead villager cannot be attacked");

        this.setHealth(this.getHealth() - damage);
    }
}
