# Largest prime factor

> The prime factors of 13195 are 5, 7, 13 and 19. 
> What is the largest prime factor of the number 600851475143?

## My Solution

I wanted to get super fancy, and thought that would implement Erathostenes 
sieve just for fun. The algorithm is inherently recursive:

>1. Define a set of numbers 1..N, and a starting prime m
>2. Remove the multiples from m of this set
>3. Take the first element of the resulting set that is larger than m, 
>   reset m to this
>4. Iterate with the remaining set and the new m value

This would compute the list of prime numbers upt to N. I implemented this
algorithm in clojure, and still is pretty slow. Finding primes is not easy.
Then simply finding from the list of primes which divides the number in the
problem yields the result

> **IMPORTANT**: In the case posed by the project euler, this was not 
> necessary. A simple iteration over the integers until the number would
> have been enough. But I've wanted to implement the sieve for so long in
> clojure. So I might as well have fun :).