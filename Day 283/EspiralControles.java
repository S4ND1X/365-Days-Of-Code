import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EspiralControles extends JPanel implements ChangeListener {
	
	private JSlider slider, slider1;
	private Espiral espiral;
	
	public EspiralControles(Espiral espiral) {
		super();
		this.setPreferredSize(new Dimension(100,800));
		this.espiral = espiral;
		this.slider = new JSlider(JSlider.VERTICAL, 0, 50, 30);
		this.slider.setPaintLabels(true);
		this.slider.setPaintTicks(true);
		this.slider.setMajorTickSpacing(10);
		this.slider.setMinorTickSpacing(2);
		this.slider.addChangeListener(this);
		// ----------------------------- Slider 1 --------------------
		this.slider1 = new JSlider(JSlider.VERTICAL, 0, 10, 5);
		this.slider1.setPaintLabels(true);
		this.slider1.setPaintTicks(true);
		this.slider1.setMajorTickSpacing(5);
		this.slider1.setMinorTickSpacing(1);
		this.slider1.addChangeListener(this);
		
		this.setBackground(Color.PINK);
		this.add(slider);
		this.add(slider1);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == this.slider) {
			this.espiral.setAnchoEspiral(this.slider.getValue());
		}else {
			this.espiral.setAnchoDelta(this.slider1.getValue());
		}
		
	}

}
