import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import javax.swing.JFrame;
public class MouseyMousey extends MouseAdapter {
        private int posX, posY;
        private JFrame mainframe;
        
        public MouseyMousey(JFrame f) {
            this.mainframe = f;
        }
        
        private boolean mouseDown = false;
                public void mousePressed(MouseEvent e)
                {
                    
                    posX=e.getX();
                    posY=e.getY();
                    
                    mouseDown = true;
                }
                
                public void mouseDragged(MouseEvent evt)
                {
                    //sets frame position when mouse dragged     
                    if(mouseDown)
                        mainframe.setLocation(new Point(evt.getXOnScreen() - posX,evt.getYOnScreen() - posY));

                }
                
                public void mouseReleased(MouseEvent evennemtn)
                {
                    mouseDown = false;
                }
            }
