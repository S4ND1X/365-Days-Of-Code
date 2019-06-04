import sys
import pygame
import random

#?Define size of the screen
screen_size = width, height = 640, 480
#?Define color
life_color = 254, 127, 156
dead_color = 0, 0, 0
cell_size = 10

class LifeGame:
    def __init__(self):
        pygame.init()        
        #? Display screen
        self.screen = pygame.display.set_mode(screen_size)
        self.clear_screen()
        pygame.display.flip() 
        
        self.init_grids() 

    def init_grids(self):
        num_col = width // cell_size
        
        num_row = height // cell_size
        print(num_col, " ", num_row)
        self.grids = (  [[0] * num_row] * num_col, 
                        [[0] * num_row] * num_col)
        self.active_grid = 0
        print(self.grids[0])


    def randomize_grid(self):
        for cols in self.grids[self.active_grid]:
            for row in self.grids[self.active_grid]
                self.grids[self.active_grid][col][row] = random.randint(0,1)
    def clear_screen(self):
        self.screen.fill(dead_color)

    def update_generation(self):
        #?Inspect current grid
        #?Update inactive grid
        #?Swap active grid
        print("hi")    
    def draw_grid(self):
        #?Draw a circle
        pygame.draw.circle(self.screen,life_color, (width//2,height//2), 70, 0)      
        pygame.display.flip()

    def handle_event(self):
        for event in pygame.event.get():
            #?If key press pause
            if event.type == pygame.QUIT: sys.exit()

    def run(self):
        self.clear_screen()        
        #?Update the whole screen
        pygame.display.flip() 
        while True:
            self.handle_event()
            self.update_generation()
            self.draw_grid() 
if __name__ == '__main__':
    game = LifeGame()
    game.run()