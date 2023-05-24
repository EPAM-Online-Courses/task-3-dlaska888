package efs.task.oop;

public class Monsters
{
    public static final Monster andariel = new Monster(10, 70)
    {
        @Override public void takeHit(int damage)
        {
            super.takeHit(damage);
            monstersHealth = monstersHealth - damage;
        }
    };
    public static final Monster blacksmith = new Monster(100, 25)
    {
        @Override public void attack(Fighter victim)
        {
            victim.takeHit(this.getDamage() + 5);
        }

        @Override public void takeHit(int damage)
        {
            super.takeHit(damage + 5);
            monstersHealth = monstersHealth - (damage + 5);
        }
    };
    private static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

    public static int getMonstersHealth()
    {
        return monstersHealth;
    }
}
