# Multiples of 3 or 5

> If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3 5 6 and 9. 
> The sum of these multiples is 23. Find the sum of all the multiples of or below 1000.

## My Solution

Well the algorithm is pretty straightforward. Just 

> 1. Input a list of natural numbers from 1 to 1000
> 2. Filter those numbers that are multiples of 3 or 5
> 3. Reduce the resulting list using addition operation

The reason I state my solution this way, is that I want to use functional patterns in my
solutions. A common pattern is to use list operations and _reduce_ to specify algorithms
in a declarative way, rather than loops (which are more imperative-like).

## Super Clever solution

Remember that

$$
\sum_{i=1}^{N} n = \frac{N(N+1)}{2}
$$

Which is a simple arithmetic progression. Also, by definition, this formula can be used
for computing the sum of the multiples of any number (see why?). The sum of all the multiples
of 3 up to a number $N'$, is computed using that formula with

$$N = \lfloor \frac{N'}{3} \rfloor$$

Similarly, with the sum of all the multiples of 5 up to $N'$. The multiples of 3 and 5 are all
multiples of 15, since 3 and 5 a relative primes. To avoid accounting for the multiples of
15 twice, that sum should be subtracted from the accumulation of the multiples of 3 plus the one of the
multiples of 5. Hence, it is a simple arithmetic calculation to compute the sum of all multiples of 3 or 5 
up to 1000 (see how?).

> Although this solution is the cleverest if I didn't have a computer, the formula is to weird to
> understand in simple terms. Sometimes, as a developer, clever doesn't mean better. As long as
> performance is acceptable, **readable is always better!**