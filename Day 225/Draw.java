void draw()
{
		Graphics g = getGraphics();

		Graphics bbg = backBuffer.getGraphics();

		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, windowWidth, windowHeight);

		bbg.setColor(Color.BLACK);
		bbg.drawOval(x, 10, 20, 20);

		g.drawImage(backBuffer, insets.left, insets.top, this);
}