void initialize()
        {
                setTitle("Game Tutorial");
                setSize(windowWidth, windowHeight);
                setResizable(false);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(true);

                insets = getInsets();
                setSize(insets.left + windowWidth + insets.right,
                                insets.top + windowHeight + insets.bottom);

                backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
                input = new InputHandler(this);
        }

        /**
         * This method will check for input, move things
         * around and check for win conditions, etc
         */