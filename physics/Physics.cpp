#include "Physics.h"
#include "../core/Main.h"
#include "../graphics/Render.h"

int vel = 8;
int xVel = 1;
int yVel = -1;

Physics::Physics() {
}

void Physics::update(Box &box) {

    if (box.x >= screenWidth - box.width || box.x <= 0)
        xVel = -xVel;

    if (box.y >= screenHeight - box.height || box.y <= 0)
        yVel = -yVel;

    if (box.x >= screenWidth - box.width)
        //inscrease left score
        ;

    if (box.x <= 0)
        //increase right score
        ;

    if (box.x >= lBox.x && box.x <= lBox.x + lBox.width) if (box.y + box.height >= lBox.y &&
                                                             box.y <= box.y + box.height)
        xVel = -xVel;

    if (box.x + box.width >= rBox.x && box.x <= rBox.x + rBox.width) if (box.y + box.height >= rBox.y &&
                                                                         box.y <= rBox.y + rBox.height)
        yVel = -yVel;

    box.setPos(box.x + (xVel * vel), box.y + (yVel * vel));
}

Physics::~Physics() {
}
