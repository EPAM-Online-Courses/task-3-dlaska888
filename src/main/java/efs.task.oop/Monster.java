package efs.task.oop;

public class Monster implements Fighter
{
    private int health;
    private int damage;

    public Monster(int health, int damage)
    {
        if (health <= 0)
            throw new IllegalArgumentException("Health should be greater than 0");

        this.health = health;

        if (damage <= 0)
            throw new IllegalArgumentException("Damage should be greater than 0");

        this.damage = damage;
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

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        if (damage <= 0)
            throw new IllegalArgumentException("Damage should be greater than 0");

        this.damage = damage;
    }

    @Override public void attack(Fighter victim)
    {
        if (this.health == 0)
            throw new RuntimeException("Cannot attack with dead monster");

        victim.takeHit(this.getDamage());
    }

    @Override public void takeHit(int damage)
    {
        if (this.health == 0)
            throw new RuntimeException("Cannot attack dead monster");

        this.setHealth(getHealth() - damage);
    }
}
