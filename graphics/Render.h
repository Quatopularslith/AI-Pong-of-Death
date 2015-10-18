#ifndef RENDER_H
#define RENDER_H

#include "Box.h"
#include "../physics/Physics.h"

extern int plx;
extern int ply;

extern int prx;
extern int pry;

extern Box lBox;
extern Box rBox;
extern Box ball;
extern Physics phys;

class Render {
public:
    Render();

    void update();

    ~Render();

    void render();

    //Box lBox = Box(screenWidth * .2, screenHeight / 14.4);
    //Box rBox = Box(screenWidth * .2, screenHeight / 14.4);

protected:
private:
};

#endif // RENDER_H
