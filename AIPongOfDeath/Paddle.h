#ifndef PADDLE_H
#define PADDLE_H
#include <glfw3.h>

class Paddle
{
    public:
        Paddle(GLfloat, GLfloat);
        //int x, y;
        //int width, height;
        void render();
        void setPos(GLfloat, GLfloat);
        virtual ~Paddle();
    protected:
    private:
};

#endif // PADDLE_H
