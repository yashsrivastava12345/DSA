from turtle import *

class Disc(Turtle):
    def __init__(self, n):
        Turtle.__init__(self, shape="square", visible=False)
        self.pu()
        self.shapesize(1.5, n*1.5, 2) 
        self.fillcolor(n/5., 0, 1-n/5.)
        self.st()

class Tower(list):
    def __init__(self, x):
        self.x = x
    def push(self, d):
        d.setx(self.x)
        d.sety(-150+34*len(self))
        self.append(d)
    def pop(self):
        d = list.pop(self)
        d.sety(150)
        return d

def hanoi(n, from_, with_, to_):
    if n > 0:
        hanoi(n-1, from_, to_, with_)
        to_.push(from_.pop())
        hanoi(n-1, with_, from_, to_)

def play():
    onkey(None,"space")
    clear()
    try:
        hanoi(5, t1, t2, t3)
        write("exit now please",align="center", font=("Courier", 16, ("italic","bold","underline")))
        quit()
    except Terminator:
        pass  

def main():
    global t1, t2, t3, t4, t5
    ht(); penup(); goto(0, -225)
    t1 = Tower(-250)
    t2 = Tower(-150)
    t3 = Tower(0)
    t4 = Tower(150)
    t5 = Tower(250)
    for i in range(5,0,-1):
        t1.push(Disc(i))
    write("press spacebar to start",align="center", font=("Courier", 28, ("italic","bold","underline")))
    onkey(play, "space")
    listen()
    return "EVENTLOOP"

if __name__=="__main__":
    msg = main()
    print(msg)
    mainloop()

