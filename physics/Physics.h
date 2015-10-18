#ifndef PHYSICS_H
#define PHYSICS_H

#include "../graphics/Box.h"

class Physics {
public:

    Physics();

    void update(Box &);

    virtual ~Physics();
};

#endif