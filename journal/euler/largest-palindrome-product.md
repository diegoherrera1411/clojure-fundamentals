# Largest palindrome product

> A palindromic number reads the same both ways. The largest palindrome made from the product of two
2-digit numbers is 9009 = 91 x 99. Find the largest palindrome made from the product of two
3-digit numbers.

## My solution

I brute-forced the search. I created a function that computes whether a number is a palindrome

```clojure
(defn palindrome? [number]
  (let [number-str (str (some-> number int))]
    (= number-str (c-str/reverse number-str))))
```

Since we're trying to find palindromes that are product of two 3-digit numbers, the solution has
to be between 100000 and 998001 = 999 x 999. Then, I created a function that evaluates if a number
is divisible by any n-digit number

```clojure
(defn divisible-by-n-digit-number? [digits number]
  (let [ten-power        (->> digits dec (Math/pow 10) int)
        n-digit-numbers  (->> ten-power (* 10) (range ten-power))
        n-digit-divisors (filter #(and (u.numbers/divisible-by? % number)
                                       (not= % number))
                                 n-digit-numbers)]
    (when (seq n-digit-divisors)
      n-digit-divisors)))
```

This function simply computes the divisors of n digits for a given number. Then, computing if a number
is the product of two n-digit numbers is straightforward. Just validate if for any divisor, the quotient also
has n-digits. With these functions, it's straightforward to validate if a given palindrome is divisible by two
3-digit numbers.