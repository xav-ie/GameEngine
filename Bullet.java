
public class Bullet extends CSprite
{
    private int m_damage = 10;
    public Bullet(String fileName, int x, int y, int z)
    {
        super(fileName, x, y, z);
    }
    public Bullet(String fileName, int x, int y, int z, int damage)
    {
        super(fileName, x, y, z);
        m_damage = damage;
    }
    public void collision(int x, int y, SpriteArrayList sList)
    {
        for(CSprite s : sList)
            if (s != this)  // collision with some other sprite
            {
                Canvas.removeSprite(this);
            }
    }
    public int getDamage(){return m_damage;}
}