
public class Duck extends CAvatar

{
    private int m_health, m_lives, m_speed;
    int m_counter = 0;
    int m_powerUpCounter = -1;
    String m_currentPowerUp = "";
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
                    this.hit(10);
                    System.out.println("Lives: "+m_lives+"\nHealth: "+m_health);
                    //Canvas.removeSprite(s);
                }
                if (s instanceof PowerUp)
                {
                    if (s.getType()=="tiny") 
                    {
                        m_currentPowerUp = "tiny";
                        m_powerUpCounter = 10;
                        int x1 = m_x;
                        int y1 = m_y;
                        int z1 = m_z;
                        Canvas.removeSprite(this);
                        Duck d1 = new Duck("avatartiny.txt", x1,y1,z1, m_lives, m_health);
                        Canvas.addSprite(d1);
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
    public void animate()
    {
        // Leave this empty so avatar won't move automatically like Sprites
        /*m_counter++;
        if (m_counter%40==0) 
        {
            m_counter=0;
            PowerUp p = new PowerUp(12, 12, 1, new Vector(1, 1), "tiny",10);
            Canvas.addSprite(p);
        }*/
        if (m_powerUpCounter>0)
        {
            if (m_powerUpCounter!=0) 
            {
                m_powerUpCounter--;
            } else {
                // Now reverse effects for each different PowerUp
                if (m_currentPowerUp.equals("tiny"))
                {
                    m_currentPowerUp = "";
                    int x1 = m_x;
                    int y1 = m_y;
                    int z1 = m_z;
                    Canvas.removeSprite(this);
                    Duck d2 = new Duck("avatar.txt", x1,y1,z1, m_lives, m_health);
                    Canvas.addSprite(d2);
                    PowerUp p = new PowerUp(12, 12, 1, new Vector(1, 1), "tiny",10);
                    Canvas.addSprite(p);
                }
            }
        }
        
    }
}
