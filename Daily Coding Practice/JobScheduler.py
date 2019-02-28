"""
This problem was asked by Apple.
Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
"""

from threading import Thread
import time

def exe_fun(f, n):
    time.sleep(n)
    f()

def some_fun(name):
    print("\t Hey {}".format(name))

job = Thread(target=exe_fun, args=(lambda: some_fun('from thread '), 0.01))
job.start()

print('Before')
time.sleep(0.03)
print('After')