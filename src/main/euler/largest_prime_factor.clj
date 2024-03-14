(ns euler.largest-prime-factor
  (:require [utils.numbers :as u.numbers]))

(defn multiples-outside-range? [n sorted-int-list]
  (let [last-int (or (last sorted-int-list) 0)]
    (< last-int (* 2 n))))

(defn distinct-and-divisible-by? [n num]
  (and (u.numbers/divisible-by? n num) (not= n num)))

(defn sieve
  [start-prime number-range]
  (let [first-new-prime (some #(when (< start-prime %) %) number-range)]
    (if (multiples-outside-range? start-prime number-range)
      number-range
      (recur first-new-prime (remove (partial distinct-and-divisible-by? start-prime) number-range)))))

(defn prime-numbers-until
  [number]
  (->> (inc number)
       (range 3)
       (sieve 2)
       (cons 2)))

(defn largest-prime-factor [n]
  (let [primes (prime-numbers-until (int (/ n 2)))]
    (some #(when (u.numbers/divisible-by? % n) %) (reverse primes))))

(comment
 (let [base-num 600851475143
       primes   (prime-numbers-until (int (Math/sqrt base-num)))]
   (some #(when (u.numbers/divisible-by? % base-num) %) (reverse primes))))
