#include "Paddle.h"
#include <glfw3.h>

GLfloat x, y;
GLfloat width, height;

Paddle::Paddle(GLfloat h, GLfloat w)
{
    width = w;
    height = h;
}

void Paddle::render(){

	glPushMatrix();
		glBegin(GL_QUADS);

			glVertex2f(x, y);
			glVertex2f(x, y + height);
			glVertex2f(x + width, y + height);
			glVertex2f(x + width, y);

		glEnd();
	glPopMatrix();

}

void Paddle::setPos(GLfloat x1, GLfloat y1){

    x = x1;
    y = y1;

}

Paddle::~Paddle()
{
    //dtor
}
