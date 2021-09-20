# CalculationEngine
Let's imagine you hava a list of equations, such as

```
A = 10
B = -A 
C = B+A
```

and want to calculate all the values. Then, using calculation engine from this repo should help you solve this problem.

The engine respects interdependecies and tries to calculate the values in the right order. It would also be able to calculate the reversed order of the equations above

```
C = B+A
B = -A 
A = 10
```

The engine also tries to get advantage of the context when we try calculating the list of values second time. This could be right the next calculation or, alternatively,
we could save the values to a database once we've calculated the context once and then read it when we need to calculate the context next time.

During the 2nd calculation the engine tries to avoid calculating the equation in case no dependencies have changed.

The engine library is in early alpha, so many very basic features are missing.

## Still not implemented

* Check for recursive calls, such as, *C = B* and *B = C*
* Ternary if operator support (or any conditional evaluations being generic)
* Function call support
* Working with strings
* Compilation of equations to speed up the calculation process itself



