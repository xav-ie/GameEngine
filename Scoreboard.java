
public class Scoreboard extends CSprite
{
    private int m_score = 0;
    private String m_label;

    public Scoreboard(String label, int x, int y, int z)
    {
        super(x,y,z);
        m_label = label;
        updateScore();
    }

    public void reset()
    {
        m_score = 0;
    }

    public void add(int points)
    {
        m_score += points;
        updateScore();
    }
    
    private void updateScore()
    {
        String temp = m_label+m_score;
        m_map = new char[1][temp.length()];
        for (int idx=0; idx<temp.length(); idx++) m_map[0][idx] = temp.charAt(idx);
    }
}
