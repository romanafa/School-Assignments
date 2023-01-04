class Fibonacci:
    def __init__(self, max):
        self.max = max

    def __iter__(self):
        self.a = 0
        self.b = 1
        return self

    def __next__(self):
        fib = self.a
        if fib > self.max:
            raise StopIteration
        self.a, self.b = self.b, self.a + self.b
        return fib


fibonacciNum = []
for i in Fibonacci(1000):
    fibonacciNum.append(i)
print(fibonacciNum)

print("Oppgave 2:")


def genFibonacci(max):
    a, b = 0, 1
    while a < max:
        yield a
        a, b = b, a + b


fibonacciNum = []
for i in genFibonacci(1000):
    fibonacciNum.append(i)
print(fibonacciNum)

print("Oppgave 3:")


import math


class NewInt(int):
    def __new__(cls, value):
        return int.__new__(cls, value)

    def isFibonacci(n):
        return isPerfectSquare(5 * n * n + 4) or isPerfectSquare(5 * n * n - 4)


numbers = []
for i in range(1001):
    numbers.append(NewInt(i))


def isPerfectSquare(x):
    s = int(math.sqrt(x))
    return s * s == x


fibonacciList = [NewInt(i) for i in range(1001) if NewInt(i).isFibonacci()]
print(fibonacciList)


int_list = []
for i in range(100001):
    int_list.append(NewInt(i))

print(int_list)



