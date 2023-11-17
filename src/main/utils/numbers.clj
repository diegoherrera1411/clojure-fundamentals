(ns utils.numbers)

(defn divisible-by? [potential-divisor n]
  (= 0 (mod n potential-divisor)))

(defn divisible-by-any? [numbers n]
  (reduce
    #(or %1 (divisible-by? %2 n))
    false
    numbers))
