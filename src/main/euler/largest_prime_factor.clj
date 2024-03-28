(ns euler.largest-prime-factor
  (:require [utils.numbers :as u.numbers]))

(defn largest-prime-factor [n]
  (let [primes (u.numbers/prime-numbers-until (int (/ n 2)))]
    (some #(when (u.numbers/divisible-by? % n) %) (reverse primes))))

(comment
 (let [base-num 600851475143
       primes   (prime-numbers-until (int (Math/sqrt base-num)))]
   (some #(when (u.numbers/divisible-by? % base-num) %) (reverse primes))))
