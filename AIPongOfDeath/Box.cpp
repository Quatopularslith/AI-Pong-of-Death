#include "Box.h"
#include <glfw3.h>

Box::Box(GLfloat h, GLfloat w)
{
    Box::width = w;
    Box::height = h;
	Box::x = 200;
	Box::y = 200;
}

void Box::render(){

	glPushMatrix();
		glBegin(GL_QUADS);

			glVertex2f(Box::x, Box::y);
			glVertex2f(Box::x, Box::y + Box::height);
			glVertex2f(Box::x + Box::width, Box::y + Box::height);
			glVertex2f(Box::x + Box::width, Box::y);

		glEnd();
	glPopMatrix();

}

void Box::setPos(GLfloat x1, GLfloat y1){
	Box::x = x1;
	Box::y = y1;
}

Box::~Box()
{
    //dtor
}
