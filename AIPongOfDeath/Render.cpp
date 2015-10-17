#include "Render.h"
#include "Box.h"
#include "Main.h"
#include <glfw3.h>

int plx = 10;
int ply = 10;

int prx;
int pry;

Box lBox = Box(screenWidth * .2, screenHeight / 14.4);
Box rBox = Box(screenWidth * .2, screenHeight / 14.4);
Box ball = Box(50, 50);
Physics phys = Physics();

Render::Render()
{
	prx = screenWidth - rBox.width - 10;
	pry = 10;
}

void Render::update(){
	phys.update(ball);
}

void Render::render(){

    glClear(GL_COLOR_BUFFER_BIT);
    glClear(GL_DEPTH_BUFFER_BIT);

	lBox.render();
	lBox.setPos(plx, ply);

	rBox.render();
	rBox.setPos(prx, pry);

	ball.render();

	update();

    glFlush();
}

Render::~Render()
{
    //dtor
}
