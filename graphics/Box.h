#ifndef Box_H
#define Box_H

#include <GLFW/glfw3.h>

class Box {
public:

    GLfloat x, y;
    GLfloat width, height;

    Box(GLfloat, GLfloat);

    void render();

    void setPos(GLfloat, GLfloat);

    virtual ~Box();

protected:
private:
};

#endif // Box_H
