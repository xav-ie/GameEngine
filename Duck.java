
public class Duck extends CAvatar

{
    private int m_health, m_lives, m_speed;
    public Duck(String fileName, int x, int y, int z)
    {
        super(fileName,x,y,z);
        m_lives = 3;
        m_health = 100;
        
    }
    public Duck(String fileName, int x, int y, int z, int lives, int health)
    {
        super(fileName,x,y,z);
        m_lives = lives;
        m_health = health;
    }
    public void collision(int x, int y, SpriteArrayList sList)
    {
        for(CSprite s : sList)
            if (s != this)  // collision with some other sprite
            {
                if (s instanceof Bullet)
                {
                    System.out.println("Lives: "+m_lives+"\nHealth: "+m_health);
                    this.hit(10);
                    Canvas.removeSprite(s);
                }
                if (s instanceof PowerUp)
                {
                    if (s.getType()=="tiny") 
                    {
                        int x1 = m_x;
                        int y1 = m_y;
                        int z1 = m_z;
                        Canvas.removeSprite(this);
                        Duck d2 = new Duck("avatartiny.txt", x1,y1,z1, m_lives, m_health);
                        Canvas.addSprite(d2);
                    }
                }
            }
    }
    public void hit(int points)
    {
        if (points>m_health){m_lives--;} else {m_health-=points;}
        if (m_health<=0) 
        {
            m_health=100;
            m_lives--;
        }
        if (m_lives<=0) Canvas.removeSprite(this);
    }
    public int getHealth(){return m_health;}
    public int getLives(){return m_lives;}
}
