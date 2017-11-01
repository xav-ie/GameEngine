import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;

@SuppressWarnings("serial")
public class GameConsole extends JFrame {

    private JPanel m_contentPane;
    private JTextField m_textField;
    private JTextArea m_textArea;

    /**
     * Create the frame.
     */
    public GameConsole(int width, int height, Canvas c)
    {
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int textHeight = getFontMetrics(new Font("monospaced", Font.PLAIN, 12)).getHeight();
        String b = "";
        for (int i=0;i<width;i++)
        {
            b+="a";
        }
        int width1 = getFontMetrics(new Font("monospaced", Font.PLAIN, 12)).stringWidth(b);
        setBounds(100,100,11* width - 33, height * (textHeight+7));
        m_contentPane = new JPanel();
        m_contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(m_contentPane);
        m_contentPane.setPreferredSize(new Dimension(width1,height * (textHeight+6)));
        JScrollPane scrollPane = new JScrollPane();

        m_textField = new JTextField();
        m_textField.setColumns(10);
        GroupLayout gl_m_contentPane = new GroupLayout(m_contentPane);
        gl_m_contentPane.setHorizontalGroup(
            gl_m_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
            .addComponent(m_textField, GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
        );
        gl_m_contentPane.setVerticalGroup(
            gl_m_contentPane.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_m_contentPane.createSequentialGroup()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(m_textField, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE))
        );

        m_textArea = new JTextArea();
        m_textArea.setBackground(Color.BLACK);
        m_textArea.setForeground(Color.WHITE);
        m_textArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        m_textArea.setEditable(false);
        m_textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        m_textArea.addKeyListener(c);
        scrollPane.setViewportView(m_textArea);
        m_contentPane.setLayout(gl_m_contentPane);
    }
    public void setText(String map) { m_textArea.setText(map);};
    
}