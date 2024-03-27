(ns euler.largest-palindrome-product
  (:require [utils.numbers :as u.numbers]))

(defn divisible-by-n-digit-number? [digits number]
  (let [ten-power        (->> digits dec (Math/pow 10) int)
        n-digit-numbers  (->> ten-power (* 10) (range ten-power))
        n-digit-divisors (filter #(and (u.numbers/divisible-by? % number)
                                       (not= % number))
                                 n-digit-numbers)]
    (when (seq n-digit-divisors)
      n-digit-divisors)))

(defn divisible-by-two-n-digit-numbers? [digits number]
  (let [n-digit-divisors (divisible-by-n-digit-number? digits number)
        other-divisors   (map (partial u.numbers/safe-divide number) n-digit-divisors)]
    (some (partial u.numbers/has-n-digits? digits) other-divisors)))

(comment
 (->> (range 10000 998001)
      (filter u.numbers/palindrome?)
      reverse
      (filter (partial divisible-by-two-n-digit-numbers? 3))
      first))
