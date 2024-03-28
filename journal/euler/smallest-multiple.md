# Smallest multiple

> 2520 is the smallest number that can be divided by each of the numbers from 1
> to 10 without any remainder. What is the smallest positive number that is evenly divisible by all the numbers from
> 1 to 20?

## My solution

The solution is kinda straightforward, when you think in terms of prime factor decomposition.
All you have to do is find the prime numbers in that range. Now, each number in the range would
contain one of the primes in the list some number of times. This number I call the *multiplicity*
of a given prime number inside that number in the range. You can compute that using the following
clojure utility

```clojure
(defn multiplicity [dividend divisor]
  (->> (iterate #(* divisor %) divisor)
       (take-while #(divisible-by? % dividend))
       count))
```

Note that you could use the logarithm, but it's not obvious how to handle the case when the prime
decomposition of the dividend includes other primes different to the divisor. Once you find the 
multiplicity of all prime numbers in the range inside all the numbers in the range, you can just 
take the maximum multiplicity of each prime number and directly construct the smallest multiple of
the numbers in the range.

To find the prime numbers, I used the sieve algorithm developed in a previous problem. Wow, that was
a lot of _numbers_ in a text!