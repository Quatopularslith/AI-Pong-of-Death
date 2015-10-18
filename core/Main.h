#ifndef MAIN_H
#define MAIN_H

extern int screenWidth;
extern int screenHeight;

class Main {

public:

    int main(void);
    ~Main();
private:
    void initGL(void);
};

#endif // MAIN_H
