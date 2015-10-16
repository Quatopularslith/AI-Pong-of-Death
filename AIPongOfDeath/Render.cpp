#include "Render.h"
#include <glfw3.h>



Render::Render()
{
	paddle.setPos(100,100);
}

void Render::render(){

    glClear(GL_COLOR_BUFFER_BIT);
    glClear(GL_DEPTH_BUFFER_BIT);

	paddle.render();

    glFlush();
}

Render::~Render()
{
    //dtor
}
